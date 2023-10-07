package com.bank.profile.service.passportService;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.repository.PassportRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final PassportMapper passportMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найдены паспортные данные с ID ";
    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }
    @Override
    @Transactional
    public PassportDTO createPassport(PassportDTO passportDTO) {
        Passport passport = passportRepository.save(passportMapper.toEntity(passportDTO));
        return passportMapper.toDto(passport);
    }
    @Override
    @Transactional
    public PassportDTO updatePassport(Long id, PassportDTO passport) {
        Passport passportEntity = passportRepository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE));
        Passport newPassport = passportMapper.mergeToEntity(passport, passportEntity);
        return passportMapper.toDto(passportRepository.save(newPassport));
    }
    @Override
    @Transactional
    public void deletePassport(Long id) {
        passportRepository.deleteById(id);
    }
}
