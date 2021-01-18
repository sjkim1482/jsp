package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

/* web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private UserServiceI userService = new UserService();
	//요청 메소드 관련없이 서블릿이 동작하게 하려면??
	//get으로 보내든, post로 보내든
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 성공시 main.jsp로 이동
		//로그인 프로레스
		//db의 저장된 사용자 정보와 일치하느지 검증해야하나, db 연동이 아직 준비되지 않은 관계록
		//userid가 brown일때 비밀번호가 brownpass 인경우에 한해 로그인이 성공되었다고 판단
		//로그인 성공시 : main.jsp로 forward
		//로그인 실패시 : login.jsp로 redirect
		// redirect : 클라이언트에게 정해진 주소로 재요청 할것을 지시
		//				
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		UserVo user = userService.selectUser(userid);
		//로그인 성공 ==> service를 통해 데이터베이스에 저장된 값과 일치할 때
		// session에 데이터베이스에서 조회한 사용자 정보(userVo)를 저장
		
		if( user !=null && pass.equals(user.getPass())) {
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
		
	}
}
















