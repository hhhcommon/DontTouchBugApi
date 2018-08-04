package com.zhengshun.touch.api.system.service.impl;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.system.domain.SysRolePerm;
import com.zhengshun.touch.api.system.mapper.SysRolePermMapper;
import com.zhengshun.touch.api.system.service.SysRolePermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("sysRolePermService")
public class SysRolePermServiceImpl extends BaseServiceImpl<SysRolePerm, Long> implements SysRolePermService {

	@Resource
	private SysRolePermMapper sysRolePermMapper;
	
	@Override
	public BaseMapper<SysRolePerm, Long> getMapper() {
		return sysRolePermMapper;
	}
	
	public int deleteByRoleId(Integer roleId) {
		return sysRolePermMapper.deleteByRoleId(roleId);
	}
	@Override
	public void updatePerms(Integer roleId, List<Integer> permIds,String user) {
		sysRolePermMapper.deleteByRoleId(roleId);
			
		for (Integer permId : permIds) {
			if(null!= permId){
			SysRolePerm rolePerm = new SysRolePerm();
			rolePerm.setRoleId(roleId);
			rolePerm.setPermId(permId);
			rolePerm.setAddTime(new Date());
			rolePerm.setAddUser(user);
			sysRolePermMapper.save(rolePerm);
			}
		}
	}

	
}
