package com.bank.profile.service.actualRegistrationService;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;

import java.util.List;

public interface ActualRegistrationService {
    List<ActualRegistration> getAllActualRegistrations();

    ActualRegistrationDTO createActualRegistration(ActualRegistrationDTO actualRegistrationDTO);

    ActualRegistrationDTO updateActualRegistration(Long id, ActualRegistrationDTO actualRegistration);

    void deleteActualRegistration(Long id);
}
