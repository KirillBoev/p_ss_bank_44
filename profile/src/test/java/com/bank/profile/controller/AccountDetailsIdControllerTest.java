package com.bank.profile.controller;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.service.accountDetailsIdService.AccountDetailsIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountDetailsIdControllerTest {

    @Mock
    private AccountDetailsIdService accountDetailsIdService;

    @InjectMocks
    private AccountDetailsIdController accountDetailsIdController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        // Arrange
        Long id = 1L;
        AccountDetailsIdDTO accountDetailsIdDTO = new AccountDetailsIdDTO();
        when(accountDetailsIdService.findById(id)).thenReturn(accountDetailsIdDTO);

        // Act
        AccountDetailsIdDTO result = accountDetailsIdController.findById(id);

        // Assert
        assertEquals(accountDetailsIdDTO, result);
        verify(accountDetailsIdService, times(1)).findById(id);
    }
}