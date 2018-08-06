package com.zhengshun.touch.api.service;

import com.github.pagehelper.Page;
import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.domain.TbCodeInfo;

import java.math.BigDecimal;
import java.util.Map;

public interface TbCodeInfoService extends BaseService<TbCodeInfo, Long> {

    Boolean saveCodeInfo (String content, BigDecimal score, Integer time, Integer isBug, Integer difficult, Integer gameTypeId);

    Page<TbCodeInfo> page(Map<String, Object> params, int currentPage, int pageSize);

    Page<TbCodeInfo> apipage(Map<String, Object> params, int currentPage, int pageSize);
}