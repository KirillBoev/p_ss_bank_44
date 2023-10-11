package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.service.registrationService.RegistrationService;
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

class RegistrationControllerTest {

    @Mock
    private RegistrationService registrationService;

    @InjectMocks
    private RegistrationController registrationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllRegistrations() {
        List<Registration> registrations = Arrays.asList(new Registration(), new Registration());
        when(registrationService.getAllRegistrations()).thenReturn(registrations);

        ResponseEntity<List<Registration>> responseEntity = registrationController.getAllRegistrations();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(registrations, responseEntity.getBody());
    }

    @Test
    void createRegistration() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        when(registrationService.createRegistration(registrationDTO)).thenReturn(registrationDTO);

        ResponseEntity<RegistrationDTO> responseEntity = registrationController.createRegistration(registrationDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(registrationDTO, responseEntity.getBody());
    }

    @Test
    void updateRegistration() {
        Long id = 1L;
        RegistrationDTO registrationDTO = new RegistrationDTO();
        when(registrationService.updateRegistration(id, registrationDTO)).thenReturn(registrationDTO);

        ResponseEntity<RegistrationDTO> responseEntity = registrationController.updateRegistration(id, registrationDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(registrationDTO, responseEntity.getBody());
    }

    @Test
    void deleteRegistration() {
        Long id = 1L;

        HttpStatus status = registrationController.deleteRegistration(id);

        assertEquals(HttpStatus.OK, status);
        verify(registrationService, times(1)).deleteRegistration(id);
    }
}