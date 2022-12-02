package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static List<Board> boardList = new ArrayList<Board>();
	private static List<Comment> commentList = new ArrayList<Comment>();
	
	/* 기능
	 *  - 게시글 등록
	 *  - 게시글 수정
	 *  - 게시글 삭제
	 *  - 게시글 목록
	 *  - 게시글 확인
	 *    - 댓글 등록
	 *    - 댓글 확인
	 *    - 이전
	 *  - 프로그램 종료
	 * */
	public static void main(String[] args) {
		
		//메뉴를 출력하고, 
		//메뉴를 입력받아 입력한 메뉴가 프로그램 종료가 아니면 반복하는 코드를 작성
		int menu = -1;
		while(menu != 6) {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}
	}
	
	/** 메뉴를 출력하는 메소드
	 *  1. 게시글 등록
	 *  2. 게시글 수정
	 *  3. 게시글 삭제
	 *  4. 게시글 목록
	 *  5. 게시글 확인
	 *  6. 프로그램 종료
	 *  메뉴 선택 : 
	 * */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록");
		System.out.println("5. 게시글 확인");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	/**runMenu 
	 * 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 * @param menu 선택된 메뉴로 정수
	 */
	public static void runMenu(int menu) {
		switch (menu) {
		case 1: insertBoard();		break;
		case 2: updateBoardList();	break;
		case 3: deleteBoardList();	break;
		case 4: printBoardList();	break;
		case 5: printBoard();		break;
		case 6: System.out.println("프로그램 종료");	break;
		default:
			System.out.println("잘못 선택했습니다.");
		}
	}
	/**insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 */
	public static void insertBoard() {
		//게시글 정보 입력
		int num = inputBoardNum();
		
		//게시글 객체 생성
		Board board = inputBoard(num);
		
		//번호 중복 확인
		if(boardList.contains(board)) {
			System.out.println("이미 등록된 게시글 번호입니다.");
			return;
		}
		//게시글 리스트에 추가
		boardList.add(board);
	}

	/**inputBoardNum : Scanner를 통해 번호를 입력받아 알려주는 메소드
	 * @return 입력받은 게시글 번호
	 */
	public static int inputBoardNum() {
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	
	/**inputBoard : 게시글 번호가 주어지면 제목, 내용, 작성자 입력하여
	 * 				게시글 객체를 반환하는 메소드
	 * @param num 게시글 번호
	 * @return 게시글 객체
	 */
	public static Board inputBoard(int num) {
		System.out.print("제목 : ");
		String title = scan.nextLine();
		
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		//게시글 객체 생성
		return new Board(num, title, contents, writer);
	}
	
	/**updateBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드로 수정하면
	 * 				true를 실패하면 false를 반환 
	 * @param boardList 게시글 리스트
	 * @param board 수정할 게시글
	 * @return 수정 성공 true, 실패 false
	 * */
	public static boolean updateBoard(List<Board>boardList, Board board) {
		if(boardList.size() == 0)
			return false;
		int index = boardList.indexOf(board);
		if(index == -1)
			return false;
		boardList.set(index, board);
		return true;
	}

	/**updateBoardList : 게시글 정보를 입력받아 수정하는 메소드
	 */
	public static void updateBoardList() {
		int num = inputBoardNum();
		Board board = inputBoard(num);
		if(updateBoard(boardList, board)) {
			System.out.println("게시글을 수정 했습니다.");
		}else {
			System.out.println("게시글을 수정하지 못했습니다.");
		}
	}

	/**deleteBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드
	 * @param boardList 게시글 리스트
	 * @param num 삭제할 게시글 번호
	 * @return 삭제 성공 true, 실패 false
	 */
	public static boolean deleteBoard(List<Board>boardList, int num) {
		Board board = new Board(num);
		return boardList.remove(board);
	}
	
	/**deleteBoardList : 게시글 번호를 입력받아 삭제하는 메소드
	 */
	public static void deleteBoardList() {
		int num = inputBoardNum();
		if(deleteBoard(boardList, num))
			System.out.println("게시글을 삭제 했습니다.");
		else
			System.out.println("게시글을 삭제하지 못했습니다.");
		System.out.println(boardList);
	}
	
	/**printBoardList : 게시글 전체를 출력하는 메소드
	 */
	public static void printBoardList() {
		boardList.forEach(b->System.out.println(b));
	}
	
	/**printSubmenu : 게시글 확인에서 필요한 서브 메뉴를 출력
	 */
	public static void printSubmenu() {
		System.out.println("1. 댓글 등록");
		System.out.println("2. 댓글 확인");
		System.out.println("3. 이전");
		System.out.print("메뉴 선택 : ");
	}
	
	/**runPrintSubmenu : 선택한 서브 메뉴를 실행하는 메소드,
	 * 					 우선은 서브메뉴를 선택하면 선택한 서브메뉴를
	 * 					 콘솔에 출력하는 기능으로 일단 구현
	 * @param submenu 선택한 서브 메뉴
	 * @param boardNum 선택한 게시글 번호
	 */
	public static void runPrintSubmenu(int submenu, int boardNum) {
		switch(submenu) {
		case 1:	insertCommentList(boardNum); 	break;
		case 2:	printCommentList(boardNum); 	break;
		case 3:
			System.out.println("이전");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	/**printBoard : 게시글 번호를 입력받아 입력받은 게시글을 출력하고
	 * 				서브메뉴를 출력하고, 서브메뉴를 선택하면
	 * 				선택한 서브 메뉴를 실행하는 메소드
	 */
	public static void printBoard() {
		int num = inputBoardNum();
		Board board = new Board(num);
		int index = boardList.indexOf(board);
		if(index == -1) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		board = boardList.get(index);
		board.print();
		int submenu = -1;
		do {
			printSubmenu();
			submenu = scan.nextInt();
			scan.nextLine();
			runPrintSubmenu(submenu, num);
		}while(submenu != 3);
	}

	/**insertComment : 댓글을 댓글 리스트에 추가하는 메소드
	 * @param commentList 댓글 리스트
	 * @param comment 댓글
	 * @return 댓글 추가 여부
	 */
	public static boolean insertComment(List<Comment> commentList, 
			Comment comment) {
		int index = commentList.indexOf(comment);
		if(index != -1) {
			return false;
		}
		commentList.add(comment);
		return true;
	}
	
	/**insertCommentList : 댓글 정보를 입력받아 댓글을 추가하는 메소드
	 * @param boardNum 선택한 게시글 번호
	 */
	public static void insertCommentList(int boardNum) {
		int num = inputBoardNum();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		
		Comment comment = new Comment(num, contents, writer, boardNum);
		if(insertComment(commentList, comment)) {
			System.out.println("댓글 등록이 완료됐습니다.");
		}else {
			System.out.println("이미 등록된 댓글 번호입니다.");
		}
	}
	
	/**printCommentList : 선택한 게시글에 있는 댓글들을 확인하는 메소드
	 * @param boardNum 게시글 번호
	 */
	public static void printCommentList(int boardNum) {
		if(commentList.size() == 0) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}

		commentList.forEach(c->{
			if(c.getBoardNum() == boardNum) {
				System.out.println(c);
			}
		});
		
	}
}
