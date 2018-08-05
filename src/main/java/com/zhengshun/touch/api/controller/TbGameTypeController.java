package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.BaseResponse;
import com.zhengshun.touch.api.common.MsgUtils;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.domain.TbGameType;
import com.zhengshun.touch.api.service.TbGameTypeService;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TbGameTypeController extends BaseController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private TbGameTypeService tbGameTypeService;

    @RequestMapping( value = "/manage/game/type/save.htm" )
    public void saveGameType (
            @RequestParam( value = "typeName") String typeName)
            throws Exception {
        logger.info( "【/manage/game/type/save.htm】【inputs】 typeName = " + typeName);

        if (tbGameTypeService.saveGameType( typeName )) {
            logger.info("【/manage/game/type/save.htm】【outputs】 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【/manage/score/save.htm】【outputs】 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }

    @RequestMapping( value = "/api/act/game/type/get.htm" )
    public void getGameType ()
            throws Exception {
        logger.info( "【/api/game/type/get.htm】【inputs】  " );

        List<TbGameType> list = tbGameTypeService.listGameType();

        Map<String, Object> retMap = new HashMap<>();

        retMap.put( Constant.RESPONSE_DATA, list );
        retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
		retMap.put( Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info( "【/api/game/type/get.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
        ServletUtils.writeToResponse( response, retMap );


    }

    @RequestMapping( value = "/manage/game/type/getAll.htm" )
    public void getAll ()
            throws Exception {
        logger.info( "【/manage/game/type/getAll.htm】【inputs】  " );

        List<TbGameType> list = tbGameTypeService.listAllGameType();

        Map<String, Object> retMap = new HashMap<>();

        retMap.put( Constant.RESPONSE_DATA, list );
        retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
        retMap.put( Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info( "【/manage/game/type/getAll.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
        ServletUtils.writeToResponse( response, retMap );


    }
}