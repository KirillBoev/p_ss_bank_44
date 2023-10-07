package com.bank.profile.service.registrationService;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAllRegistrations();

    RegistrationDTO createRegistration(RegistrationDTO registrationDTO);

    RegistrationDTO updateRegistration(Long id, RegistrationDTO registration);

    void deleteRegistration(Long id);
}
