package com.mykhaylenko.messanger.exception;

import com.mykhaylenko.messanger.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by pavlo.mykhaylenko on 7/29/2015.
 */
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "http://link.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}
