package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.mapper.TbUserScoreLogMapper;
import com.zhengshun.touch.api.domain.TbUserScoreLog;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import groovy.lang.Lazy;
import net.sf.json.JSONObject;
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
                    System.out.println(JSONObject.fromObject(reparam).toString());
                    redisTemplate.opsForZSet().remove("scorerank", JSONObject.fromObject(reparam).toString() );
                    System.out.println("删除陈宫");
                    redisTemplate.opsForValue().set(tbUser.getId() + "", score + "" );
                    if (!nickName.equals(tbUser.getNickName())){
                        redisTemplate.opsForValue().set(tbUser.getId() +"nickName", tbUser.getNickName());
                    }
                    if (!avatarUrl.equals(tbUser.getAvatarUrl())){
                        redisTemplate.opsForValue().set(tbUser.getId() +"avatarUrl", tbUser.getAvatarUrl());
                    }
                    redisTemplate.opsForZSet().add("scorerank", JSONObject.fromObject(paramRedis).toString(), score.doubleValue() );
                    System.out.println("插入成功");
                }
            } else {
                redisTemplate.opsForValue().set(tbUser.getId() + "", score + "" );
                redisTemplate.opsForValue().set(tbUser.getId() +"nickName", tbUser.getNickName());
                redisTemplate.opsForValue().set(tbUser.getId() +"avatarUrl", tbUser.getAvatarUrl());
                redisTemplate.opsForZSet().add("scorerank", tuples );
            }
            System.out.println("redis插入成功" + redisTemplate.opsForValue().get( tbUser.getId() + "" ));
            Set<ZSetOperations.TypedTuple<Object>> tuples1 = redisTemplate.opsForZSet().rangeWithScores("scorerank",0,-1);
            Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples1.iterator();
            while (iterator.hasNext())
            {
                ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
                System.out.println("value:" + typedTuple.getValue() + "score:" + typedTuple.getScore());
            }


            int res = tbUserScoreLogMapper.insert( tbUserScoreLog );
            if ( res > 0 ) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Map<String, Object> getRank(String rdSessionKey) {
        System.out.println("取出："+redisTemplate.opsForZSet().reverseRange("scorerank", 0, 20));
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

                System.out.println("value:" +object.toString());
            }

            Map<String, Object> myparam = new HashMap<>();
            String redisScore = redisTemplate.opsForValue().get(tbUser.getId()+"")+"";
            String nickName = redisTemplate.opsForValue().get(tbUser.getId() +"nickName")+"";
            String avatarUrl = redisTemplate.opsForValue().get(tbUser.getId() +"avatarUrl")+"";
            Map<String, Object> reparam = new HashMap<>();
            reparam.put("nickName", nickName );
            reparam.put("avatarUrl", avatarUrl );
            reparam.put("score", redisScore );

            Long rank = redisTemplate.opsForZSet().rank("scorerank", JSONObject.fromObject(reparam).toString());
            reparam.put("rank", rank);

            myparam.put("myscore", reparam );
            myparam.put("scoreList", param);
            return  myparam;
        }
        return null;
    }
}