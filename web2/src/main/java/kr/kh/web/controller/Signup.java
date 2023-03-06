package kr.kh.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.web.dao.MemberDAO;
import kr.kh.web.vo.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		MemberVO member = new MemberVO(id, pw);
		MemberDAO memberDao = new MemberDAO();
		if(memberDao.insertMember(member)) {
			request.setAttribute("msg", "회원 가입에 성공했습니다.");
			request.setAttribute("url", "/");
		}
		else {
			request.setAttribute("msg", "회원 가입에 실패했습니다.");
			request.setAttribute("url", "/signup");
			System.out.println("실패");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
