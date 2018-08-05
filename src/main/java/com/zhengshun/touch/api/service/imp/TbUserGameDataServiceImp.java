package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.TbUserGameData;
import com.zhengshun.touch.api.mapper.TbUserGameDataMapper;
import com.zhengshun.touch.api.service.TbUserGameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserGameDataServiceImp extends BaseServiceImpl<TbUserGameData, Long> implements TbUserGameDataService {
    @Autowired
    private TbUserGameDataMapper tbUserGameDataMapper;

    @Override
    public BaseMapper<TbUserGameData, Long> getMapper() {
        return tbUserGameDataMapper;
    }
}