package com.bank.profile.mapper;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.entity.AccountDetailsId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountDetailsIdMapperTest {

    private AccountDetailsIdMapper accountDetailsIdMapper;

    @BeforeEach
    public void setUp() {
        accountDetailsIdMapper = Mappers.getMapper(AccountDetailsIdMapper.class);
    }

    @Test
    public void testToEntity() {
        AccountDetailsIdDTO accountDetailsIdDTO = new AccountDetailsIdDTO();
        accountDetailsIdDTO.setAccountId(123L);

        AccountDetailsId accountDetailsId = accountDetailsIdMapper.toEntity(accountDetailsIdDTO);

        assertNull(accountDetailsId.getId());
        assertEquals(123L, accountDetailsId.getAccountId());
    }

    @Test
    public void testToDto() {
        AccountDetailsId accountDetailsId = new AccountDetailsId();
        accountDetailsId.setAccountId(456L);

        AccountDetailsIdDTO accountDetailsIdDTO = accountDetailsIdMapper.toDto(accountDetailsId);

        assertEquals(456L, accountDetailsIdDTO.getAccountId());
    }

    @Test
    public void testMergeToEntity() {
        AccountDetailsIdDTO updatedAccountDetailsIdDTO = new AccountDetailsIdDTO();
        updatedAccountDetailsIdDTO.setAccountId(789L);

        AccountDetailsId existingAccountDetailsId = new AccountDetailsId();
        existingAccountDetailsId.setId(1L);
        existingAccountDetailsId.setAccountId(111L);

        AccountDetailsId mergedAccountDetailsId = accountDetailsIdMapper.mergeToEntity(updatedAccountDetailsIdDTO, existingAccountDetailsId);

        assertEquals(1L, mergedAccountDetailsId.getId());
        assertEquals(789L, mergedAccountDetailsId.getAccountId());
    }
}