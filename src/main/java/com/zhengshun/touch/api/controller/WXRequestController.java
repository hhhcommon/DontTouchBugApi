package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.service.WXRequestService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class WXRequestController extends BaseController {


    public static final Logger logger = LoggerFactory.getLogger(WXRequestController.class);

    @Resource
    private WXRequestService wxRequestService;

    @RequestMapping( value = "/api/wx/getOpenId.htm" )
    public void queryOpenId (
            @RequestParam( value = "code") String code,
            @RequestParam( value = "appid") String appid,
            @RequestParam( value = "secret") String secret)
            throws Exception {
        logger.info( "【/api/wx/getOpenId.htm】【inputs】 code = " + code + ", appid = " + appid + ", secret = " + secret );

        Map<String, String> result = wxRequestService.getOpenId( appid, secret, code );

        logger.info("【/api/wx/getOpenId.htm】【outputs】  ," + ConvertUtils.convert(
                result));
        ServletUtils.writeToResponse(response, result);


    }



}