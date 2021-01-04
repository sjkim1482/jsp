package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath()+"/jsp/scope.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ServletContext application = getServletContext();
		
		String scope = request.getParameter("scope");
		
		String req =  scope + "_request";
		
		String ses =  scope + "_session";
		
		String app =   scope + "_application";
		
		
		request.setAttribute("request", req );
		session.setAttribute("session", ses );
		application.setAttribute("application", app );

		
		request.getRequestDispatcher(request.getContextPath()+"/jsp/scopeResult.jsp").forward(request, response);
		
	}

}
