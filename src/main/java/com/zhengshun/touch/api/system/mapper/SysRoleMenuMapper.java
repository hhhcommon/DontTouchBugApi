package com.zhengshun.touch.api.system.mapper;

import com.zhengshun.touch.api.common.exception.PersistentDataException;
import com.zhengshun.touch.api.common.mapper.BaseMapper;
import com.zhengshun.touch.api.common.mapper.RDBatisDao;
import com.zhengshun.touch.api.system.domain.SysRoleMenu;

import java.util.List;

/**
 * 
 * 角色菜单关系DAO
 * @version 1.0
 * @author 吴国成
 * @created 2014年9月22日 下午2:48:38
 */
@RDBatisDao
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu,Long> {
	
	/**
	 * 删除角色菜单关联表信息（物理删除）
	 * @param roleId 角色ID
	 * @version 1.0
	 * @author 吴国成
	 * @created 2014年9月22日
	 */
	void deleteByRoleId(long roleId);
	
	/**
	 * 角色菜单关联信息查询 LIST
	 * @param roleId  角色ID
	 * @return 角色菜单关系列表
	 * @version 1.0
	 * @author 吴国成
	 * @throws PersistentDataException 
	 * @created 2014年9月22日
	 */
	List<SysRoleMenu> getRoleMenuList(long roleId) throws PersistentDataException;
	
	void addRoleMenu(long roleId, Long menuId);
}
