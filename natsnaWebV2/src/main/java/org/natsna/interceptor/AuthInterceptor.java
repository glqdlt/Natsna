package org.natsna.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.natsna.common.CommonProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 세션에 로그인이 있는지 체크하는 로직이다.
 * 없으면 로그인으로 리다이렉션
 * @author glqdl
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	
	/**
	 * 사용자가 왔던 경로의 추적을 위함, 아직 필요한 기능은 아니기 때문에 구현하지 않음.
	 * @author glqdlt
	 * @param req
	 */
	private void saveDest(HttpServletRequest req){
		
	}
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		logger.info("session ==> : "+session);

		if (session.getAttribute(CommonProps.login) == null) {

			logger.info("로그인 하지 않은 유저의 접속.");

			response.sendRedirect("/user/login");
			
			return false;
		}else{
			logger.info("welcome : "+session.getAttribute(CommonProps.login));
			return true;
			
		}

	}


}
