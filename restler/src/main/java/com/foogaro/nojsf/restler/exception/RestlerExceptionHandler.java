package com.foogaro.nojsf.restler.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestlerExceptionHandler implements ExceptionMapper<RestlerException> {

    @Override
    public Response toResponse(RestlerException exception) {
        return Response.serverError().build();
    }
}
