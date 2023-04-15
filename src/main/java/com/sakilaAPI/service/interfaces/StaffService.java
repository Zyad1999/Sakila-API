package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.responses.StaffResponse;

import java.util.List;

public interface StaffService {
    List<StaffResponse> getAllStaffs();

    StaffResponse getStaff(int id);
}
