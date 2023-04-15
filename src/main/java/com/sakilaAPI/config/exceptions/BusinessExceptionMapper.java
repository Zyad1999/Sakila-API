package com.sakilaAPI.config.exceptions;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        ExceptionMessage errorMessage = new ExceptionMessage(e.getMessage(), e.getCode(), e.getDescription());
        return Response.status(e.getCode()).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
    }
}