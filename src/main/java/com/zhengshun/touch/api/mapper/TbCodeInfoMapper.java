package com.zhengshun.touch.api.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.domain.TbCodeInfo;

@RDBatisDao
public interface TbCodeInfoMapper extends BaseMapper<TbCodeInfo, Long> {

    int insert( TbCodeInfo tbCodeInfo );
}