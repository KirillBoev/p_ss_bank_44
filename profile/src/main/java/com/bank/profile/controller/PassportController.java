package com.bank.profile.controller;

import com.bank.profile.dto.PassportDTO;
import com.bank.profile.entity.Passport;
import com.bank.profile.service.passportService.PassportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/passport")
@AllArgsConstructor
public class PassportController {

    private final PassportService passportService;

    @Operation(summary = "Get Passport list", tags = "Passport")
    @ApiResponse(
            responseCode = "200",
            description = "Found Passport list",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PassportDTO.class)))
            })
    @GetMapping("/all")
    public ResponseEntity<List<Passport>> getAllPassports() {
        return ResponseEntity.ok(passportService.getAllPassports());
    }

    @Operation(summary = "create Passport", tags = "Passport")
    @ApiResponse(
            responseCode = "200",
            description = "create Passport",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PassportDTO.class)))
            })
    @PostMapping("/create")
    public ResponseEntity<PassportDTO> createPassport(@RequestBody PassportDTO passportDTO) {
        return ResponseEntity.ok(passportService.createPassport(passportDTO));
    }
    @Operation(summary = "update Passport by id", tags = "Passport")
    @ApiResponse(
            responseCode = "200",
            description = "update Passport",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PassportDTO.class)))
            })
    @PutMapping("/update/{id}")
    public ResponseEntity<PassportDTO> updatePassport(@PathVariable Long id, @RequestBody PassportDTO passportDTO) {
        return ResponseEntity.ok(passportService.updatePassport(id, passportDTO));
    }
    @Operation(summary = "delete Passport by id", tags = "Passport")
    @ApiResponse(
            responseCode = "200",
            description = "delete Passport",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PassportDTO.class)))
            })
    @DeleteMapping("/delete/{id}")
    public HttpStatus deletePassport(@PathVariable Long id) {
        passportService.deletePassport(id);
        return HttpStatus.OK;
    }
}
