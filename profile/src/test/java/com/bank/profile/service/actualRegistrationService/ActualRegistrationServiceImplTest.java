package com.bank.profile.service.actualRegistrationService;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.repository.ActualRegistrationRepository;
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

class ActualRegistrationServiceImplTest {

    @Mock
    private ActualRegistrationRepository actualRegistrationRepository;

    @Mock
    private ActualRegistrationMapper actualRegistrationMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private ActualRegistrationServiceImpl actualRegistrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllActualRegistrations() {
        List<ActualRegistration> actualRegistrations = Arrays.asList(new ActualRegistration(), new ActualRegistration());
        when(actualRegistrationRepository.findAll()).thenReturn(actualRegistrations);

        List<ActualRegistration> result = actualRegistrationService.getAllActualRegistrations();

        assertEquals(actualRegistrations, result);
    }

    @Test
    void createActualRegistration() {
        ActualRegistrationDTO actualRegistrationDTO = new ActualRegistrationDTO();
        ActualRegistration actualRegistrationEntity = new ActualRegistration();
        when(actualRegistrationMapper.toEntity(actualRegistrationDTO)).thenReturn(actualRegistrationEntity);
        when(actualRegistrationRepository.save(actualRegistrationEntity)).thenReturn(actualRegistrationEntity);
        when(actualRegistrationMapper.toDto(actualRegistrationEntity)).thenReturn(actualRegistrationDTO);

        ActualRegistrationDTO result = actualRegistrationService.createActualRegistration(actualRegistrationDTO);

        assertEquals(actualRegistrationDTO, result);
    }

    @Test
    void updateActualRegistration() {
        Long id = 1L;
        ActualRegistrationDTO actualRegistrationDTO = new ActualRegistrationDTO();
        ActualRegistration actualRegistrationEntity = new ActualRegistration();
        ActualRegistration mergedActualRegistrationEntity = new ActualRegistration();
        when(actualRegistrationRepository.findById(id)).thenReturn(Optional.of(actualRegistrationEntity));
        when(actualRegistrationMapper.mergeToEntity(actualRegistrationDTO, actualRegistrationEntity)).thenReturn(mergedActualRegistrationEntity);
        when(actualRegistrationRepository.save(mergedActualRegistrationEntity)).thenReturn(mergedActualRegistrationEntity);
        when(actualRegistrationMapper.toDto(mergedActualRegistrationEntity)).thenReturn(actualRegistrationDTO);

        ActualRegistrationDTO result = actualRegistrationService.updateActualRegistration(id, actualRegistrationDTO);

        assertEquals(actualRegistrationDTO, result);
    }

    @Test
    void deleteActualRegistration() {
        Long id = 1L;

        actualRegistrationService.deleteActualRegistration(id);

        verify(actualRegistrationRepository, times(1)).deleteById(id);
    }
}