
package com.zhengshun.touch.api.service.imp;


import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.zhengshun.touch.api.common.util.MongoDBUtils;
import com.zhengshun.touch.api.domain.BuriedPoint;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.service.BuriedPointMongoService;
import org.apache.batik.dom.util.HashTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


@Service("buriedPointMongoService")
public class BuriedPointMongoServiceImpl implements BuriedPointMongoService {

    private Logger logger = LoggerFactory.getLogger(BuriedPointMongoServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TbUserMapper tbUserMapper;

    private final static String COLLECTION_NAME = "buried_point";

    /* (non-Javadoc)
     * @see com.roomdis.center.mongo.service.IBuzzElementService#save(com.roomdis.center.mongo.model.BuzzElement)
     */
    @Override
    public int save(String appId, String key, String data, Long timestamp, String rdSessionKey, String sub, String
            version) throws
            Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective( params );
        if ( tbUser != null ) {
            BuriedPoint buriedPoint = new BuriedPoint();
            buriedPoint.setUserId( tbUser.getId() );
            buriedPoint.setAppId( appId );
            buriedPoint.setKey( key );
            buriedPoint.setTimestamp( new Date( timestamp ));
            buriedPoint.setCreateDate( new Date());
            buriedPoint.setStatus( 1 );
            buriedPoint.setDeleteFlag( 0 );
            buriedPoint.setUpdateDate( new Date() );
            buriedPoint.setSub( sub );
            buriedPoint.setVersion( version );
            JSONObject jsonObject = JSONObject.parseObject( data );
            Map<String,String> map = (Map)jsonObject;


            buriedPoint.setData(map);
            DBCollection collection = this.mongoTemplate.getCollection(COLLECTION_NAME);
            int result = 0;
            DBObject iteminfoObj = MongoDBUtils.bean2DBObject(buriedPoint);

            WriteResult writeResult = collection.save(iteminfoObj);
            result = writeResult.getN();
            return result;
        } else {
            return 1;
        }


    }


}