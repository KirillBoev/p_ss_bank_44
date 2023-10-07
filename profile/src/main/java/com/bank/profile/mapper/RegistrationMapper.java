package com.bank.profile.mapper;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    @Mapping(target = "id", ignore = true)
    Registration toEntity(RegistrationDTO registrationDto);

    RegistrationDTO toDto(Registration registration);

    @Mapping(target = "id", ignore = true)
    Registration mergeToEntity(RegistrationDTO registrationDto, @MappingTarget Registration registration);
}
