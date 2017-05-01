package org.natsna.interceptor;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.natsna.common.CommonProps;
import org.natsna.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(BoardInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		HttpSession session = request.getSession();
//		
//		UserVO vo = (UserVO) session.getAttribute(CommonProps.login);
//		
//		
//		
//		System.out.println("writer: "+request.getAttribute("boardVO"));
//		
//		logger.info("modi_vo: "+vo);
//		logger.info("modi_vo: "+vo.getUserid());
//		
//		response.sendRedirect("/error/auth");
		
		return true;
	}
}
