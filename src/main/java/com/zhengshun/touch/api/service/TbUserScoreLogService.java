package com.zhengshun.touch.api.service;

import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.domain.TbUserScoreLog;

import java.math.BigDecimal;

public interface TbUserScoreLogService extends BaseService<TbUserScoreLog, Long> {

    Boolean saveUserScore(String rdSessionKey, BigDecimal score, Integer time, Integer difficut);
}