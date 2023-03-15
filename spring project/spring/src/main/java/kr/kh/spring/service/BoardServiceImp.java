package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.utils.UploadFileUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikesVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	private boolean checkBoard(BoardVO board) {
		//게시글이 없거나, 게시글 제목이 비어있거나, 내용이 비어있으면
		if(board == null || 
			board.getBo_title() == null|| 
			board.getBo_title().trim().length() == 0 ||
			board.getBo_content() == null )
			return false;
		BoardTypeVO bt = boardDao.selectBoardType(board.getBo_bt_num());
		if(bt == null)
			return false;
		if(bt.getBt_type().equals("이미지"))
			return true;
		if( board.getBo_content() == null|| 
			board.getBo_content().trim().length() == 0)
			return false;
		return true;
	}
	
	private void uploadFiles(MultipartFile [] files, int bo_num) {
		if(files == null || files.length == 0)
			return ;
		//반복문
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0)
				continue;
			String fileName = "";
			//첨부파일 서버에 업로드
			try {
				fileName = UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), //파일명
						file.getBytes()); //실제 파일 데이터
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(fileName);
			//첨부파일 객체를 생성
			FileVO fileVo = new FileVO(file.getOriginalFilename(), fileName, 
					bo_num);
			//다오에게서 첨부파일 정보를 주면서 추가하라고 요청
			boardDao.insertFile(fileVo);
		}
	}
	private void deleteFileList(ArrayList<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0) 
			return;
		for(FileVO file : fileList) {
			if(file == null)
				continue;
			UploadFileUtils.removeFile(uploadPath, file.getFi_name());
			boardDao.deleteFile(file);
		}
		
	}
	
	@Override
	public ArrayList<BoardTypeVO> getBoardType(int authority) {
		return boardDao.selectAllBoardType(authority);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		//회원 정보가 없으면
		if(user == null)
			return false;
		//게시글에 빠진 항목이 있으면 false를 리턴
		if(!checkBoard(board))
			return false;
		board.setBo_me_id(user.getMe_id());
		
		//게시글 등록
		boardDao.insertBoard(board);
		
		uploadFiles(files, board.getBo_num());
		return true;
	}
	

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVO getBoard(int bo_num, MemberVO user) {
		//조회수 증가
		boardDao.updateBoardViews(bo_num);
		//게시글 가져오기
		BoardVO board = boardDao.selectBoard(bo_num); 
		if(board == null)
			return null;
		BoardTypeVO boardType = boardDao.selectBoardType(board.getBo_bt_num());
		//비회원 이상 읽기 가능
		if(boardType.getBt_r_authority() == 0)
			return board;
		//회원이상인 경우 비회원은 못봄
		if(user == null)
			return null;
		//게시글 읽기 권한이 사용자 권한 이하인경우만 조회가능
		if(boardType.getBt_r_authority() <= user.getMe_authority() )
			return board;
		return null;
	}

	@Override
	public ArrayList<FileVO> getFileList(int bo_num) {
		return boardDao.selectFileList(bo_num);
	}

	@Override
	public int updateLikes(MemberVO user, int bo_num, int li_state) {
		//기존에 추천/비추천 정보를 가져옴
		LikesVO likesVo = boardDao.selectLikesById(user.getMe_id(), bo_num);
		//없으면 추가
		if(likesVo == null) {
			//LikesVO 객체를 생성
			likesVo = new LikesVO(li_state, user.getMe_id(), bo_num);
			//생성된 객체를 다오에게 전달해서 insert 하라고 시킴
			boardDao.insertLikes(likesVo);
			//li_state를 리턴
			return li_state;
		}
		
		//있으면 수정
		if(li_state != likesVo.getLi_state()) {
			//현재 상태와 기존 상태가 다르면 => 상태를 바꿔야함
			likesVo.setLi_state(li_state);
			//업데이트
			boardDao.updateLikes(likesVo);
			//li_state를 리턴
			return li_state;
		}
		//현재 상태와 기존상태가 같으면 => 취소
		likesVo.setLi_state(0);
		//업데이트
		boardDao.updateLikes(likesVo);
		//0을 리턴
		return 0;
	}

	@Override
	public LikesVO getLikes(int bo_num, MemberVO user) {
		if(user == null)
			return null;
		return boardDao.selectLikesById(user.getMe_id(), bo_num);
	}

	@Override
	public boolean deleteBoard(int bo_num, MemberVO user) {
		if(user == null)
			return false;
		BoardVO board = boardDao.selectBoard(bo_num);
		if(board == null)
			return false;
		//로그인한 사용자와 작성자가 다르면
		if(!board.getBo_me_id().equals(user.getMe_id()))
			return false;
		ArrayList<FileVO> fileList = boardDao.selectFileList(bo_num);
		deleteFileList(fileList);
		return boardDao.deleteBoard(bo_num) != 0;
	}

	@Override
	public BoardVO getBoardByWriteAuthority(int bo_num, MemberVO user) {
		//게시글 가져오기
		BoardVO board = boardDao.selectBoard(bo_num); 
		if(board == null)
			return null;
		if(user == null)
			return null;
		if(user.getMe_id().equals(board.getBo_me_id()))
			return board;
		return null;
	}

	@Override
	public boolean updateBoard(BoardVO board, MultipartFile[] files, int[] fileNums, MemberVO user) {
		if(board == null || board.getBo_num()<=0)
			return false;
		if(user == null)
			return false;
		//게시글 정보를 가져옴
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//가져온 게시글이 null인지 확인
		if(dbBoard == null)
			return false;
		//게시글 작성자가 로그인한 회원이 맞는지 확인
		if(!dbBoard.getBo_me_id().equals(user.getMe_id()))
			return false;
		//다오에게 게시글 정보를 주면서 수정하라고 요청
		if(boardDao.updateBoard(board) == 0)
			return false;
		
		//추가할 첨부파일을 업로드
		uploadFiles(files, board.getBo_num());
		
		//fileNums를 이용하여 첨부파일 객체를 가져와서 첨부파일 리스트에 추가
		if(fileNums == null || fileNums.length == 0)
			return true;

		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		for(int fileNum : fileNums) {
			FileVO fileVo = boardDao.selectFile(fileNum);
			if(fileVo != null)
				fileList.add(fileVo);
		}
		
		//삭제 첨부파일 리스트를 이용하여 첨부파일 삭제
		deleteFileList(fileList);
		
		
		return true;
	}

	@Override
	public void updateBoardByLikes(int bo_num) {
		boardDao.updateBoardByLikes(bo_num);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(user == null)
			return false;
		if(comment == null)
			return false;
		comment.setCo_me_id(user.getMe_id());
		return boardDao.insertComment(comment) != 0;
	}
}
