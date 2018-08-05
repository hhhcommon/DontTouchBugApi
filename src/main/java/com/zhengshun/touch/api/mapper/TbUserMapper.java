package com.zhengshun.touch.api.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.domain.TbUser;

@RDBatisDao
public interface TbUserMapper extends BaseMapper<TbUser, Long> {

    int insert(TbUser tbUser);
}