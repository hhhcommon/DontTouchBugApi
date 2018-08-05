package com.zhengshun.touch.api.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.domain.TbGameType;

import java.util.List;
import java.util.Map;

@RDBatisDao
public interface TbGameTypeMapper extends BaseMapper<TbGameType, Long> {

    int insert( TbGameType tbGameType );

    List<TbGameType> listGameType( Map<String, Object> params );
}