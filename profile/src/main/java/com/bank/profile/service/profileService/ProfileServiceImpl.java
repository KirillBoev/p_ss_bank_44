package com.bank.profile.service.profileService;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найден профиль с ID ";
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
    @Override
    @Transactional
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        Profile profile = profileRepository.save(profileMapper.toEntity(profileDTO));
        return profileMapper.toDto(profile);
    }
    @Override
    @Transactional
    public ProfileDTO updateProfile(Long id, ProfileDTO profile) {
        Profile profileEntity = profileRepository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE));
        Profile newProfile = profileMapper.mergeToEntity(profile, profileEntity);
        return profileMapper.toDto(profileRepository.save(newProfile));
    }
    @Override
    @Transactional
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
