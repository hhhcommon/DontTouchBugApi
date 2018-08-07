package com.zhengshun.touch.api.controller;

import com.github.pagehelper.Page;
import com.zhengshun.touch.api.common.BaseResponse;
import com.zhengshun.touch.api.common.MsgUtils;
import com.zhengshun.touch.api.common.context.Constant;
import com.zhengshun.touch.api.common.util.RdPage;
import com.zhengshun.touch.api.common.util.ServletUtils;
import com.zhengshun.touch.api.common.web.controller.BaseController;
import com.zhengshun.touch.api.domain.TbCodeInfo;
import com.zhengshun.touch.api.service.TbCodeInfoService;
import com.zhengshun.touch.api.service.TbGameTypeService;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TbCodeInfoController extends BaseController {


    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private TbCodeInfoService tbCodeInfoService;

    @RequestMapping( value = "/manage/code/info/save.htm" )
    public void saveCodeInfo (
            @RequestParam( value = "content") String content,
            @RequestParam( value = "score") BigDecimal score,
            @RequestParam( value = "time") Integer time,
            @RequestParam( value = "isBug") Integer isBug,
            @RequestParam( value = "difficult") Integer difficult,
            @RequestParam( value = "gameTypeId") Integer gameTypeId)
            throws Exception {
        logger.info( "【manage/code/info/save.htm】【inputs】 content = " + content + ", score = " + score + ", time = " + time + ", isBug = " + isBug + ", difficult = " + difficult + ", gameTypeId = " + gameTypeId);

        if (tbCodeInfoService.saveCodeInfo( content, score, time, isBug, difficult, gameTypeId )) {
            logger.info("【manage/code/info/save.htm】【outputs】 操作成功");
            ServletUtils.writeToResponse(response, BaseResponse.success());
        } else {
            logger.info("【manage/code/info/save.htm】【outputs】 操作失败");
            ServletUtils.writeToResponse( response, BaseResponse.fail() );
        }


    }

    /**
     * 显示所有的内容列表
     * @param current
     * @param pageSize
     * @throws Exception
     */
    @RequestMapping( value = "/manage/code/info/page.htm", method = {RequestMethod.POST,RequestMethod.GET} )
    public void page(@RequestParam( value = "current" ) int current,
                      @RequestParam( value = "pageSize" ) int pageSize ) throws Exception {
        logger.info("【/manage/code/info/page.htm】【inputs】");
        Map<String, Object> searchMap = new HashMap<>();
        Page<TbCodeInfo> page = tbCodeInfoService.page(searchMap, current, pageSize);
        Map<String, Object> data = new HashMap<>();
        data.put("list", page.getResult());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constant.RESPONSE_DATA, data);
        result.put(Constant.RESPONSE_DATA_PAGE, new RdPage(page));
        result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
        result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info("【/manage/code/info/page.htm】【outputs】  ," + ConvertUtils.convert(
                result));
        ServletUtils.writeToResponse(response, result);
    }

    /**
     * 显示所有的内容列表
     * @param current
     * @param pageSize
     * @throws Exception
     */
    @RequestMapping( value = "/api/act/code/info/page.htm", method = {RequestMethod.POST,RequestMethod.GET} )
    public void apipage(@RequestParam( value = "current" ) int current,
                     @RequestParam( value = "pageSize" ) int pageSize ) throws Exception {
        logger.info("【/api/act/code/info/page.htm】【inputs】");
        Map<String, Object> searchMap = new HashMap<>();
        Page<TbCodeInfo> page = tbCodeInfoService.apipage(searchMap, current, pageSize);
        Map<String, Object> data = new HashMap<>();
        data.put("list", page.getResult());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constant.RESPONSE_DATA, data);
        result.put(Constant.RESPONSE_DATA_PAGE, new RdPage(page));
        result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
        result.put(Constant.RESPONSE_CODE_MSG, MsgUtils.OPERATE_SUCCESS_MSG);
        logger.info("【/api/act/code/info/page.htm】【outputs】  ," + ConvertUtils.convert(
                result));
        ServletUtils.writeToResponse(response, result);
    }
}