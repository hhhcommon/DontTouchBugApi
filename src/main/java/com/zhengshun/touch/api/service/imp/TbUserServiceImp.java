package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.service.TbUserService;
import com.zhengshun.touch.api.user.bean.AppDbSession;
import com.zhengshun.touch.api.user.bean.AppSessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class TbUserServiceImp extends BaseServiceImpl<TbUser, Long> implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private AppDbSession appDbSession;

    @Override
    public BaseMapper<TbUser, Long> getMapper() {
        return tbUserMapper;
    }

    @Override
    public Map<String, Object> saveUser(HttpServletRequest request, String avatarUrl, String city, String country, Integer gender, String language, String nickName, String openId, String province) {
        Map<String, Object> retMap = new HashMap<>();

        TbUser tbUser1 = new TbUser();
        tbUser1.setAvatarUrl( avatarUrl );
        tbUser1.setCity( city );
        tbUser1.setCountry( country );
        tbUser1.setGender( gender );
        tbUser1.setLanguage( language );
        tbUser1.setNickName( nickName );
        tbUser1.setOpenId( openId );
        tbUser1.setProvince( province );
        tbUser1.setCreateDate( new Date() );
        Map<String, Object> params = new HashMap<>();
        params.put("openId", openId );
        TbUser tbUser = tbUserMapper.findSelective(params);

        if ( tbUser != null ) {
            tbUser1.setId( tbUser.getId() );
            tbUserMapper.update( tbUser1 );
        } else {
            String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
            tbUser1.setUuid( uuid );
            tbUserMapper.insert( tbUser1 );
        }

        AppSessionBean session = appDbSession.create(request, openId);
        retMap.put("success", true);
        retMap.put("msg", "登录成功");
        retMap.put("data", session.getFront());

        return retMap;
    }
}