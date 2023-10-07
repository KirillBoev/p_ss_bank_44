package com.bank.profile.mapper;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.entity.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface AuditMapper {
    @Mapping(target = "id", ignore = true)
    Audit toEntity(AuditDTO auditDTO);

    AuditDTO toDto(Audit audit);

    @Mapping(target = "id", ignore = true)
    Audit mergeToEntity(AuditDTO auditDTO, @MappingTarget Audit audit);
}
