package com.bank.profile.mapper;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PassportMapperTest {

    private PassportMapper passportMapper;

    @BeforeEach
    public void setUp() {
        passportMapper = Mappers.getMapper(PassportMapper.class);
    }

    @Test
    public void testToEntity() {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setNumber(123456L);

        Passport passport = passportMapper.toEntity(passportDTO);

        assertNull(passport.getId());
        assertEquals(123456L, passport.getNumber());
    }

    @Test
    public void testToDto() {
        Passport passport = new Passport();
        passport.setNumber(789012L);

        PassportDTO passportDTO = passportMapper.toDto(passport);

        assertEquals(789012L, passportDTO.getNumber());
    }

    @Test
    public void testMergeToEntity() {
        PassportDTO updatedPassportDTO = new PassportDTO();
        updatedPassportDTO.setNumber(789012L);

        Passport existingPassport = new Passport();
        existingPassport.setId(1L);
        existingPassport.setNumber(123456L);

        Passport mergedPassport = passportMapper.mergeToEntity(updatedPassportDTO, existingPassport);

        assertEquals(1L, mergedPassport.getId());
        assertEquals(789012L, mergedPassport.getNumber());
    }
}