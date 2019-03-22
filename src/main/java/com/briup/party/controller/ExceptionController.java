package com.briup.party.controller;

import com.briup.party.util.MsgResponse;
import com.briup.party.util.exception.MyException;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class ExceptionController {
    // 捕捉shiro的异常 AuthorizationException UnauthenticatedException
    @ExceptionHandler(ShiroException.class)
    public MsgResponse handle401() {
        return MsgResponse.unauthorized("您没有权限访问");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public MsgResponse ErrorHandler(Exception ex) {
        ex.printStackTrace();
        return MsgResponse.error(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MyException.class)
    public MsgResponse myErrorHandler(MyException ex) {
        ex.printStackTrace();
        return MsgResponse.exception(ex.getCode(), ex.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(MultipartException.class)
    public MsgResponse handleError1(MultipartException ex) {
        return MsgResponse.exception(998, 998 + ex.getMessage());
    }
}
