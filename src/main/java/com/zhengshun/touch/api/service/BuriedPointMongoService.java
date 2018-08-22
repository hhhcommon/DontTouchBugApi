package com.zhengshun.touch.api.service;




public interface BuriedPointMongoService {

    // 保存
    public int save(String appId, String key, String data, Long timestamp, String rdSessionKey, String sub, String
            version) throws
            Exception;
}
