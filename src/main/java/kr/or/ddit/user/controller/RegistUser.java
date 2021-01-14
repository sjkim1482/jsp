package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);

	UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("user/registUser.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String userid = request.getParameter("userId");
		String usernm = request.getParameter("userNm");
		String pass = request.getParameter("userPass");
		String alias = request.getParameter("userAlias");
		String addr1 = request.getParameter("userAddr1");
		String addr2 = request.getParameter("userAddr2");
		String zipcode = request.getParameter("userZip");
		
		
		UserVo userVo = new UserVo(userid,usernm,pass,new Date(),alias,
				addr1,addr2,zipcode);
		
		int insertCnt = 0;
		try {
			insertCnt = userService.registUser(userVo);
		} catch (Exception e) {
			insertCnt = 0;
		}
		
		
		
		if(insertCnt == 1) {
			response.sendRedirect(request.getContextPath()+"/pagingUser");
		}else {
			request.setAttribute("userInfo", userVo);
			request.getRequestDispatcher("user/registUser.jsp").forward(request, response);
		}
		
		
		
	}

}
