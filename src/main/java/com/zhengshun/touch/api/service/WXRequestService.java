package com.zhengshun.touch.api.service;


import java.util.Map;

public interface WXRequestService {

    /**
     * 获取openid sessionkey
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    Map<String, String> getOpenId(String appid, String secret, String code );


}