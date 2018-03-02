package com.imooc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rj on 18/2/27.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",false);
        map.put("errorMessage",e.getMessage());
        return map;
    }
}
