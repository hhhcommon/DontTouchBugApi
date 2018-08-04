package com.zhengshun.touch.api.system.service;

import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.system.domain.SysPerm;

import java.util.List;
import java.util.Map;

public interface SysPermService extends BaseService<SysPerm, Long> {

	int updateByPrimaryKeySelective(SysPerm record);
	    
	List<SysPerm> listByUserName(String userName);
	
	List<SysPerm> listByRoleId(Long roleId);
	
	List<Map<String, Object>> fetchAll();
}
