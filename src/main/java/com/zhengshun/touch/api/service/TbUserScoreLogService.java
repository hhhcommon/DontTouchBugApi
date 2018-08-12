package com.zhengshun.touch.api.service;

import com.oracle.tools.packager.mac.MacAppBundler;
import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.domain.TbUserScoreLog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TbUserScoreLogService extends BaseService<TbUserScoreLog, Long> {

    Boolean saveUserScore(String rdSessionKey, BigDecimal score, Integer time, Integer difficut, String steps);

    Map<String, Object> getRank(String rdSessionKey);
}