package com.zhengshun.touch.api.system.service.impl;

import com.zhengshun.touch.api.common.exception.PersistentDataException;
import com.zhengshun.touch.api.common.exception.ServiceException;
import com.zhengshun.touch.api.system.domain.SysRoleMenu;
import com.zhengshun.touch.api.system.mapper.SysRoleMenuMapper;
import com.zhengshun.touch.api.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "sysRoleMenuServiceImpl")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Resource
	private SysRoleMenuMapper sysRoleMenuDao;
	
	@Override
	public List<SysRoleMenu> getRoleMenuList(Long roleId) throws ServiceException, PersistentDataException {
		return this.sysRoleMenuDao.getRoleMenuList(roleId);
	}

	public SysRoleMenuMapper getSysRoleMenuDao() {
		return sysRoleMenuDao;
	}

	public void setSysRoleMenuDao(SysRoleMenuMapper sysRoleMenuDao) {
		this.sysRoleMenuDao = sysRoleMenuDao;
	}



}
