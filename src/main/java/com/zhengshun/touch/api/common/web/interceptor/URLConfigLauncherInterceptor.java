package com.zhengshun.touch.api.common.web.interceptor;

import com.zhengshun.touch.api.common.model.URLConfig;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 缺省的url映射处理
 * @author zhangyz
 */
public class URLConfigLauncherInterceptor extends HandlerInterceptorAdapter {
	
	private Map<String, URLConfig> urlConfigs;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		for (Entry<String, URLConfig> entry : urlConfigs.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
		return super.preHandle(request, response, handler);
	}

	public Map<String, URLConfig> getUrlConfigs() {
		return urlConfigs;
	}

	public void setUrlConfigs(Map<String, URLConfig> urlConfigs) {
		this.urlConfigs = urlConfigs;
	}
}
