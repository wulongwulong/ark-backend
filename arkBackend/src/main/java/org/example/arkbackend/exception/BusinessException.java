package org.example.arkbackend.exception;

import org.example.arkbackend.common.ResultCodeEnum;

/**
 * 业务异常
 *
 * @author markWu
 */
public class BusinessException extends RuntimeException  {

    private final Integer code;
    private final String message;

    public BusinessException(ResultCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public BusinessException(ResultCodeEnum codeEnum, String message) {
        super(message);
        this.code = codeEnum.getCode();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
