package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.mapper.TbUserScoreLogMapper;
import com.zhengshun.touch.api.domain.TbUserScoreLog;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TbUserScoreLogServiceImp extends BaseServiceImpl<TbUserScoreLog, Long> implements TbUserScoreLogService {
    @Autowired
    private TbUserScoreLogMapper tbUserScoreLogMapper;

    @Override
    public BaseMapper<TbUserScoreLog, Long> getMapper() {
        return tbUserScoreLogMapper;
    }

    @Override
    public Boolean saveUserScore(Long userId, BigDecimal score, Integer time, Integer gameTypeId) {
        TbUserScoreLog tbUserScoreLog = new TbUserScoreLog();
        tbUserScoreLog.setUserId( userId );
        tbUserScoreLog.setScore( score );
        tbUserScoreLog.setTime( time );
        tbUserScoreLog.setGameTypeId( gameTypeId );
        tbUserScoreLog.setCreateDate( new Date());
        int res = tbUserScoreLogMapper.insert( tbUserScoreLog );
        if ( res > 0 ) {
            return true;
        }
        return false;
    }
}