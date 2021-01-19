package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	
	Map<String, Integer> requestCountMap = new HashMap<String, Integer>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("mapinit()");
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCountMap", requestCountMap);
	}

	//filter.doFilter == servlet.service
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//request 객체를 이용하여 요청된 URI 정보를 카운팅
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		
		logger.debug("map dofilter()");
		
		logger.debug("request uri : {}", uri);
		
		//requestCountMap에 uri에 해당 키가 있을수도 있고 없을 수도 있음
		//최초 요청인 경우
		if(requestCountMap.get(uri)==null) {
			requestCountMap.put(uri, 1);
		}
		//최초 요청이 아닌경우 - 과거에 이미 요청이 된 적 있는 경우
		else { 
			int requestCount = requestCountMap.get(uri);
			requestCountMap.put(uri,requestCount+1);
			
		}
		//초기화 메소드를해당 로직 이관(init) Application에 이미 객체의 주소가 저장됨 따라서 처음 Application에 속성을 저장해두면 doFilter에서 변동이있을때마다 값이 바껴도 주소를 참조하기 때문에 값이 계속 바뀜
		/*
		 * ServletContext sc = req.getServletContext();
		 * sc.setAttribute("requestCountMap", requestCountMap);
		 */
		
		//다른 필터가 있을경우 필터로, 필터가 없을 경우 해당 요청을 처리하는 servlet, jsp로 요청 위임
		chain.doFilter(request, response); //얘가 있어야 더이상 필터가없을 시 서블릿 실행
		
	}

	@Override
	public void destroy() {
		
		
	}

}
