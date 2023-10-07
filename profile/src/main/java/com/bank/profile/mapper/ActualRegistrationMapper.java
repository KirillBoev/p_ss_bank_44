package com.bank.profile.mapper;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface ActualRegistrationMapper {
    @Mapping(target = "id", ignore = true)
    ActualRegistration toEntity(ActualRegistrationDTO actualRegistrationDTO);

    ActualRegistrationDTO toDto(ActualRegistration actualRegistration);

    @Mapping(target = "id", ignore = true)
    ActualRegistration mergeToEntity(ActualRegistrationDTO actualRegistrationDTO, @MappingTarget ActualRegistration actualRegistration);
}
