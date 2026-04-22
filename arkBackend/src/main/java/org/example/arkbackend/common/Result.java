package org.example.arkbackend.common;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;

//    //请求成功，返回
//    public static <T> Result<T> success(T data) {
//        Result<T> r = new Result<>();
//        r.setCode(200);
//        r.setMessage("成功");
//        r.setData(data);
//        return r;
//    }
//
//    //请求失败，返回
//    public static <T> Result<T> fail(String message) {
//        Result<T> r = new Result<>();
//        r.setCode(1);
//        r.setMessage(message);
//        return r;
//    }

    /// ////
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail(ResultCodeEnum codeEnum) {
        Result<T> r = new Result<>();
        r.setCode(codeEnum.getCode());
        r.setMessage(codeEnum.getMessage());
        r.setData(null);
        return r;
    }

    public static <T> Result<T> fail(ResultCodeEnum codeEnum, String message) {
        Result<T> r = new Result<>();
        r.setCode(codeEnum.getCode());
        r.setMessage(message);
        r.setData(null);
        return r;
    }

    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMessage(message);
        r.setData(null);
        return r;
    }

}
