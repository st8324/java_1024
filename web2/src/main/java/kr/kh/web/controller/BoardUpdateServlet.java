package kr.kh.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.web.dao.BoardDAO;
import kr.kh.web.dao.MemberDAO;
import kr.kh.web.vo.BoardVO;


@WebServlet("/bupdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/bupdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btitle = (String)request.getParameter("boardtitle");
		String bwriter = (String)request.getParameter("boardwriter");
		String bcontent = (String)request.getParameter("content");
		int bnum = Integer.parseInt(request.getParameter("boardnum"));
		
		BoardVO board = new BoardVO(btitle, bwriter, bcontent);
		board.setBoard_num(bnum);
		System.out.println(board);
		BoardDAO boardDao = new BoardDAO();
		if(boardDao.updateBoard(board)) {
			response.sendRedirect(request.getContextPath()+"/boardDetail");
		}
		else {
			request.setAttribute("msg", "게시글 수정 실패!!");
			request.setAttribute("url", "/boardDetail");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}
}
