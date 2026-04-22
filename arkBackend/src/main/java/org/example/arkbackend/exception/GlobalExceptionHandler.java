package org.example.arkbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.arkbackend.common.Result;
import org.example.arkbackend.common.ResultCodeEnum;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        log.warn("业务异常：code={}, message={}", e.getCode(), e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        String message = "参数校验失败";
        if (e.getBindingResult().hasFieldErrors()) {
            message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        }
        log.warn("参数异常：{}", message);
        return Result.fail(ResultCodeEnum.PARAM_ERROR.getCode(), message);
    }

    /**
     * 系统异常兜底
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("系统异常：", e);
        return Result.fail(ResultCodeEnum.SYSTEM_ERROR.getCode(),
                ResultCodeEnum.SYSTEM_ERROR.getMessage());
    }


//    @ExceptionHandler(Exception.class)
//    public Result<?> handleException(Exception e) {
//        log.error("系统异常：", e);
//        return Result.fail(ResultCodeEnum.SYSTEM_ERROR);
//    }

}
