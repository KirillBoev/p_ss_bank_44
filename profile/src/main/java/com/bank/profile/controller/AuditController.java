package com.bank.profile.controller;

import com.bank.profile.dto.AuditDTO;
import com.bank.profile.service.auditService.AuditService;
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
@RequestMapping("/audit")
@AllArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @Operation(summary = "Get Audit by id", tags = "Audit")
    @ApiResponse(
            responseCode = "200",
            description = "Found Audit",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AuditDTO.class)))
            })
    @GetMapping("/{id}")
    public AuditDTO findById(@PathVariable("id") Long id) {
        return auditService.findById(id);
    }
}
