package com.zhengshun.touch.api.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.domain.TbUserScoreLog;

@RDBatisDao
public interface TbUserScoreLogMapper extends BaseMapper<TbUserScoreLog, Long> {

    int insert( TbUserScoreLog tbUserScoreLog );
}