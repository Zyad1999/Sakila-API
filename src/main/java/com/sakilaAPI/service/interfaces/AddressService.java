package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.requests.AddressRequest;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAllAddresses(int limit, int offset);

    AddressDto getAddress(int id);

    AddressDto addAddress(AddressRequest address);

    void deleteAddress(int id);

    AddressDto updateAddress(AddressRequest address, int id);
}
