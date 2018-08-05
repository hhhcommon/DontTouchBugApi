package com.zhengshun.touch.api.service;

import com.zhengshun.touch.api.common.service.BaseService;
import com.zhengshun.touch.api.domain.TbUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface TbUserService extends BaseService<TbUser, Long> {

    Map<String, Object> saveUser(HttpServletRequest request, String avatarUrl, String city, String country, Integer gender, String language, String nickName, String openId, String province );
}