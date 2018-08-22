package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.MsgUtils;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.domain.GameData;
import com.zhengshun.touch.api.service.GameDataMongoService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Scope("prototype")
@Controller
public class GameDataController extends BaseController{

    public static final Logger LOGGER = LoggerFactory.getLogger( GameDataController.class );



    @Resource(name = "gameDataMongoService")
    private GameDataMongoService gameDataMongoService;

    /**
     * 保存游戏数据
     * @param rdSessionKey
     * @param version
     * @throws Exception
     */
    @RequestMapping(value = "/api/gamedata/save.htm", method = RequestMethod.POST)
    public void save(
            @RequestParam(value = "rdSessionKey") String rdSessionKey,
            @RequestParam(value = "version", required = false) String version,
            @RequestParam(value = "scheduleData", required = false) String scheduleData,
            @RequestParam(value = "cardData", required = false) String cardData) throws Exception {
        LOGGER.info( "【/api/gamedata/save.htm】" + "rdSessionKey = " + rdSessionKey + ", version = " + version + ", scheduleData = " + scheduleData+ ", cardData = " + cardData );

        int ret = gameDataMongoService.saveOrUpdate( rdSessionKey, version, scheduleData, cardData);
//        int ret = 1;
        if (ret == 0){
            LOGGER.info("【/api/gamedata/save.htm】 游戏数据写入成功， rdSessionKey = " + rdSessionKey);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
            ServletUtils.writeToResponse(response,result);
        }else{
            LOGGER.info("【/api/gamedata/save.htm】 游戏数据写入失败， 未找到用户， rdSessionKey = " + rdSessionKey);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_FAIL_MSG);
            ServletUtils.writeToResponse(response,result);
        }

    }


    /**
     * 获取游戏数据
     * @param rdSessionKey
     * @param version
     * @throws Exception
     */
    @RequestMapping(value = "/api/gamedata/get.htm")
    public void get(
            @RequestParam(value = "rdSessionKey") String rdSessionKey,
            @RequestParam(value = "version", required = false) String version) throws Exception {
        LOGGER.info( "【/api/gamedata/get.htm】" + "rdSessionKey = " + rdSessionKey + ", version = " + version );

        GameData gameData = gameDataMongoService.get( rdSessionKey, version);
        Map<String, Object> retMap = new HashMap<>();

        retMap.put( Constant.RESPONSE_DATA, gameData );
        retMap.put( Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE );
        retMap.put( Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        LOGGER.info( "【/api/gamedata/get.htm】【outputs】 " + ConvertUtils.convert( retMap ) );
        ServletUtils.writeToResponse( response, retMap );

    }


}
