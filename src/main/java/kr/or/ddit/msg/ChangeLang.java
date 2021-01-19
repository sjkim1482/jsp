package kr.or.ddit.msg;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changeLang")
public class ChangeLang extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String lang = request.getParameter("lang");
		
		String uni = "";
		
		String kor ="";
		String eng ="";
		String jap ="";
		String def ="";
		if("ko".equals(lang)) {
			uni="ko";
			kor = "selected='selected'";
		}else if("en".equals(lang)){
			uni="ko";
			eng = "selected='selected'";
		}else if("ja".equals(lang)){
			uni="ko";
			jap = "selected='selected'";
		}else {
			uni="default";
			def = "selected='selected'";
		}
		
		
		
		request.setAttribute("lang", lang);
		request.setAttribute("kor", kor);
		request.setAttribute("eng", eng);
		request.setAttribute("jap", jap);
		request.setAttribute("def", def);
		
		request.getRequestDispatcher("/jstl/selectLang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
