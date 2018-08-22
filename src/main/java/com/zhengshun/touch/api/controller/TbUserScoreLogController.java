package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.BaseResponse;
import com.zhengshun.touch.api.common.MsgUtils;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.domain.TbGameType;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            @RequestParam( value = "difficut") Integer difficut,
            @RequestParam( value = "steps") String steps)
            throws Exception {
        logger.info( "【/api/user/score/save.htm】【inputs】 userId = " + rdSessionKey + ", score = " + score + ", difficut = " + difficut + ", steps =" + steps);

        if (tbUserScoreLogService.saveUserScore( rdSessionKey, score, time, difficut, steps)) {
            logger.info("【/api/user/score/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【/api/user/score/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }

    @RequestMapping( value = "/api/user/score/1.1.0/save.htm" )
    public void saveUserStars (
            @RequestParam( value = "rdSessionKey") String rdSessionKey,
            @RequestParam( value = "score") BigDecimal score,
            @RequestParam( value = "time") Integer time,
            @RequestParam( value = "difficut") Integer difficut,
            @RequestParam( value = "steps") String steps,
            @RequestParam( value = "stars", required = false ) Integer stars)
            throws Exception {
        logger.info( "【/api/user/score/1.1.0/save.htm】【inputs】 userId = " + rdSessionKey + ", score = " + score + ", difficut = " + difficut + ", steps =" + steps + ", stars =" + stars);

        if (tbUserScoreLogService.saveUserStars( rdSessionKey, score, time, difficut, steps, stars)) {
            logger.info("【/api/user/score/1.1.0/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【/api/user/score/1.1.0/save.htm】【outputs】 rdSessionKey = " + rdSessionKey + " 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }

    @RequestMapping( value = "/api/user/score/rank.htm" )
    public void getrank (
            @RequestParam( value = "rdSessionKey") String rdSessionKey)
            throws Exception {
        logger.info( "【/api/game/type/get.htm】【inputs】  " );

        Map<String, Object> list = tbUserScoreLogService.getRank( rdSessionKey );

        Map<String, Object> retMap = new HashMap<>();

        retMap.put( Constant.RESPONSE_DATA, list );
        retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
        retMap.put( Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info( "【/api/game/type/get.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
        ServletUtils.writeToResponse( response, retMap );


    }

    @RequestMapping( value = "/api/user/stars/rank.htm" )
    public void getStarsRank (
            @RequestParam( value = "rdSessionKey") String rdSessionKey)
            throws Exception {
        logger.info( "【/api/user/stars/rank.htm】【inputs】   rdSessionKey = " + rdSessionKey );

        Map<String, Object> list = tbUserScoreLogService.getStarsRank( rdSessionKey );

        Map<String, Object> retMap = new HashMap<>();

        retMap.put( Constant.RESPONSE_DATA, list );
        retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
        retMap.put( Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info( "【/api/user/stars/rank.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
        ServletUtils.writeToResponse( response, retMap );


    }
}