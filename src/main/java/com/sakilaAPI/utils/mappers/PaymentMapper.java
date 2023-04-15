package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Payment;
import com.sakilaAPI.service.dtos.PaymentDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {StaffMapper.class, RentalMapper.class})
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );
    Payment toEntity(PaymentDto paymentDto);

    PaymentDto toDto(Payment payment);
}