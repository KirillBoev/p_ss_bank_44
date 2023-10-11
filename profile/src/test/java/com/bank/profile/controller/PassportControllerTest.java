package com.bank.profile.controller;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import com.bank.profile.service.passportService.PassportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PassportControllerTest {
    @Mock
    private PassportService passportService;

    @InjectMocks
    private PassportController passportController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllPassports() {
        List<Passport> passports = Arrays.asList(new Passport(), new Passport());
        when(passportService.getAllPassports()).thenReturn(passports);

        ResponseEntity<List<Passport>> responseEntity = passportController.getAllPassports();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(passports, responseEntity.getBody());
    }

    @Test
    void createPassport() {
        PassportDTO passportDTO = new PassportDTO();
        when(passportService.createPassport(passportDTO)).thenReturn(passportDTO);

        ResponseEntity<PassportDTO> responseEntity = passportController.createPassport(passportDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(passportDTO, responseEntity.getBody());
    }

    @Test
    void updatePassport() {
        Long id = 1L;
        PassportDTO passportDTO = new PassportDTO();
        when(passportService.updatePassport(id, passportDTO)).thenReturn(passportDTO);

        ResponseEntity<PassportDTO> responseEntity = passportController.updatePassport(id, passportDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(passportDTO, responseEntity.getBody());
    }

    @Test
    void deletePassport() {
        Long id = 1L;

        HttpStatus status = passportController.deletePassport(id);

        assertEquals(HttpStatus.OK, status);
        verify(passportService, times(1)).deletePassport(id);
    }
}