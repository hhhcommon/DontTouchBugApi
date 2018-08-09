package com.zhengshun.touch.api.service.imp;

import com.oracle.tools.packager.mac.MacAppBundler;
import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.TbUser;
import com.zhengshun.touch.api.mapper.TbUserMapper;
import com.zhengshun.touch.api.mapper.TbUserScoreLogMapper;
import com.zhengshun.touch.api.domain.TbUserScoreLog;
import com.zhengshun.touch.api.service.TbUserScoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TbUserScoreLogServiceImp extends BaseServiceImpl<TbUserScoreLog, Long> implements TbUserScoreLogService {
    @Autowired
    private TbUserScoreLogMapper tbUserScoreLogMapper;
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public BaseMapper<TbUserScoreLog, Long> getMapper() {
        return tbUserScoreLogMapper;
    }

    @Override
    public Boolean saveUserScore(String rdSessionKey, BigDecimal score, Integer time, Integer difficut) {
        TbUserScoreLog tbUserScoreLog = new TbUserScoreLog();
        tbUserScoreLog.setScore( score );
        tbUserScoreLog.setTime( time );
        tbUserScoreLog.setDifficut( difficut );
        tbUserScoreLog.setCreateDate( new Date());
        Map<String, Object> params = new HashMap<>();
        params.put("rdSessionKey", rdSessionKey );
        TbUser tbUser = tbUserMapper.findSelective(params);
        if ( tbUser != null ) {
            tbUserScoreLog.setUserId( tbUser.getId() );
            int res = tbUserScoreLogMapper.insert( tbUserScoreLog );
            if ( res > 0 ) {
                return true;
            }
        }

        return false;
    }
}