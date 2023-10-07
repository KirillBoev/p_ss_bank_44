package com.bank.profile.mapper;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface PassportMapper {
    @Mapping(target = "id", ignore = true)
    Passport toEntity(PassportDTO passportDTO);

    PassportDTO toDto(Passport passport);

    @Mapping(target = "id", ignore = true)
    Passport mergeToEntity(PassportDTO passportDTO, @MappingTarget Passport passport);
}
