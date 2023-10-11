package com.bank.profile.mapper;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ActualRegistrationMapperTest {

    private ActualRegistrationMapper actualRegistrationMapper;

    @BeforeEach
    public void setUp() {
        actualRegistrationMapper = Mappers.getMapper(ActualRegistrationMapper.class);
    }

    @Test
    public void testToEntity() {
        ActualRegistrationDTO actualRegistrationDTO = new ActualRegistrationDTO();
        actualRegistrationDTO.setStreet("123 Main St");

        ActualRegistration actualRegistration = actualRegistrationMapper.toEntity(actualRegistrationDTO);

        assertNull(actualRegistration.getId());
        assertEquals("123 Main St", actualRegistration.getStreet());
    }

    @Test
    public void testToDto() {
        ActualRegistration actualRegistration = new ActualRegistration();
        actualRegistration.setStreet("456 Oak St");

        ActualRegistrationDTO actualRegistrationDTO = actualRegistrationMapper.toDto(actualRegistration);

        assertEquals("456 Oak St", actualRegistrationDTO.getStreet());
    }

    @Test
    public void testMergeToEntity() {
        ActualRegistrationDTO updatedActualRegistrationDTO = new ActualRegistrationDTO();
        updatedActualRegistrationDTO.setStreet("789 Pine St");

        ActualRegistration existingActualRegistration = new ActualRegistration();
        existingActualRegistration.setId(1L);
        existingActualRegistration.setStreet("Original Address");

        ActualRegistration mergedActualRegistration = actualRegistrationMapper.mergeToEntity(updatedActualRegistrationDTO, existingActualRegistration);

        assertEquals(1L, mergedActualRegistration.getId());
        assertEquals("789 Pine St", mergedActualRegistration.getStreet());
    }
}