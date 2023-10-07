package com.bank.profile.service.profileService;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    ProfileDTO createProfile(ProfileDTO profileDTO);
    ProfileDTO updateProfile(Long id, ProfileDTO profile);
    void deleteProfile(Long id);
}
