package com.bank.profile.service.accountDetailsIdService;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.exception.EntityNotFoundReturner;
import com.bank.profile.mapper.AccountDetailsIdMapper;
import com.bank.profile.repository.AccountDetailsIdRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {
    private final AccountDetailsIdRepository accountDetailsIdRepository;
    private final AccountDetailsIdMapper accountDetailsIdMapper;
    private final EntityNotFoundReturner notFoundReturner;
    private final static String MESSAGE = "Не найдены дополнительные данные об аккаунте с ID ";

    @Override
    public AccountDetailsIdDTO findById(Long id) {
        return accountDetailsIdMapper.toDto(accountDetailsIdRepository.findById(id).orElseThrow(() -> notFoundReturner.getEntityNotFoundException(id, MESSAGE)));
    }
}
