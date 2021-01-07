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

/* web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	//요청 메소드 관련없이 서블릿이 동작하게 하려면??
	//get으로 보내든, post로 보내든
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트가 서버로 요청을 보낼시 브라우저에 의해 같이 전송된 쿠키 정보 확인
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies ) {
			logger.debug("cookie.getName() : {} / cookie.getValue() : {}",cookie.getName(),cookie.getValue());
			
			if(cookie.getName().equals("userid")) {
				Cookie newServerCookie = new  Cookie("newServerCookie", "testValue");
				resp.addCookie(newServerCookie);				
			}
		}
		// 사용자가 userid, pass 파라미터를 전송 했다는 가정으로 개발
		
		// 하나의 파라미터 확인
		logger.debug("하나의 파라미터 확인");
		logger.debug("req.getParameter(\"userid\") : {}", req.getParameter("userid"));
		logger.debug("req.getParameter(\"pass\") : {} ", req.getParameter("pass"));
	
		// 복수개의 값을 갖는 파라미터 확인
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("req.getParameterValues(\"userid\") :  ");
		
		for(String userid : req.getParameterValues("userid")) {
			logger.debug(userid);
		}
		
		// 요청에 담긴 파라미터 이름을 확인
		logger.debug("요청에 담긴 파라미터 이름 확인");
		logger.debug("req.getParameterNames() : ");
		
		Enumeration<String> enumeration =  req.getParameterNames();
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement()); // 얘가 데이터를 꺼내줌
		}
		
		
		// 요청에 담긴 파라미터를 관리하는 맵객체 확인
		logger.debug("요청에 담긴 파라미터를 관리하는 맵객체 확인");
		logger.debug("req.getParameterMap() : ");
		Map<String, String[]> map =  req.getParameterMap();
		Set<String> keys = map.keySet();
		Iterator<String> it =  keys.iterator();
		
		while(it.hasNext()) {
			logger.debug("{}",map.get(it.next()));
		}
		
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
		
		
		if(userid!=null&&pass!=null) {
			if(userid.equals("brown")&&pass.equals("brownpass")) {
				req.getRequestDispatcher(req.getContextPath()+"/main.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
	}
}
















