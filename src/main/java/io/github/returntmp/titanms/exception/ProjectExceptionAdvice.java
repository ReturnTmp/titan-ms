package io.github.returntmp.titanms.exception;

import io.github.returntmp.titanms.common.ResponseCode;
import io.github.returntmp.titanms.controller.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目异常建议
 *
 * @author ReturnTmp
 * @date 2023/03/29
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    /**
     * 做系统异常
     *
     * @param ex
     * @return {@link Result}
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    /**
     * 做业务异常
     *
     * @param ex
     * @return {@link Result}
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    /**
     * 做其他异常
     *
     * @param ex
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        return new Result(ResponseCode.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
