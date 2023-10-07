package com.bank.profile.mapper;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.entity.AccountDetailsId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {
    @Mapping(target = "id", ignore = true)
    AccountDetailsId toEntity(AccountDetailsIdDTO accountDetailsIdDTO);

    AccountDetailsIdDTO toDto(AccountDetailsId accountDetailsId);

    @Mapping(target = "id", ignore = true)
    AccountDetailsId mergeToEntity(AccountDetailsIdDTO accountDetailsIdDTO, @MappingTarget AccountDetailsId accountDetailsId);
}
