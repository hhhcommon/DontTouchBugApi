package com.zhengshun.touch.api.system.service.impl;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.impl.BaseServiceImpl;
import com.zhengshun.touch.api.system.domain.SysPerm;
import com.zhengshun.touch.api.system.mapper.SysPermMapper;
import com.zhengshun.touch.api.system.service.SysPermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("sysPermService")
public class SysPermServiceImpl extends BaseServiceImpl<SysPerm,Long> implements SysPermService {

	@Resource
	private SysPermMapper sysPermDao;

	@Override
	public int updateByPrimaryKeySelective(SysPerm record) {
		return sysPermDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<SysPerm> listByUserName(String userName) {
		return sysPermDao.listByUserName(userName);
	}

	@Override
	public List<Map<String, Object>> fetchAll() {
		return sysPermDao.fetchAll();
	}

	@Override
	public List<SysPerm> listByRoleId(Long roleId) {
		return sysPermDao.listByRoleId(roleId);
	}

	@Override
	public BaseMapper<SysPerm,Long> getMapper() {
		return sysPermDao;
	}


}
