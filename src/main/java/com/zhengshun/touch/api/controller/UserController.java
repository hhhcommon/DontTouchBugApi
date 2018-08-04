package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.user.service.DBService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tool.util.NumberUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunshan
 */
@Scope("prototype")
@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserController  extends BaseController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private DBService dbService;

	@RequestMapping( value = "/secret/user/queryByOpenid.htm" )
	public void getSecretUser (
			@RequestParam( value = "openid") String openid)
			throws Exception {
		logger.info( "【/secret/user/queryByOpenid.htm】【inputs】 openid = " + openid );

		Map<String, Object> retMap = dbService.queryRec("select * from secret_user where openid =?", openid);
		retMap.put( Constant.RESPONSE_DATA, retMap );
		retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
//		retMap.put( Constant.RESPONSE_CODE_MSG, MsgU.OPERATE_SUCCESS_MSG );
		logger.info( "【/secret/act/mine/user/getUserInfo.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
		ServletUtils.writeToResponse( response, retMap );

	}
}
