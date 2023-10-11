package com.bank.profile.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class AuditDTO {
    private Long Id;

    private String entityType;

    private String operationType;

    private String createdBy;

    private Long modifiedBy;

    private Timestamp createdAt;

    private Timestamp modifiedAt;

    private String newEntityJson;

    private String entityJson;
}
