package com.kong.common;

import lombok.Data;

@Data
public class ResultInfo {

    private int code;
    private String message;
    private Object result;

    public ResultInfo(Status status) {
        this.code = status.code;
        this.message = status.message;
    }

    public ResultInfo message(String message) {
        this.message = message;
        return this;
    }

    public ResultInfo result(Object result) {
        this.result = result;
        return this;
    }

    public enum Status {

        // 公共部分
        SUCCESS(200, "成功"),
        WARN(900, "失败"),
        FILE_WARN(400,"文件内容为空"),
        DISTINCT_WARN(903, "有重复的编码"),
        UNSET_WARN(904, "有关联的子项或实施清单未退回"),
        SQP_WARN(901, "有未删除的子项"),
        UNKNOWN_ERROR(9998, "未知异常"),
        SYSTEM_ERROR(9999, "系统异常"),

        // 上传文件
        FILE_NOT_EXIST(8001, "文件不存在"),

        ERROR_404(1001, "访问的路径不存在"),
        REQUEST_PARAMETER_ERROR(1002, "请求参数错误"),
        UNAUTHORITY(1003, "无访问权限"),


        // 登录
        LOGIN_EXPIRE(2001, "未登录或者登录失效"),
        LOGIN_CODE_ERROR(2002, "登录验证码错误"),
        LOGIN_ERROR(2003, "用户名不存在或密码错误"),
        LOGIN_USER_STATUS_ERROR(2004, "用户状态不正确"),
        LOGOUT_ERROR(2005, "退出失败，token不存在");

        private int code;
        private String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}
