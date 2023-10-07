package com.bank.profile.service.passportService;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;

import java.util.List;

public interface PassportService {

    List<Passport> getAllPassports();

    PassportDTO createPassport(PassportDTO passportDTO);

    PassportDTO updatePassport(Long id, PassportDTO passport);

    void deletePassport(Long id);
}
