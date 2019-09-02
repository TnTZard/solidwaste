package com.anzhi.solidwaste.common.handler;

import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.response.AzResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anzhi
 * @date 2019/9/2 9:58
 */
public class BadRequestExceptionHandler {


    @ExceptionHandler(AzException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AzResponse handleAzException(AzException e) {
        return new AzResponse(false,null,null,e.getMessage());
    }


}
