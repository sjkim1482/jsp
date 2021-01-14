package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PagingUser.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// left.jsp : /pagingUser?page=1&pageSize=5
		// == > //pagingUser
		
		//doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을때
		// pagesms 1fh, pageSize 5로 생각을 코드작성
		// 파라미터가 존재하면 해당 파라미터를 이용
		// refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
		request.setCharacterEncoding("UTF-8");
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		logger.debug(pageStr);
		logger.debug(pageSizeStr);

		
		int page = pageStr == null ?  1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr==null ? 5:Integer.parseInt(pageSizeStr); 
		
		
		/*
		 * if(pageStr==null) { page =1;
		 * 
		 * }else { page = Integer.parseInt(pageStr);
		 * 
		 * }
		 */
		/*
		 * if(pageSizeStr==null) { pageSize = 5; }else { pageSize =
		 * Integer.parseInt(pageSizeStr); }
		 * 
		 */
		UserServiceI service = new UserService();
		
		
		
		
		
		
		PageVo vo = new PageVo(page,pageSize);
		Map<String, Object> map = service.selectPagingUser(vo);
		
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double)userCnt/pageSize);
		
		int startPage = 1;
		int endPage = pagination;
		if((page-2)>2) {
			if(page==pagination||page==pagination-1||page==pagination-3) {
				startPage = pagination-4;
			}else{
				startPage = page-2;
			}
			if(startPage+4<pagination) {
				endPage = startPage+4;
			}
		}
		logger.debug("start : {}",startPage);
		if((page+2)<pagination-1) {
			if(page==1) {
				endPage = page+4;
			}else if(page == 2) {
				endPage = page+3;
			}else if(page == 4){
				endPage = page+1;
			}else {
				endPage = page+2;
			}
			if(endPage-4>page) {
				startPage = endPage-4;
			}
		}
		logger.debug("end : {}",endPage);
		
		request.setAttribute("userList", userList);
		request.setAttribute("pagination", pagination);
		request.setAttribute("pageVo", vo);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.getRequestDispatcher("user/pagingUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
