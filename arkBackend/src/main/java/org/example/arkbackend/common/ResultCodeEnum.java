package org.example.arkbackend.common;

public enum ResultCodeEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1001, "参数错误"),
    USER_NOT_FOUND(1002, "用户不存在"),
    USERNAME_EXIST(1003, "用户名已存在"),
    SYSTEM_ERROR(5000, "---***系统异常***---");

    private final int code;
    private final String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
