
package com.zhengshun.touch.api.service.imp;


import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.zhengshun.touch.api.common.util.MongoDBUtils;
import com.zhengshun.touch.api.domain.GameData;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.service.GameDataMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("gameDataMongoService")
public class GameDataMongoServiceImpl implements GameDataMongoService {

    private Logger logger = LoggerFactory.getLogger(GameDataMongoServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TbUserMapper tbUserMapper;

    private final static String COLLECTION_NAME = "game_data";

    @Override
    public int saveOrUpdate(String rdSessionKey, String version, String scheduleData, String cardData) throws
            Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective( params );
        if ( tbUser != null ) {
            GameData ga = this.get( rdSessionKey, version );
            logger.info("用户...." + ga.getUserId());
            if ( ga.getUserId() == null ) {
                logger.info("插入游戏数据....");
                GameData gameData = new GameData();
                gameData.setUserId( tbUser.getId() );
                gameData.setCreateDate( new Date());
                gameData.setStatus( 1 );
                gameData.setDeleteFlag( 0 );
                gameData.setUpdateDate( new Date() );
                gameData.setVersion( version );
                JSONObject jsonObject = JSONObject.parseObject( scheduleData );
                Map<String,String> map = (Map)jsonObject;
                gameData.setScheduleData(map);
                JSONObject jsonObject1 = JSONObject.parseObject( cardData );
                Map<String,String> map1 = (Map)jsonObject1;
                gameData.setCardData(map1);
                DBCollection collection = this.mongoTemplate.getCollection(COLLECTION_NAME);
                int result = 0;
                DBObject iteminfoObj = MongoDBUtils.bean2DBObject(gameData);

                WriteResult writeResult = collection.save(iteminfoObj);
                result = writeResult.getN();
                logger.info("插入游戏数据end");
                return result;
            } else {
                logger.info("更新游戏数据....");
                DBCollection collection = this.mongoTemplate.getCollection(COLLECTION_NAME);
                GameData queryGameData = new GameData();
                queryGameData.setUserId( tbUser.getId() );
                queryGameData.setVersion( version );
                JSONObject jsonObject = JSONObject.parseObject( scheduleData );
                Map<String,String> map = (Map)jsonObject;
                ga.setScheduleData( map );
                JSONObject jsonObject1 = JSONObject.parseObject( cardData );
                Map<String,String> map1 = (Map)jsonObject1;
                ga.setCardData( map1 );
                DBObject itemInfoObj = MongoDBUtils.bean2DBObject(ga);
                DBObject query =  MongoDBUtils.bean2DBObject(queryGameData);
                collection.update(query, itemInfoObj);
                logger.info("更新游戏数据end");
                return 0;
            }

        } else {
            return 1;
        }


    }

    @Override
    public GameData get(String rdSessionKey,String version) throws Exception {
//        List<GameData> list = new ArrayList<>();
        // 判断查询的json中传递过来的参数
        DBObject query = new BasicDBObject();

        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective( params );
        if ( tbUser != null) {
            query.put("user_id",tbUser.getId());
            query.put("version", version );

            DBCursor results = mongoTemplate.getCollection(COLLECTION_NAME).find(query);
            if(null != results){
                Iterator<DBObject> iterator = results.iterator();

                GameData gameData = new GameData();
                while(iterator.hasNext()){
                    BasicDBObject obj = (BasicDBObject) iterator.next();
                    gameData = MongoDBUtils.dbObject2Bean(obj, gameData);
                }
                return gameData;
            }
        }

        return null;
    }


}