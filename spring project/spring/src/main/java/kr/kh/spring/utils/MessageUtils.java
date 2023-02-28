package kr.kh.spring.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class MessageUtils {
	private static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	public static void alertAndMovePage(HttpServletResponse response,
			String text, String contextPaht, String url) {
		init(response);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>alert('"+text+"');" +
					"location.href='"+contextPaht+url+"'</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
