package com.zhengshun.touch.api.common;

import com.zhengshun.touch.api.common.context.Constant;

import java.util.Map;

/**
 * Iceman
 * 2017/11/13
 */
public class BaseResponse extends BaseObject {

    private Map<String, Object> data;
    private Integer code;
    private String msg;

    public BaseResponse() {
    }

    public BaseResponse(Map<String, Object> data, Integer code, String msg ) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static BaseResponse success() {
        return new BaseResponse( null, Constant.SUCCEED_CODE_VALUE, MsgUtils.OPERATE_SUCCESS_MSG );
    }

    public static BaseResponse success( Map<String, Object> data ) {
        return new BaseResponse( data, Constant.SUCCEED_CODE_VALUE, MsgUtils.OPERATE_SUCCESS_MSG );
    }

    public static BaseResponse fail() {
        return new BaseResponse( null, Constant.FAIL_CODE_VALUE, MsgUtils.OPERATE_FAIL_MSG );
    }

    public static BaseResponse fail( String msg ) {
        return new BaseResponse( null, Constant.FAIL_CODE_VALUE, msg );
    }

    public static BaseResponse fail( String msg, Map<String, Object> data ) {
        return new BaseResponse( data, Constant.FAIL_CODE_VALUE, msg );
    }

    public static BaseResponse fail( Integer code, String msg ) {
        return new BaseResponse( null, code, msg );
    }

    public Map< String, Object > getData() {
        return data;
    }

    public void setData( Map< String, Object > data ) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode( Integer code ) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }
    
}
