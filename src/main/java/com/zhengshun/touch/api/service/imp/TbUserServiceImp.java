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
    public Boolean saveUser(HttpServletRequest request, String avatarUrl, String city, String country, Integer gender,
                      String language, String nickName, String rdSessionKey, String province) {
        Map<String, Object> retMap = new HashMap<>();

        TbUser tbUser1 = new TbUser();
        tbUser1.setAvatarUrl( avatarUrl );
        tbUser1.setCity( city );
        tbUser1.setCountry( country );
        tbUser1.setGender( gender );
        tbUser1.setLanguage( language );
        tbUser1.setNickName( nickName );
        tbUser1.setProvince( province );
        tbUser1.setCreateDate( new Date() );
        Map<String, Object> params = new HashMap<>();

        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);

        if ( tbUser != null ) {
            tbUser1.setId( tbUser.getId() );
            tbUserMapper.update( tbUser1 );
        } else {
            String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
            tbUser1.setRdSessionKey( rdSessionKey );
            tbUser1.setUuid( uuid );
            tbUserMapper.insert( tbUser1 );
        }


        return true;
    }
}