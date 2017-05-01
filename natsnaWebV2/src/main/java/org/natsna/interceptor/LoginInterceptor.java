package org.natsna.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.natsna.common.CommonProps;
import org.natsna.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 로그인 처리 인터셉터
 * 
 * @author glqdl
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();

		Object userVO = modelMap.get(CommonProps.userVO);

		if (userVO != null) {
			logger.info("uservo succs");
			session.setAttribute(CommonProps.login, userVO);
			logger.info("session: " + session.toString());
			response.sendRedirect("/dashboard");
		} else {
			logger.info("login fail uservo null");
			response.sendRedirect("/error/auth");
		}

	}

}
