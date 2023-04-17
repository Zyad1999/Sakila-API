package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.requests.StaffRequest;
import com.sakilaAPI.service.dtos.responses.StaffResponse;

import java.util.List;

public interface StaffService {
    List<StaffResponse> getAllStaffs(int limit, int offset);

    StaffResponse getStaff(int id);

    StaffResponse addStaff(StaffRequest staff);

    void deleteStaff(int id);

    StaffResponse updateStaff(StaffRequest staff, int id);
}
