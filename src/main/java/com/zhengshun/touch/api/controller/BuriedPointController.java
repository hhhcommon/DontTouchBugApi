package com.zhengshun.touch.api.controller;

import com.zhengshun.touch.api.common.MsgUtils;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.service.BuriedPointMongoService;
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
public class BuriedPointController extends BaseController{

    public static final Logger LOGGER = LoggerFactory.getLogger( BuriedPointController.class );



    @Resource(name = "buriedPointMongoService")
    private BuriedPointMongoService buriedPointMongoService;
    /**
     * @param userId
     * @throws Exception
     */
    @RequestMapping(value = "/api/buriedPoint/add.htm", method = RequestMethod.POST)
    public void page(
            @RequestParam(value="appId") String appId,
            @RequestParam(value="key") String key,
            @RequestParam(value = "data") String data,
            @RequestParam(value = "rdSessionKey") String rdSessionKey,
            @RequestParam(value = "timestamp") Long timestamp) throws Exception {
        LOGGER.info( "【/api/buriedPoint/add.htm】" + "appId = " + appId + ", key = " + key + ", data = " + data + ", " +
                "rdSessionKey = " + rdSessionKey + ", timestamp = " + rdSessionKey);

        int ret = buriedPointMongoService.save( appId, key, data, timestamp, rdSessionKey );
//        int ret = 1;
        if (ret == 0){
            LOGGER.info("【/api/buriedPoint/add.htm】 success ");
            Map<String,Object> result = new HashMap<String,Object>();
            result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
            ServletUtils.writeToResponse(response,result);
        }else{
            LOGGER.info("【/api/buriedPoint/add.htm】 failed ");
            Map<String,Object> result = new HashMap<String,Object>();
            result.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_FAIL_MSG);
            ServletUtils.writeToResponse(response,result);
        }

    }
}
