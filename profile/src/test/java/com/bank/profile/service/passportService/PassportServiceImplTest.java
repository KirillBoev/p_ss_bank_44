package com.bank.profile.service.passportService;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.repository.PassportRepository;
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

class PassportServiceImplTest {

    @Mock
    private PassportRepository passportRepository;

    @Mock
    private PassportMapper passportMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private PassportServiceImpl passportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllPassports() {
        List<Passport> passports = Arrays.asList(new Passport(), new Passport());
        when(passportRepository.findAll()).thenReturn(passports);

        List<Passport> result = passportService.getAllPassports();

        assertEquals(passports, result);
    }

    @Test
    void createPassport() {
        PassportDTO passportDTO = new PassportDTO();
        Passport passportEntity = new Passport();
        when(passportMapper.toEntity(passportDTO)).thenReturn(passportEntity);
        when(passportRepository.save(passportEntity)).thenReturn(passportEntity);
        when(passportMapper.toDto(passportEntity)).thenReturn(passportDTO);

        PassportDTO result = passportService.createPassport(passportDTO);

        assertEquals(passportDTO, result);
    }

    @Test
    void updatePassport() {
        Long id = 1L;
        PassportDTO passportDTO = new PassportDTO();
        Passport passportEntity = new Passport();
        Passport mergedPassportEntity = new Passport();
        when(passportRepository.findById(id)).thenReturn(Optional.of(passportEntity));
        when(passportMapper.mergeToEntity(passportDTO, passportEntity)).thenReturn(mergedPassportEntity);
        when(passportRepository.save(mergedPassportEntity)).thenReturn(mergedPassportEntity);
        when(passportMapper.toDto(mergedPassportEntity)).thenReturn(passportDTO);

        PassportDTO result = passportService.updatePassport(id, passportDTO);

        assertEquals(passportDTO, result);
    }

    @Test
    void deletePassport() {
        Long id = 1L;

        passportService.deletePassport(id);

        verify(passportRepository, times(1)).deleteById(id);
    }
}