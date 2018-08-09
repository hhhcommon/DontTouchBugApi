package com.zhengshun.touch.api.service;


import java.util.Map;

public interface WXRequestService {

    /**
     * 获取openid sessionkey
     * @param appid
     * @return
     */
    Map<String, String> getOpenId(String appid );


}