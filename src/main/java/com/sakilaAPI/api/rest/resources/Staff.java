package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.StaffDto;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import com.sakilaAPI.service.impls.LanguageServiceImpl;
import com.sakilaAPI.service.impls.StaffServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("staff")
public class Staff {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffResponse> getAllStaffs() {
        return StaffServiceImpl.getStaffService().getAllStaffs();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffResponse getStaff(@PathParam("id") int id){
        return StaffServiceImpl.getStaffService().getStaff(id);
    }
}