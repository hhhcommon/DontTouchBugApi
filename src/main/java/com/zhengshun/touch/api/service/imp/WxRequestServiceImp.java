package com.zhengshun.touch.api.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.zhengshun.touch.api.common.context.Global;
import com.zhengshun.touch.api.common.util.HttpsUtil;
import com.zhengshun.touch.api.common.util.code.MD5;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.service.WXRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WxRequestServiceImp  implements WXRequestService {


    public static final Logger logger = LoggerFactory.getLogger(WxRequestServiceImp.class);

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public Map<String, String> getOpenId( String code) {

        Map<String, String> params = new HashMap<>();
//        params.put("appid", "wx78741ebb07a97411" );
//        params.put("secret", "24640dbeeed1cd07f48509c239d856a1" );
        params.put("appid", Global.getValue("fish_app_id"));
        params.put("secret", Global.getValue("fish_app_secret") );
        params.put("js_code", code );
        params.put("grant_type", "authorization_code");
        logger.info("【WxRequestServiceImp】【getOpenId】 调用微信获取OPENID传参 ： " + JSONObject.toJSON(params));
        String result = HttpsUtil.postClient("https://api.weixin.qq.com/sns/jscode2session", params);
        logger.info("【WxRequestServiceImp】【getOpenId】 微信获取OPENID结果 ： " + JSONObject.toJSON(result));
        params.clear();
        JSONObject jsonObject = JSONObject.parseObject( result );
        String sessionKey = jsonObject.getString("session_key");
        String rdSessionKey = MD5.getMD5ofStr(jsonObject.getString("openid"));
        String openId = jsonObject.getString("openid");

        TbUser tbUser = new TbUser();
        tbUser.setOpenId( openId );
        tbUser.setRdSessionKey( rdSessionKey );
        tbUser.setSessionKey( sessionKey );
        tbUser.setUuid( UUID.randomUUID().toString().replaceAll( "-", "" ) );

        Map<String, Object> userparam = new HashMap<>();
        userparam.put("openId", openId );
        TbUser tbUser1 = tbUserMapper.findSelective(userparam);
        if ( tbUser1 != null ) {
            logger.info("【WxRequestServiceImp】【getOpenId】 当前用户已经存在，修改用户信息session信息  userId = " + tbUser1.getId() + "," +
                    " sessionKey = " + sessionKey + ", rdSessionKey = " + rdSessionKey + ", openId = " + openId );
            tbUser.setId( tbUser1.getId() );
            int res = tbUserMapper.update( tbUser );
            if ( res > 0 ) {
                logger.info("【WxRequestServiceImp】【getOpenId】 当前用户已经存在，修改用户session信息 userId = " + tbUser1.getId() + ", " + "修改成功！");
            } else {
                logger.info("【WxRequestServiceImp】【getOpenId】 当前用户已经存在，修改用户信息session信息 = " + tbUser1.getId() + ", 修改失败！");
            }
        } else {
            logger.info("【WxRequestServiceImp】【getOpenId】 当前用户不存在，新增用户session信息  sessionKey = " + sessionKey + ", " +
                    "rdSessionKey = " + rdSessionKey + ", openId = " + openId );
            tbUser.setCreateDate( new Date() );
            int res = tbUserMapper.insert( tbUser );
            if ( res > 0 ) {
                logger.info("【WxRequestServiceImp】【getOpenId】 当前用户已经存在，新增用户session信息 rdSessionKey = " + rdSessionKey
                        + ", " + "新增成功！");
            } else {
                logger.info("【WxRequestServiceImp】【getOpenId】 当前用户已经存在，修改用户信息session信息 rdSessionKey = " +
                        rdSessionKey + ", " + "新增失败！");
            }
        }
        params.put("rdSessionKey",rdSessionKey);
        return params;
    }
}