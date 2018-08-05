package com.zhengshun.touch.api.service.imp;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.domain.TbCodeInfo;
import com.zhengshun.touch.api.mapper.TbGameTypeMapper;
import com.zhengshun.touch.api.domain.TbGameType;
import com.zhengshun.touch.api.service.TbGameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbGameTypeServiceImp extends BaseServiceImpl<TbGameType, Long> implements TbGameTypeService {
    @Autowired
    private TbGameTypeMapper tbGameTypeMapper;

    @Override
    public BaseMapper<TbGameType, Long> getMapper() {
        return tbGameTypeMapper;
    }

    @Override
    public Boolean saveGameType(String typeName) {
        TbGameType tbGameType = new TbGameType();
        tbGameType.setTypeName( typeName );
        tbGameType.setCreateDate( new Date());
        int res = tbGameTypeMapper.insert( tbGameType );
        if ( res > 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public List<TbGameType> listGameType() {
        Map<String, Object> params = new HashMap<>();
        params.put("status", 1 );
        params.put("deleteFlag", 0 );
        return tbGameTypeMapper.listGameType( params );
    }

    @Override
    public List<TbGameType> listAllGameType() {
        return tbGameTypeMapper.listGameType( null );
    }
}