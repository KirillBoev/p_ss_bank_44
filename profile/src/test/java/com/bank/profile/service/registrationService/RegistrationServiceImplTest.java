package com.bank.profile.service.registrationService;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.repository.RegistrationRepository;
import com.bank.profile.exception.EntityNotFoundReturner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class RegistrationServiceImplTest {

    @Mock
    private RegistrationRepository registrationRepository;

    @Mock
    private RegistrationMapper registrationMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllRegistrations() {
        List<Registration> registrations = Arrays.asList(new Registration(), new Registration());
        when(registrationRepository.findAll()).thenReturn(registrations);

        List<Registration> result = registrationService.getAllRegistrations();

        assertEquals(registrations, result);
    }

    @Test
    void createRegistration() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        Registration registrationEntity = new Registration();
        when(registrationMapper.toEntity(registrationDTO)).thenReturn(registrationEntity);
        when(registrationRepository.save(registrationEntity)).thenReturn(registrationEntity);
        when(registrationMapper.toDto(registrationEntity)).thenReturn(registrationDTO);

        RegistrationDTO result = registrationService.createRegistration(registrationDTO);

        assertEquals(registrationDTO, result);
    }

    @Test
    void updateRegistration() {
        Long id = 1L;
        RegistrationDTO registrationDTO = new RegistrationDTO();
        Registration registrationEntity = new Registration();
        Registration mergedRegistrationEntity = new Registration();
        when(registrationRepository.findById(id)).thenReturn(Optional.of(registrationEntity));
        when(registrationMapper.mergeToEntity(registrationDTO, registrationEntity)).thenReturn(mergedRegistrationEntity);
        when(registrationRepository.save(mergedRegistrationEntity)).thenReturn(mergedRegistrationEntity);
        when(registrationMapper.toDto(mergedRegistrationEntity)).thenReturn(registrationDTO);

        RegistrationDTO result = registrationService.updateRegistration(id, registrationDTO);

        assertEquals(registrationDTO, result);
    }


    @Test
    void deleteRegistration() {
        Long id = 1L;

        registrationService.deleteRegistration(id);

        verify(registrationRepository, times(1)).deleteById(id);
    }
}