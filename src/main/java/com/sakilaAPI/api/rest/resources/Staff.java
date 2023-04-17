package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;
import com.sakilaAPI.service.dtos.requests.StaffRequest;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import com.sakilaAPI.service.impls.LanguageServiceImpl;
import com.sakilaAPI.service.impls.StaffServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("staff")
public class Staff {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffResponse> getAllStaffs(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return StaffServiceImpl.getStaffService().getAllStaffs(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffResponse getStaff(@PathParam("id") int id){
        return StaffServiceImpl.getStaffService().getStaff(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StaffResponse addStaff(StaffRequest staff){
        return StaffServiceImpl.getStaffService().addStaff(staff);
    }

    @DELETE
    @Path("{id}")
    public Response deleteStaff(@PathParam("id") int id){
        StaffServiceImpl.getStaffService().deleteStaff(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StaffResponse updateStaff(StaffRequest staff, @PathParam("id") int id){
        return StaffServiceImpl.getStaffService().updateStaff(staff, id);
    }
}