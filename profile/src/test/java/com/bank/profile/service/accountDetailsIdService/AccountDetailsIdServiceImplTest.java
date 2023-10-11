package com.bank.profile.service.accountDetailsIdService;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.mapper.AccountDetailsIdMapper;
import com.bank.profile.repository.AccountDetailsIdRepository;
import com.bank.profile.exception.EntityNotFoundReturner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

class AccountDetailsIdServiceImplTest {

    @Mock
    private AccountDetailsIdRepository accountDetailsIdRepository;

    @Mock
    private AccountDetailsIdMapper accountDetailsIdMapper;

    @Mock
    private EntityNotFoundReturner notFoundReturner;

    @InjectMocks
    private AccountDetailsIdServiceImpl accountDetailsIdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        Long id = 1L;
        AccountDetailsId accountDetailsIdEntity = new AccountDetailsId();
        AccountDetailsIdDTO accountDetailsIdDTO = new AccountDetailsIdDTO();
        when(accountDetailsIdRepository.findById(id)).thenReturn(Optional.of(accountDetailsIdEntity));
        when(accountDetailsIdMapper.toDto(accountDetailsIdEntity)).thenReturn(accountDetailsIdDTO);

        AccountDetailsIdDTO result = accountDetailsIdService.findById(id);

        assertEquals(accountDetailsIdDTO, result);
    }
}