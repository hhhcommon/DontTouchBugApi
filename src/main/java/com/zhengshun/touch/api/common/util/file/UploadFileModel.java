package com.zhengshun.touch.api.common.util.file;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 文件上传model
 * @author xx
 * @version 1.0.2
 * @date 2017年8月16日 上午11:55:07
 * Copyright 杭州融都科技股份有限公司 金融创新事业部 此处填写项目英文简称  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class UploadFileModel {
	
	/**
	 * 处理人
	 */
	private String sysUserName;
	
	/**
	 * 处理时间
	 */
	private Date createTime;
	
	/**
	 * 文件路径
	 */
	private String resPath;
	
	/**
	 * 文件原名称
	 */
	private String oldName;
	
	/**
	 * 文件名称
	 */
	private String fileName;
	
	/**
	 * 文件格式
	 */
	private String fileFormat;
	
	/**
	 * 文件大小
	 */
	private BigDecimal fileSize;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;

	/**
	 * 获取处理人
	 * @return sysUserName
	 */
	public String getSysUserName() {
		return sysUserName;
	}

	/**
	 * 设置处理人
	 * @param sysUserName
	 */
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	/**
	 * 获取处理时间
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置处理时间
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取文件路径
	 * @return resPath
	 */
	public String getResPath() {
		return resPath;
	}

	/**
	 * 设置文件路径
	 * @param resPath
	 */
	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	/**
	 * 获取文件原名称
	 * @return oldName
	 */
	public String getOldName() {
		return oldName;
	}

	/**
	 * 设置文件原名称
	 * @param oldName
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	/**
	 * 获取文件名称
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置文件名称
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获取文件格式
	 * @return fileFormat
	 */
	public String getFileFormat() {
		return fileFormat;
	}

	/**
	 * 设置文件格式
	 * @param fileFormat
	 */
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	/**
	 * 获取文件大小
	 * @return fileSize
	 */
	public BigDecimal getFileSize() {
		return fileSize;
	}

	/**
	 * 设置文件大小
	 * @param fileSize
	 */
	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 获取错误信息
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 设置错误信息
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
