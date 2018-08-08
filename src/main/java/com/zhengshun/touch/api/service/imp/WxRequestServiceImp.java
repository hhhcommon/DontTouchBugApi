package com.zhengshun.touch.api.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhengshun.touch.api.common.util.HttpsUtil;
import com.zhengshun.touch.api.common.util.code.MD5;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.service.WXRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WxRequestServiceImp  implements WXRequestService {


    public static final Logger logger = LoggerFactory.getLogger(WxRequestServiceImp.class);

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public Map<String, String> getOpenId(String appid, String secret, String code) {

        Map<String, String> params = new HashMap<>();
        params.put("appid", appid );
        params.put("secret", secret );
        params.put("js_code", code );
        params.put("grant_type", "authorization_code");

        String result = HttpsUtil.postClient("https://api.weixin.qq.com/sns/jscode2session", params);
        logger.info(JSON.toJSONString("wx queryopenid = " + result ));
        params.clear();
        JSONObject jsonObject = JSONObject.parseObject( result );
        String sessionKey = jsonObject.getString("session_key");
        String rdSessionKey = MD5.getMD5ofStr(sessionKey);
        params.put("rdSessionKey",rdSessionKey);

        TbUser tbUser = new TbUser();
        tbUser.setOpenId( jsonObject.getString("openid") );
        tbUser.setRdSessionKey( rdSessionKey );
        tbUser.setSessionKey( sessionKey );

        Map<String, Object> userparam = new HashMap<>();
        userparam.put("openId", jsonObject.getString("openid") );
        TbUser tbUser1 = tbUserMapper.findSelective(userparam);
        if ( tbUser1 != null ) {
            tbUser.setId( tbUser1.getId() );
            tbUserMapper.update( tbUser );
            logger.info("【WXRequestService】【getOpenId】【修改用户rdSessionKey】");
        } else {
            tbUserMapper.insert( tbUser );
            logger.info("【WXRequestService】【getOpenId】【插入用户rdSessionKey】");
        }


        return params;
    }
}