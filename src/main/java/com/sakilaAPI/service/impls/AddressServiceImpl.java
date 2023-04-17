package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.requests.AddressRequest;
import com.sakilaAPI.service.interfaces.AddressService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private static AddressServiceImpl addressService;

    private AddressServiceImpl(){}

    public static AddressService getAddressService(){
        if(addressService == null)
            addressService = new AddressServiceImpl();
        return addressService;
    }

    @Override
    public List<AddressDto> getAllAddresses(int limit, int offset){
        return RepositoryFactory.getInstance().createAddressRepository()
                .getAllEntities(limit, offset).stream()
                .map(AddressMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public AddressDto getAddress(int id){
        Optional<Address> address = RepositoryFactory.getInstance().createAddressRepository()
                .getEntityById(id);
        if(address.isPresent()){
            return AddressMapper.INSTANCE.toDto(address.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Address not found for ID: " + id );
        }
    }

    @Override
    public AddressDto addAddress(AddressRequest address){
        Address addressEntity = AddressRequestMapper.INSTANCE.toEntity(address);
        addressEntity.setLastUpdate(Instant.now());
        return AddressMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createAddressRepository().addEntity(
                        addressEntity
                )
        );
    }

    @Override
    public void deleteAddress(int id){
        RepositoryFactory.getInstance().createAddressRepository().deleteEntityById(id);
    }

    @Override
    public AddressDto updateAddress(AddressRequest address, int id){
        Optional<Address> addressEntity = RepositoryFactory.getInstance().createAddressRepository()
                .getEntityById(id);
        if(addressEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Address not found for ID: " + id );
        }
        AddressRequestMapper.INSTANCE.updateEntity(address, addressEntity.get());
        return AddressMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createAddressRepository().updateEntity(
                        addressEntity.get()
                )
        );
    }
}
