package com.bank.profile.mapper;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.entity.Audit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AuditMapperTest {

    private AuditMapper auditMapper;

    @BeforeEach
    public void setUp() {
        auditMapper = Mappers.getMapper(AuditMapper.class);
    }

    @Test
    public void testToEntity() {
        AuditDTO auditDTO = new AuditDTO();
        auditDTO.setEntityType("JSON");

        Audit audit = auditMapper.toEntity(auditDTO);

        assertNull(audit.getId());
        assertEquals("JSON", audit.getEntityType());
    }

    @Test
    public void testToDto() {
        Audit audit = new Audit();
        audit.setEntityType("JSON");

        AuditDTO auditDTO = auditMapper.toDto(audit);

        assertEquals("JSON", auditDTO.getEntityType());
    }

    @Test
    public void testMergeToEntity() {
        AuditDTO updatedAuditDTO = new AuditDTO();
        updatedAuditDTO.setEntityType("JSON");

        Audit existingAudit = new Audit();
        existingAudit.setId(1L);
        existingAudit.setEntityType("XML");

        Audit mergedAudit = auditMapper.mergeToEntity(updatedAuditDTO, existingAudit);

        assertEquals(1L, mergedAudit.getId());
        assertEquals("JSON", mergedAudit.getEntityType());
    }
}