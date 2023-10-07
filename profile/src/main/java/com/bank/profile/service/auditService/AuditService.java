package com.bank.profile.service.auditService;

import com.bank.profile.dto.AuditDTO;

public interface AuditService {
    AuditDTO findById(Long id);
}
