package com.zhengshun.touch.api.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 工具类-分表
 * @author xx
 * @version 1.0.0
 * @date 2017年6月5日 上午9:54:09
 * Copyright 杭州融都科技股份有限公司 金融创新事业部 cashloan  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class ShardTableUtil {
	
	public static List<String> tables = new ArrayList<String>();
	static{
		tables.add("cl_user_contacts");
		tables.add("cl_operator_voices");
	}
	
	/**
	 * 根据主键Id生成分表名称
	 * @param shardId 拆分id段
	 * @return
	 */
	public static String generateTableNameById(String tableName, long id, long shardId){
		if(tables.contains(tableName)){
			long num = id/shardId + 1;
			return tableName + "_" + num;
		}else{
			return tableName;
		}
	}

}
