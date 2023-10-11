package com.bank.profile.mapper;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RegistrationMapperTest {

    private RegistrationMapper registrationMapper;

    @BeforeEach
    public void setUp() {
        registrationMapper = Mappers.getMapper(RegistrationMapper.class);
    }

    @Test
    public void testToEntity() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setCity("Moskow");

        Registration registration = registrationMapper.toEntity(registrationDTO);

        assertNull(registration.getId());
        assertEquals("Moskow", registration.getCity());
    }

    @Test
    public void testToDto() {
        Registration registration = new Registration();
        registration.setCity("Moskow");

        RegistrationDTO registrationDTO = registrationMapper.toDto(registration);

        assertEquals("Moskow", registrationDTO.getCity());
    }

    @Test
    public void testMergeToEntity() {
        RegistrationDTO updatedRegistrationDTO = new RegistrationDTO();
        updatedRegistrationDTO.setCity("Volgograd");

        Registration existingRegistration = new Registration();
        existingRegistration.setId(1L);
        existingRegistration.setCity("Moskow");

        Registration mergedRegistration = registrationMapper.mergeToEntity(updatedRegistrationDTO, existingRegistration);

        assertEquals(1L, mergedRegistration.getId());
        assertEquals("Volgograd", mergedRegistration.getCity());
    }
}