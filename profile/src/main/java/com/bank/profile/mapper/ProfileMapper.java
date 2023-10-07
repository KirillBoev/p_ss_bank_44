package com.bank.profile.mapper;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @Mapping(target = "id", ignore = true)
    Profile toEntity(ProfileDTO profileDto);

    ProfileDTO toDto(Profile profile);

    @Mapping(target = "id", ignore = true)
    Profile mergeToEntity(ProfileDTO profileDto, @MappingTarget Profile profile);
}
