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


@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/binsert.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btitle = (String)request.getParameter("btitle");
		String bwriter = (String)request.getParameter("bwriter");
		String bcontent = (String)request.getParameter("bcontent");
		
		BoardVO board = new BoardVO(btitle, bwriter, bcontent);
		BoardDAO boardDao = new BoardDAO();
		if(boardDao.insertBoard(board)) {
			response.sendRedirect(request.getContextPath()+"/blist");
		}
		else {
			request.setAttribute("msg", "게시글 등록 실패!!");
			request.setAttribute("url", "/blist");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}
}
