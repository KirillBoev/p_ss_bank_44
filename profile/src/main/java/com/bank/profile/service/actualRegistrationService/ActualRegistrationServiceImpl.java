package com.bank.profile.service.actualRegistrationService;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.repository.ActualRegistrationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class ActualRegistrationServiceImpl implements ActualRegistrationService {
    private final ActualRegistrationRepository actualRegistrationRepository;
    private final ActualRegistrationMapper actualRegistrationMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найдены данные об актуальном месте регистрации с ID ";
    public List<ActualRegistration> getAllActualRegistrations() {
        return actualRegistrationRepository.findAll();
    }
    @Override
    @Transactional
    public ActualRegistrationDTO createActualRegistration(ActualRegistrationDTO actualRegistrationDTO) {
        ActualRegistration actualRegistration = actualRegistrationRepository.save(actualRegistrationMapper.toEntity(actualRegistrationDTO));
        return actualRegistrationMapper.toDto(actualRegistration);
    }
    @Override
    @Transactional
    public ActualRegistrationDTO updateActualRegistration(Long id, ActualRegistrationDTO actualRegistration) {
        ActualRegistration actualRegistrationEntity = actualRegistrationRepository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE));
        ActualRegistration newActualRegistration = actualRegistrationMapper.mergeToEntity(actualRegistration, actualRegistrationEntity);
        return actualRegistrationMapper.toDto(actualRegistrationRepository.save(newActualRegistration));
    }
    @Override
    @Transactional
    public void deleteActualRegistration(Long id) {
        actualRegistrationRepository.deleteById(id);
    }
}
