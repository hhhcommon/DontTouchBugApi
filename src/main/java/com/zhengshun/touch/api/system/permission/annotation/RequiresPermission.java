package com.zhengshun.touch.api.system.permission.annotation;

import java.lang.annotation.*;


@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermission {
	/** 用":"分割权限唯一标识  ,与请求路径一致  */
    String code();
    /** 声明权限点 */
    String name();
}