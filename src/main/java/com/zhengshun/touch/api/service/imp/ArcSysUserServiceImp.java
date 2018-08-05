package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.ArcSysUser;
import com.zhengshun.touch.api.mapper.ArcSysUserMapper;
import com.zhengshun.touch.api.service.ArcSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArcSysUserServiceImp extends BaseServiceImpl<ArcSysUser, Long> implements ArcSysUserService {
    @Autowired
    private ArcSysUserMapper arcSysUserMapper;

    @Override
    public BaseMapper<ArcSysUser, Long> getMapper() {
        return arcSysUserMapper;
    }
}