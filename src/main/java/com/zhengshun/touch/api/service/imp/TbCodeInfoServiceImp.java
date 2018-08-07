package com.zhengshun.touch.api.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.mapper.TbCodeInfoMapper;
import com.zhengshun.touch.api.domain.TbCodeInfo;
import com.zhengshun.touch.api.service.TbCodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TbCodeInfoServiceImp extends BaseServiceImpl<TbCodeInfo, Long> implements TbCodeInfoService {
    @Autowired
    private TbCodeInfoMapper tbCodeInfoMapper;

    @Override
    public BaseMapper<TbCodeInfo, Long> getMapper() {
        return tbCodeInfoMapper;
    }

    @Override
    public Boolean saveCodeInfo(String content, BigDecimal score, Integer time, Integer isBug, Integer difficult, Integer gameTypeId) {
        TbCodeInfo tbCodeInfo = new TbCodeInfo();
        tbCodeInfo.setContent( content );
        tbCodeInfo.setScore( score );
        tbCodeInfo.setTime( time );
        tbCodeInfo.setIsBug( isBug );
        tbCodeInfo.setDifficult( difficult );
        tbCodeInfo.setCreateDate( new Date() );
        tbCodeInfo.setGameTypeId( gameTypeId );
        int res = tbCodeInfoMapper.insert( tbCodeInfo );
        if ( res > 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public Page<TbCodeInfo> page(Map<String, Object> params, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<TbCodeInfo> list = tbCodeInfoMapper.listSelective(params);
        return (Page<TbCodeInfo>) list;
    }

    @Override
    public Page<TbCodeInfo> apipage(Map<String, Object> params, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        params.put("status", 1);
        params.put("deleteFlag", 0);
        List<TbCodeInfo> list = tbCodeInfoMapper.listSelective(params);
        return (Page<TbCodeInfo>) list;
    }
}