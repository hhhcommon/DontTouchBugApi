package com.zhengshun.touch.api.common.util;

import com.zhengshun.touch.api.common.context.Global;
import com.zhengshun.touch.api.system.domain.SysConfig;
import com.zhengshun.touch.api.system.service.SysConfigService;
import org.apache.log4j.Logger;
import tool.util.BeanUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 缓存帮助类
 * 
 * @author gc
 * @version 1.0.0
 * @date 2017年1月7日 上午10:40:22
 * Copyright 杭州融都科技股份有限公司 资产匹配系统 All Rights Reserved
 * 官方网站：www.erongdu.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class CacheUtil {

    private static final Logger logger = Logger.getLogger(CacheUtil.class);

    /**
     * 初始化系统参数配置
     */
	public static void initSysConfig() {

        logger.info("初始化系统配置Config...");

        // 系统配置Config缓存
        SysConfigService sysConfigService = (SysConfigService) BeanUtil.getBean("sysConfigService");

        Map<String, Object> configMap = new HashMap<String, Object>();

        List<SysConfig> sysConfigs = sysConfigService.findAll();
        for (SysConfig sysConfig : sysConfigs) {
            if (null != sysConfig && StringUtil.isNotBlank(sysConfig.getCode())) {
                configMap.put(sysConfig.getCode(), sysConfig.getValue());
            }
        }

        Global.configMap = new HashMap<String, Object>();
        Global.configMap.putAll(configMap);
    }

 
}
