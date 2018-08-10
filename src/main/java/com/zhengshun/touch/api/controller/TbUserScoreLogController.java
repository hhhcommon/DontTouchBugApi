package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.BaseResponse;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Controller
public class TbUserScoreLogController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private TbUserScoreLogService tbUserScoreLogService;

    @RequestMapping( value = "/api/user/score/save.htm" )
    public void saveUser (
            @RequestParam( value = "rdSessionKey") String rdSessionKey,
            @RequestParam( value = "score") BigDecimal score,
            @RequestParam( value = "time") Integer time,
            @RequestParam( value = "difficut") Integer difficut)
            throws Exception {
        logger.info( "【/api/user/score/save.htm】【inputs】 userId = " + rdSessionKey + ", score = " + score + ", difficut = " + difficut);

        if (tbUserScoreLogService.saveUserScore( rdSessionKey, score, time, difficut)) {
            logger.info("【/api/user/score/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【/api/user/score/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }
}