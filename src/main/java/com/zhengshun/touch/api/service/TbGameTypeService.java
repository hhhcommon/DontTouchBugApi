package com.zhengshun.touch.api.service;

import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.domain.TbGameType;

import java.util.List;

public interface TbGameTypeService extends BaseService<TbGameType, Long> {

    Boolean saveGameType( String typeName );

    List<TbGameType> listGameType();

    List<TbGameType> listAllGameType();
}