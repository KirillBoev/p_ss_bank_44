package com.bank.profile.controller;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.service.profileService.ProfileService;
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

class ProfileControllerTest {

    @Mock
    private ProfileService profileService;

    @InjectMocks
    private ProfileController profileController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProfiles() {
        List<Profile> profiles = Arrays.asList(new Profile(), new Profile());
        when(profileService.getAllProfiles()).thenReturn(profiles);

        ResponseEntity<List<Profile>> responseEntity = profileController.getAllProfiles();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(profiles, responseEntity.getBody());
    }

    @Test
    void createProfile() {
        ProfileDTO profileDTO = new ProfileDTO();
        when(profileService.createProfile(profileDTO)).thenReturn(profileDTO);

        ResponseEntity<ProfileDTO> responseEntity = profileController.createProfile(profileDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(profileDTO, responseEntity.getBody());
    }

    @Test
    void updateProfile() {
        Long id = 1L;
        ProfileDTO profileDTO = new ProfileDTO();
        when(profileService.updateProfile(id, profileDTO)).thenReturn(profileDTO);

        ResponseEntity<ProfileDTO> responseEntity = profileController.updateProfile(id, profileDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(profileDTO, responseEntity.getBody());
    }

    @Test
    void deleteProfile() {
        Long id = 1L;

        HttpStatus status = profileController.deleteProfile(id);

        assertEquals(HttpStatus.OK, status);
        verify(profileService, times(1)).deleteProfile(id);
    }
}