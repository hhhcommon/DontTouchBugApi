package com.zhengshun.touch.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhengshun.touch.api.common.util.HttpsUtil;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.service.TbUserService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WXRequestController extends BaseController {


    public static final Logger logger = LoggerFactory.getLogger(WXRequestController.class);

    @Resource
    private TbUserService tbUserService;

    @RequestMapping( value = "/api/wx/getOpenId.htm" )
    public void queryOpenId (
            @RequestParam( value = "code") String code,
            @RequestParam( value = "appid") String appid,
            @RequestParam( value = "secret") String secret)
            throws Exception {
        logger.info( "【/api/wx/getOpenId.htm】【inputs】 code = " + code + ", appid = " + appid + ", secret = " + secret );

        Map<String, String> params = new HashMap<>();
        params.put("appid", appid );
        params.put("secret", secret );
        params.put("js_code", code );
        params.put("grant_type", "authorization_code");
        String result = HttpsUtil.postClient("https://api.weixin.qq.com/sns/jscode2session", params);
        logger.info(JSON.toJSONString("wx queryopenid = " + result ));
        params.clear();
        JSONObject jsonObject = JSONObject.parseObject( result );
        params.put("openid", jsonObject.getString("openid"));
        params.put("session_key", jsonObject.getString("session_key"));
        logger.info("【/api/wx/getOpenId.htm】【outputs】  ," + ConvertUtils.convert(
                params));
        ServletUtils.writeToResponse(response, params);


    }



}