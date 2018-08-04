package com.zhengshun.touch.api.system.service;

import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.system.domain.SysRolePerm;

import java.util.List;

public interface SysRolePermService extends BaseService<SysRolePerm, Long> {

	/**
	 * 删除角色所有权限
	 * @param roleId
	 * @return
	 */
	int deleteByRoleId(Integer roleId);
	
	/**
	 * 修改用户权限
	 * @param roleId
	 * @param permIds
	 */
	void updatePerms(Integer roleId, List<Integer> permIds, String user);
}
