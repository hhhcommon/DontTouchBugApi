package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.mapper.TbUserScoreLogMapper;
import com.zhengshun.touch.api.domain.TbUserScoreLog;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@org.springframework.context.annotation.Lazy(true)
@Service
public class TbUserScoreLogServiceImp extends BaseServiceImpl<TbUserScoreLog, Long> implements TbUserScoreLogService {
    public static final Logger logger = LoggerFactory.getLogger(TbUserScoreLogServiceImp.class);
    @Autowired
    private TbUserScoreLogMapper tbUserScoreLogMapper;
    @Autowired
    private TbUserMapper tbUserMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public BaseMapper<TbUserScoreLog, Long> getMapper() {
        return tbUserScoreLogMapper;
    }

    @Override
    public Boolean saveUserScore(String rdSessionKey, BigDecimal score, Integer time, Integer difficut, String steps) {
        TbUserScoreLog tbUserScoreLog = new TbUserScoreLog();
        tbUserScoreLog.setScore( score );
        tbUserScoreLog.setTime( time );
        tbUserScoreLog.setDifficut( difficut );
        tbUserScoreLog.setSteps( steps );
        tbUserScoreLog.setCreateDate( new Date());
        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);
        if ( tbUser != null ) {

            tbUserScoreLog.setUserId( tbUser.getId() );
            String redisScore = redisTemplate.opsForValue().get( tbUser.getId() + "" ) + "";
            Map<String, Object> paramRedis = new HashMap<>();
            paramRedis.put("nickName", tbUser.getNickName() );
            paramRedis.put("avatarUrl", tbUser.getAvatarUrl() );
            paramRedis.put("score", score + "" );
            System.out.println( redisScore);
            ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>(JSONObject.fromObject(paramRedis).toString(),score.doubleValue());
            Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
            tuples.add(objectTypedTuple1);

            if ( redisScore != null && !redisScore.equals("null")) {
                if ( score.doubleValue() > Double.parseDouble(redisScore)) {
                    Map<String, Object> reparam = new HashMap<>();
                    String nickName = redisTemplate.opsForValue().get(tbUser.getId() +"nickName")+"";
                    String avatarUrl = redisTemplate.opsForValue().get(tbUser.getId() +"avatarUrl")+"";
                    reparam.put("nickName", nickName );
                    reparam.put("avatarUrl", avatarUrl );
                    reparam.put("score", redisScore );
                    logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 当前用户缓存值 : " + com.alibaba.fastjson.JSONObject.toJSON( reparam ));
                    logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 当前得分大于缓存得分， 清楚缓存得分 start userId = " +
                            tbUser.getId());
                    redisTemplate.opsForZSet().remove("scorerank", JSONObject.fromObject(reparam).toString() );
                    logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 当前得分大于缓存得分， 清楚缓存得分 end userId = " +
                            tbUser.getId());

                    redisTemplate.opsForValue().set(tbUser.getId() + "", score + "" );
                    redisTemplate.opsForZSet().add("scorerank", JSONObject.fromObject(paramRedis).toString(), score.doubleValue() );
                }

            } else {
                redisTemplate.opsForValue().set(tbUser.getId() + "", score + "" );
                redisTemplate.opsForZSet().add("scorerank", JSONObject.fromObject(paramRedis).toString(), score.doubleValue() );
            }
            redisTemplate.opsForValue().set(tbUser.getId() +"nickName", tbUser.getNickName());
            redisTemplate.opsForValue().set(tbUser.getId() +"avatarUrl", tbUser.getAvatarUrl());
            int res = tbUserScoreLogMapper.insert( tbUserScoreLog );
            if ( res > 0 ) {
                return true;
            }
        } else {
            logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 没有找到该rdSessionKey下的用户信息， rdSessionKey = " + rdSessionKey);
        }

        return false;
    }


    @Override
    public Boolean saveUserStars(String rdSessionKey, BigDecimal score, Integer time, Integer difficut, String steps,
        Integer stars ) {
        TbUserScoreLog tbUserScoreLog = new TbUserScoreLog();
        tbUserScoreLog.setScore( score );
        tbUserScoreLog.setTime( time );
        tbUserScoreLog.setDifficut( difficut );
        tbUserScoreLog.setSteps( steps );
        tbUserScoreLog.setStars( stars );
        tbUserScoreLog.setCreateDate( new Date());
        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);
        if ( tbUser != null ) {

            tbUserScoreLog.setUserId( tbUser.getId() );
            String redisUserValue = redisTemplate.opsForValue().get( "userId = " + tbUser.getId() + "" ) + "";
            logger.info("【TbUserScoreLogServiceImp】【saveUserStars】 key = " + " userId = " + tbUser.getId() + ", " +
                    "redisUserValue = " + redisUserValue);
            Map<String, Object> paramRedis = new HashMap<>();
            paramRedis.put("nickName", tbUser.getNickName() );
            paramRedis.put("avatarUrl", tbUser.getAvatarUrl() );
            paramRedis.put("stars", stars + "" );
            if ( redisUserValue != null && !redisUserValue.equals("null")) {
                JSONObject jsonObject = JSONObject.fromObject( redisUserValue );
                if ( stars.doubleValue() > jsonObject.getDouble("stars")) {
                    Map<String, Object> reparam = new HashMap<>();
                    reparam.put("nickName", jsonObject.getString("nickName") );
                    reparam.put("avatarUrl", jsonObject.getString("avatarUrl")  );
                    reparam.put("stars", jsonObject.getDouble("stars") );
                    logger.info("【TbUserScoreLogServiceImp】【saveUserStars】 当前用户缓存值 : " + JSONObject.fromObject(reparam).toString());
                    logger.info("【TbUserScoreLogServiceImp】【saveUserStars】 当前星星大于缓存星星， 清除缓存星星 start userId = " +
                            tbUser.getId());
                    redisTemplate.opsForZSet().remove("starsrank", JSONObject.fromObject(reparam).toString() );
                    logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 当前星星大于缓存星星， 清除缓存星星 end userId = " +
                            tbUser.getId());

                    redisTemplate.opsForValue().set("userId = " + tbUser.getId() + "", JSONObject.fromObject(paramRedis).toString() );
                    redisTemplate.opsForZSet().add("starsrank", JSONObject.fromObject(paramRedis).toString(), stars.doubleValue() );
                }

            } else {
                redisTemplate.opsForValue().set("userId = " + tbUser.getId() + "",  JSONObject.fromObject(paramRedis).toString() );
                redisTemplate.opsForZSet().add("starsrank", JSONObject.fromObject(paramRedis).toString(), stars.doubleValue() );
            }
            int res = tbUserScoreLogMapper.insert( tbUserScoreLog );
            if ( res > 0 ) {
                return true;
            }
        } else {
            logger.info("【TbUserScoreLogServiceImp】【saveUserStars】 没有找到该rdSessionKey下的用户信息， rdSessionKey = " + rdSessionKey);
        }

        return false;
    }



    @Override
    public Map<String, Object> getRank(String rdSessionKey) {
        logger.info("【TbUserScoreLogServiceImp】【getRank】 当前排行 : " + redisTemplate.opsForZSet().reverseRange("scorerank", 0, 20));
        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);
        if ( tbUser != null ) {
            Set<Object> tuples1 = redisTemplate.opsForZSet().reverseRange("scorerank",0,20);
            Iterator<Object> iterator = tuples1.iterator();
            int i = 1;
            Map<String, Object> param = new HashMap<>();
            while (iterator.hasNext())
            {
                Object object  = iterator.next();
                param.put(i + "", object );
                i++;
            }
            Map<String, Object> myparam = new HashMap<>();
            String redisScore = redisTemplate.opsForValue().get(tbUser.getId()+"")+"";
            String nickName = redisTemplate.opsForValue().get(tbUser.getId() +"nickName")+"";
            String avatarUrl = redisTemplate.opsForValue().get(tbUser.getId() +"avatarUrl")+"";
            Map<String, Object> reparam = new HashMap<>();
            reparam.put("nickName", nickName );
            reparam.put("avatarUrl", avatarUrl );
            reparam.put("score", redisScore );

            Long rank = redisTemplate.opsForZSet().reverseRank("scorerank", JSONObject.fromObject(reparam).toString());
            reparam.put("rank", rank+1);

            myparam.put("myscore", reparam );
            myparam.put("scoreList", param);
            return  myparam;
        } else {
            logger.info("【TbUserScoreLogServiceImp】【saveUserScore】 没有找到该rdSessionKey下的用户信息， rdSessionKey = " + rdSessionKey);
        }
        return null;
    }

    @Override
    public Map<String, Object> getStarsRank(String rdSessionKey) {
        logger.info("【TbUserScoreLogServiceImp】【getStarsRank】 当前排行 : " + redisTemplate.opsForZSet().reverseRange
                ("starsrank", 0, 20));
        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);
        if ( tbUser != null ) {
            Set<Object> tuples1 = redisTemplate.opsForZSet().reverseRange("starsrank",0,20);
            Iterator<Object> iterator = tuples1.iterator();
            int i = 1;
            Map<String, Object> param = new HashMap<>();
            while (iterator.hasNext())
            {
                Object object  = iterator.next();
                param.put(i + "", object );
                i++;
            }
            Map<String, Object> myparam = new HashMap<>();
            String redisUserValue = redisTemplate.opsForValue().get("userId = " + tbUser.getId() + "")+"";
            JSONObject jsonObject = JSONObject.fromObject( redisUserValue );
            Map<String, Object> reparam = new HashMap<>();
            reparam.put("nickName", jsonObject.get("nickName") );
            reparam.put("avatarUrl", jsonObject.get("avatarUrl") );
            reparam.put("stars", jsonObject.get("stars") );
            Long rank = redisTemplate.opsForZSet().reverseRank("starsrank", redisUserValue );
            reparam.put("rank", rank+1);

            myparam.put("mystars", reparam );
            myparam.put("starsList", param);
            return  myparam;
        } else {
            logger.info("【TbUserScoreLogServiceImp】【getStarsRank】 没有找到该rdSessionKey下的用户信息， rdSessionKey = " + rdSessionKey);
        }
        return null;
    }
}