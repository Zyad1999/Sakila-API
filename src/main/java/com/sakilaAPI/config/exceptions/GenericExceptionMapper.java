package com.sakilaAPI.config.exceptions;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLMMMMMMMMMMMMMMMMMMMM");
        System.out.println(e);
        ExceptionMessage errorMessage = new ExceptionMessage(e.getMessage(), 500, "Error during serving request please try again");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
    }
}