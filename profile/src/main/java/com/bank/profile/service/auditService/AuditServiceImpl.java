package com.bank.profile.service.auditService;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.AuditMapper;
import com.bank.profile.repository.AuditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService{
    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найден аудит с ID ";

    @Override
    public AuditDTO findById(Long id) {
        return auditMapper.toDto(auditRepository.findById(id).orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE)));
    }
}
