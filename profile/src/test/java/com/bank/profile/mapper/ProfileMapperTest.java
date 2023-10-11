package com.bank.profile.mapper;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProfileMapperTest {

    private ProfileMapper profileMapper;

    @BeforeEach
    public void setUp() {
        profileMapper = Mappers.getMapper(ProfileMapper.class);
    }

    @Test
    public void testToEntity() {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail("john.smith@example.com");

        Profile profile = profileMapper.toEntity(profileDTO);

        assertNull(profile.getId());
        assertEquals("john.smith@example.com", profile.getEmail());
    }

    @Test
    public void testToDto() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setEmail("jane.smith@example.com");

        ProfileDTO profileDTO = profileMapper.toDto(profile);

        assertEquals(1L, profileDTO.getId());
        assertEquals("jane.smith@example.com", profileDTO.getEmail());
    }

    @Test
    public void testMergeToEntity() {
        ProfileDTO updatedProfileDTO = new ProfileDTO();
        updatedProfileDTO.setEmail("jane.smith@example.com");

        Profile existingProfile = new Profile();
        existingProfile.setId(1L);
        existingProfile.setEmail("john.smith@example.com");

        Profile mergedProfile = profileMapper.mergeToEntity(updatedProfileDTO, existingProfile);

        assertEquals(1L, mergedProfile.getId());
        assertEquals("jane.smith@example.com", mergedProfile.getEmail());
    }
}