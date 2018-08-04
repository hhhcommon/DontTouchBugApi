package com.zhengshun.touch.api.system.service.impl;

import com.zhengshun.touch.api.common.exception.ServiceException;
import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.system.domain.SysUserRole;
import com.zhengshun.touch.api.system.mapper.SysUserRoleMapper;
import com.zhengshun.touch.api.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "sysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, Long> implements SysUserRoleService {

	@Resource
	private SysUserRoleMapper sysUserRoleDao;
	
	@Override
	public List<SysUserRole> getSysUserRoleList(Long userId) throws ServiceException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		return sysUserRoleDao.getItemListByMap(map);
	}


	@Override
	public BaseMapper<SysUserRole, Long> getMapper() {
		return sysUserRoleDao;
	}
	


}
