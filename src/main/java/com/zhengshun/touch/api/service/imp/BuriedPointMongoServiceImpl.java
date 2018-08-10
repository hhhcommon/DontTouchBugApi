
package com.zhengshun.touch.api.service.imp;


import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.zhengshun.touch.api.common.util.MongoDBUtils;
import com.zhengshun.touch.api.domain.BuriedPoint;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.service.BuriedPointMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
    public int save(String appId, String key, String data, Long timestamp, String rdSessionKey) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective( params );
        if ( tbUser != null ) {
            BuriedPoint buriedPoint = new BuriedPoint();
            buriedPoint.setUserId( tbUser.getId() );
            buriedPoint.setAppId( appId );
            buriedPoint.setKey( key );
            buriedPoint.setData( data );
            buriedPoint.setTimestamp( new Date( timestamp ));
            buriedPoint.setCreateDate( new Date());
            buriedPoint.setStatus( 1 );
            buriedPoint.setDeleteFlag( 0 );
            buriedPoint.setUpdateDate( new Date() );

            DBCollection collection = this.mongoTemplate.getCollection(COLLECTION_NAME);
            int result = 0;
            DBObject iteminfoObj = MongoDBUtils.bean2DBObject(buriedPoint);

            WriteResult writeResult = collection.save(iteminfoObj);
            result = writeResult.getN();
            logger.info("埋点写入成功");
            return result;
        } else {
            logger.info("tbUser 为空, 埋点写入失败");
            return 1;
        }


    }


}