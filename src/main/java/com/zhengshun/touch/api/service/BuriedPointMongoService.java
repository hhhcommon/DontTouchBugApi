package com.zhengshun.touch.api.service;


import org.apache.batik.dom.util.HashTable;

/**
 * name: zhangyan
 * date:$[DATE]
 */
public interface BuriedPointMongoService {

    // 保存
    public int save(String appId, String key, String data, Long timestamp, String rdSessionKey, String sub) throws
            Exception;
}
