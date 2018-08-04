package com.zhengshun.touch.api.system.security.authentication.handler;

import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class AccessAuthenticationFailureHandler implements
		AuthenticationFailureHandler {
    
	private static final Logger logger = LoggerFactory.getLogger(AccessAuthenticationFailureHandler.class);
	private String defaultFailureUrl;
	private boolean forwardToDestination = false;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		Map<String, Object> context = new HashMap<String, Object>();
		
		context.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
		context.put(Constant.RESPONSE_CODE_MSG, "登录失败");
		ServletUtils.writeToResponse(response, context);

	}

}