package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.StaffRequest;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import com.sakilaAPI.service.impls.StaffServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Staff {

    @WebMethod
    public List<StaffResponse> getAllStaffs(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return StaffServiceImpl.getStaffService().getAllStaffs(limit, offset);
    }

    @WebMethod
    public StaffResponse getStaff(@WebParam(name = "id") int id){
        return StaffServiceImpl.getStaffService().getStaff(id);
    }

    @WebMethod
    public StaffResponse addStaff(StaffRequest staff){
        return StaffServiceImpl.getStaffService().addStaff(staff);
    }

    @WebMethod
    public void deleteStaff(@WebParam(name = "id") int id){
        StaffServiceImpl.getStaffService().deleteStaff(id);
    }

    @WebMethod
    public StaffResponse updateStaff(StaffRequest staff, @WebParam(name = "id") int id){
        return StaffServiceImpl.getStaffService().updateStaff(staff, id);
    }
}
