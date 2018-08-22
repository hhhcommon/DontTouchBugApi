package com.zhengshun.touch.api.service;


import com.zhengshun.touch.api.domain.GameData;

public interface GameDataMongoService {

    // 保存
    int saveOrUpdate(String rdSessionKey, String version, String scheduleData, String cardData) throws Exception;

    //获取
    GameData get(String rdSessionKey,String version) throws Exception;

}
