package com.bank.profile.service.auditService;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.entity.Audit;
import com.bank.profile.mapper.AuditMapper;
import com.bank.profile.repository.AuditRepository;
import com.bank.profile.exception.EntityNotFoundReturner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

class AuditServiceImplTest {

    @Mock
    private AuditRepository auditRepository;

    @Mock
    private AuditMapper auditMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private AuditServiceImpl auditService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        Long id = 1L;
        Audit auditEntity = new Audit();
        AuditDTO auditDTO = new AuditDTO();
        when(auditRepository.findById(id)).thenReturn(Optional.of(auditEntity));
        when(auditMapper.toDto(auditEntity)).thenReturn(auditDTO);

        AuditDTO result = auditService.findById(id);

        assertEquals(auditDTO, result);
    }

    @Test
    void findByIdEntityNotFound() {
        Long id = 1L;
        when(auditRepository.findById(id)).thenReturn(Optional.empty());
        when(notFoundReturner.getEntityNotFoundException(id, "Не найден аудит с ID ")).thenReturn(new EntityNotFoundException(""));

        assertThrows(EntityNotFoundException.class, () -> auditService.findById(id));
    }
}