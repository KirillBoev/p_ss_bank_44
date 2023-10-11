package com.bank.profile.controller;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.service.auditService.AuditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuditControllerTest {

    @Mock
    private AuditService auditService;

    @InjectMocks
    private AuditController auditController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        // Arrange
        Long id = 1L;
        AuditDTO auditDTO = new AuditDTO();
        when(auditService.findById(id)).thenReturn(auditDTO);

        // Act
        AuditDTO result = auditController.findById(id);

        // Assert
        assertEquals(auditDTO, result);
        verify(auditService, times(1)).findById(id);
    }
}