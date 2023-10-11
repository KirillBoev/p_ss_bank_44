package com.bank.profile.controller;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.service.actualRegistrationService.ActualRegistrationService;
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

class ActualRegistrationControllerTest {
    @Mock
    private ActualRegistrationService actualRegistrationService;

    @InjectMocks
    private ActualRegistrationController actualRegistrationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllActualRegistrations() {
        List<ActualRegistration> actualRegistrations = Arrays.asList(new ActualRegistration(), new ActualRegistration());
        when(actualRegistrationService.getAllActualRegistrations()).thenReturn(actualRegistrations);

        ResponseEntity<List<ActualRegistration>> responseEntity = actualRegistrationController.getAllActualRegistrations();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(actualRegistrations, responseEntity.getBody());
    }

    @Test
    void createActualRegistration() {
        ActualRegistrationDTO actualRegistrationDTO = new ActualRegistrationDTO();
        when(actualRegistrationService.createActualRegistration(actualRegistrationDTO)).thenReturn(actualRegistrationDTO);

        ResponseEntity<ActualRegistrationDTO> responseEntity = actualRegistrationController.createActualRegistration(actualRegistrationDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(actualRegistrationDTO, responseEntity.getBody());
    }

    @Test
    void updateActualRegistration() {
        Long id = 1L;
        ActualRegistrationDTO actualRegistrationDTO = new ActualRegistrationDTO();
        when(actualRegistrationService.updateActualRegistration(id, actualRegistrationDTO)).thenReturn(actualRegistrationDTO);

        ResponseEntity<ActualRegistrationDTO> responseEntity = actualRegistrationController.updateActualRegistration(id, actualRegistrationDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(actualRegistrationDTO, responseEntity.getBody());
    }

    @Test
    void deleteActualRegistration() {
        Long id = 1L;

        HttpStatus status = actualRegistrationController.deleteActualRegistration(id);

        assertEquals(HttpStatus.OK, status);
        verify(actualRegistrationService, times(1)).deleteActualRegistration(id);
    }
}