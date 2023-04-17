package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.requests.StaffRequest;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import com.sakilaAPI.service.interfaces.StaffService;
import com.sakilaAPI.utils.mappers.StaffRequestMapper;
import com.sakilaAPI.utils.mappers.StaffResponseMapper;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StaffServiceImpl implements StaffService {
    private static StaffServiceImpl staffService;

    private StaffServiceImpl(){}

    public static StaffService getStaffService(){
        if(staffService == null)
            staffService = new StaffServiceImpl();
        return staffService;
    }

    @Override
    public List<StaffResponse> getAllStaffs(int limit, int offset){
        return RepositoryFactory.getInstance().createStaffRepository()
                .getAllEntities(limit, offset).stream()
                .map(StaffResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public StaffResponse getStaff(int id){
        Optional<Staff> staff = RepositoryFactory.getInstance().createStaffRepository()
                .getEntityById(id);
        if(staff.isPresent()){
            return StaffResponseMapper.INSTANCE.toDto(staff.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Staff not found for ID: " + id );
        }
    }

    @Override
    public StaffResponse addStaff(StaffRequest staff){
        Staff staffEntity = StaffRequestMapper.INSTANCE.toEntity(staff);
        staffEntity.setLastUpdate(Instant.now());
        staffEntity.setActive(true);
        return StaffResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createStaffRepository().addEntity(
                        staffEntity
                )
        );
    }

    @Override
    public void deleteStaff(int id){
        RepositoryFactory.getInstance().createStaffRepository().deleteEntityById(id);
    }

    @Override
    public StaffResponse updateStaff(StaffRequest staff, int id){
        Optional<Staff> staffEntity = RepositoryFactory.getInstance().createStaffRepository()
                .getEntityById(id);
        if(staffEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Staff not found for ID: " + id );
        }
        StaffRequestMapper.INSTANCE.updateEntity(staff, staffEntity.get());
        return StaffResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createStaffRepository().updateEntity(
                        staffEntity.get()
                )
        );
    }
}
