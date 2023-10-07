package com.bank.profile.service.registrationService;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найдены данные о месте регистрации с ID ";
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    @Override
    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        Registration registration = registrationRepository.save(registrationMapper.toEntity(registrationDTO));
        return registrationMapper.toDto(registration);
    }
    @Override
    @Transactional
    public RegistrationDTO updateRegistration(Long id, RegistrationDTO registration) {
        Registration registrationEntity = registrationRepository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE));
        Registration newRegistration = registrationMapper.mergeToEntity(registration, registrationEntity);
        return registrationMapper.toDto(registrationRepository.save(newRegistration));
    }
    @Override
    @Transactional
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
