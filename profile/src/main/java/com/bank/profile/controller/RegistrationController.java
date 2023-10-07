package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDTO;
import com.bank.profile.entity.Registration;
import com.bank.profile.service.registrationService.RegistrationService;
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
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @Operation(summary = "Get Registration list", tags = "Registration")
    @ApiResponse(
            responseCode = "200",
            description = "Found Registration list",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RegistrationDTO.class)))
            })
    @GetMapping("/all")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @Operation(summary = "create Registration", tags = "Registration")
    @ApiResponse(
            responseCode = "200",
            description = "create Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RegistrationDTO.class)))
            })
    @PostMapping("/create")
    public ResponseEntity<RegistrationDTO> createRegistration(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.ok(registrationService.createRegistration(registrationDTO));
    }
    @Operation(summary = "update Registration by id", tags = "Registration")
    @ApiResponse(
            responseCode = "200",
            description = "update Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RegistrationDTO.class)))
            })
    @PutMapping("/update/{id}")
    public ResponseEntity<RegistrationDTO> updateRegistration(@PathVariable Long id, @RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.ok(registrationService.updateRegistration(id, registrationDTO));
    }
    @Operation(summary = "delete Registration by id", tags = "Registration")
    @ApiResponse(
            responseCode = "200",
            description = "delete Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RegistrationDTO.class)))
            })
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return HttpStatus.OK;
    }
}
