package com.bank.profile.controller;

import com.bank.profile.dto.AccountDetailsIdDTO;
import com.bank.profile.service.accountDetailsIdService.AccountDetailsIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/accountDetailsId")
@AllArgsConstructor
public class AccountDetailsIdController {
    private final AccountDetailsIdService accountDetailsIdService;

    @Operation(summary = "Get Account Details by id", tags = "AccountDetailsId")
    @ApiResponse(
            responseCode = "200",
            description = "Found Account Details",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AccountDetailsIdDTO.class)))
            })
    @GetMapping("/{id}")
    public AccountDetailsIdDTO findById(@PathVariable("id") Long id) {
        return accountDetailsIdService.findById(id);
    }
}
