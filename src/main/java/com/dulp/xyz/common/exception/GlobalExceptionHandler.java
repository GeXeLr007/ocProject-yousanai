package com.dulp.xyz.common.exception;

import com.dulp.xyz.common.result.CodeMsg;
import com.dulp.xyz.common.util.IMoocJSONResult;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return IMoocJSONResult.errorMsg(ex.getMessage());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return IMoocJSONResult.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
            return IMoocJSONResult.errorMsg(e.getMessage());
        }
    }
}
