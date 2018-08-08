package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.BaseResponse;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.service.TbUserService;
import com.zhengshun.touch.api.user.service.DBService;
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
public class TbUserController extends BaseController {


    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private TbUserService tbUserService;

    @RequestMapping( value = "/api/user/saveUser.htm" )
    public void saveUser (
            @RequestParam( value = "avatarUrl") String avatarUrl,
            @RequestParam( value = "city") String city,
            @RequestParam( value = "country") String country,
            @RequestParam( value = "gender") Integer gender,
            @RequestParam( value = "language") String language,
            @RequestParam( value = "nickName") String nickName,
            @RequestParam( value = "rdSessionKey") String rdSessionKey,
            @RequestParam( value = "province") String province)
            throws Exception {
        logger.info( "【/api/user/saveUser.htm】【inputs】 avatarUrl = " + avatarUrl + ", city = " + city + ", country = " + country + ", gender = " + gender + ", language = " + language
         + ", nickName = " + nickName + ", rdSessionKey = " + rdSessionKey + ", province = " + province);
        Map<String, Object> result = new HashMap<>();
        if (tbUserService.saveUser( request, avatarUrl, city, country, gender, language, nickName, rdSessionKey,
                province )){
            logger.info("【/api/user/saveUser.htm】【outputs】 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【/api/user/saveUser.htm】【outputs】 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }
}