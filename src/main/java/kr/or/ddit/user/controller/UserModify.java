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

@WebServlet("/userModify")
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
	UserServiceI userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		
		UserVo user = userService.selectUser(userid);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("user/userModify.jsp").forward(request, response);
		
	}

	//사용자 정보 수정 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행
		//servlet의 doPost메소드 마다 실행 필요 ==> Filter
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("userNm");
		String pass = request.getParameter("userPass");
		String reg_dtStr = request.getParameter("userRegDt");
		String alias = request.getParameter("userAlias");
		String addr1 = request.getParameter("userAddr1");
		String addr2 = request.getParameter("userAddr2");
		String zipcode = request.getParameter("userZip");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = new Date();
		try {
			reg_dt = sdf.parse(reg_dtStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserVo userVo = new UserVo(userid,usernm,pass,reg_dt,alias,
				addr1,addr2,zipcode);
		
		int updateCnt = 0;
		try {
			updateCnt =  userService.modifyUser(userVo);
		} catch (Exception e) {
			updateCnt = 0;
		}
		
		
//		UserVo userInfo = userService.selectUser(userid);
//		
//		String url = "";
		

		if(updateCnt == 1) {
			response.sendRedirect(request.getContextPath()+"/user?userid="+userid);
		}else {
			doGet(request, response);
		}
		
		
		
		
		/*
		 * if(updateCnt == 1) { url= "/user.jsp"; }else { url= "/userModify.jsp"; }
		 * 
		 * request.setAttribute("user", userInfo);
		 * 
		 * request.getRequestDispatcher("user"+url).forward(request, response);
		 */

//		logger.debug("url : {}",request.getContextPath()+"/user"+url);
//		response.sendRedirect(request.getContextPath()+"/user"+url);
		
		
	}

}
