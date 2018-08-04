/**
 *
 *
 * @author rd
 * @version 1.0.0.0
 * @date 2016年12月02日 下午14:56:41
 * Copyright 杭州融都科技股份有限公司 资金托管系统  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 
 * 未经授权不得进行修改、复制、出售及商业使用
 */
package com.zhengshun.touch.api.system.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.system.domain.SysRolePerm;

@RDBatisDao
public interface SysRolePermMapper extends BaseMapper<SysRolePerm, Long> {

    SysRolePerm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolePerm record);
    
    int deleteByRoleId(Integer roleId);
    
}