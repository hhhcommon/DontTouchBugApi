package com.zhengshun.touch.api.system.mapper;

import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.system.domain.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * 
 * 用户角色DAO
 * @version 1.0
 * @author 吴国成
 * @created 2014年9月22日 下午2:47:14
 */
@RDBatisDao
public interface SysUserRoleMapper extends BaseMapper<SysUserRole, Long> {
	
	
	/**
	 * 根据用户ID删除
	 * @param userId 
	 * @version 1.0
	 * @author 吴国成
	 * @created 2014年9月22日
	 */
	void deleteByUserId(long userId);
	
	List<SysUserRole> getItemListByMap(Map<String, Object> param);

}
