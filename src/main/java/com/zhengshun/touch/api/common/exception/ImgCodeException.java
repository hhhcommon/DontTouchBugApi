package com.zhengshun.touch.api.common.exception;

/**
 * 图片验证码异常
 * @author lyang
 * @version 1.0
 * @date 2017年4月25日
 * Copyright 杭州融都科技股份有限公司 cashloan All Rights Reserved
 * 官方网站：www.erongdu.com
 * 创新一部：rdc@erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class ImgCodeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	protected static final int IMGCODE_EXCEPTION__CODE = 400;
	
	protected int code;
	
	public ImgCodeException(int code, String businessMessage) {
		this(businessMessage);
	}

	public ImgCodeException(String businessMessage, Throwable cause, int code) {
		this(businessMessage, cause);
	}

	public ImgCodeException(String businessMessage, Throwable cause) {
		super(businessMessage, cause);
		this.code = IMGCODE_EXCEPTION__CODE;
	}

	public ImgCodeException(String message) {
		super(message);
		this.code = IMGCODE_EXCEPTION__CODE;

	}

	public ImgCodeException(Throwable t) {
		this(t.getMessage(), t);
	}
	
	
	
}
