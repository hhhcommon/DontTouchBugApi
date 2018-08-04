package com.zhengshun.touch.api.common.service.impl;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.service.BaseService;

import javax.annotation.Resource;
import java.io.Serializable;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
	
	@Resource
	private BaseMapper<T, ID> baseMapper;
	
	public int insert(T record) {
		return getMapper().save(record);
	}

	public T getById(ID id) {
		return getMapper().findByPrimary(id);
	}

	public int updateById(T record) {
		return getMapper().update(record);
	}

	public abstract BaseMapper<T, ID> getMapper();
	
	/*protected String getLoginName() {
		// 增加用户登录判断
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}*/

}
