package com.bank.profile.service.profileService;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.repository.ProfileRepository;
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

class ProfileServiceImplTest {

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private ProfileMapper profileMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private ProfileServiceImpl profileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProfiles() {
        List<Profile> profiles = Arrays.asList(new Profile(), new Profile());
        when(profileRepository.findAll()).thenReturn(profiles);

        List<Profile> result = profileService.getAllProfiles();

        assertEquals(profiles, result);
    }

    @Test
    void createProfile() {
        ProfileDTO profileDTO = new ProfileDTO();
        Profile profileEntity = new Profile();
        when(profileMapper.toEntity(profileDTO)).thenReturn(profileEntity);
        when(profileRepository.save(profileEntity)).thenReturn(profileEntity);
        when(profileMapper.toDto(profileEntity)).thenReturn(profileDTO);

        ProfileDTO result = profileService.createProfile(profileDTO);

        assertEquals(profileDTO, result);
    }

    @Test
    void updateProfile() {
        Long id = 1L;
        ProfileDTO profileDTO = new ProfileDTO();
        Profile profileEntity = new Profile();
        Profile mergedProfileEntity = new Profile();
        when(profileRepository.findById(id)).thenReturn(Optional.of(profileEntity));
        when(profileMapper.mergeToEntity(profileDTO, profileEntity)).thenReturn(mergedProfileEntity);
        when(profileRepository.save(mergedProfileEntity)).thenReturn(mergedProfileEntity);
        when(profileMapper.toDto(mergedProfileEntity)).thenReturn(profileDTO);

        ProfileDTO result = profileService.updateProfile(id, profileDTO);

        assertEquals(profileDTO, result);
    }

    @Test
    void updateProfileEntityNotFound() {
        Long id = 1L;
        ProfileDTO profileDTO = new ProfileDTO();
        when(profileRepository.findById(id)).thenReturn(Optional.empty());
        when(notFoundReturner.getEntityNotFoundException(id, "Не найден профиль с ID ")).thenReturn(new EntityNotFoundException(""));

        assertThrows(EntityNotFoundException.class, () -> profileService.updateProfile(id, profileDTO));
    }

    @Test
    void deleteProfile() {
        Long id = 1L;

        profileService.deleteProfile(id);

        verify(profileRepository, times(1)).deleteById(id);
    }
}