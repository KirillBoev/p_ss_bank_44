package com.bank.profile.controller;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.service.actualRegistrationService.ActualRegistrationService;
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
@RequestMapping("/actualRegistration")
@AllArgsConstructor
public class ActualRegistrationController {
    private final ActualRegistrationService actualRegistrationService;
    @Operation(summary = "Get Actual Registration list", tags = "ActualRegistration")
    @ApiResponse(
            responseCode = "200",
            description = "Found Actual Registration list",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ActualRegistrationDTO.class)))
            })
    @GetMapping("/all")
    public ResponseEntity<List<ActualRegistration>> getAllActualRegistrations() {
        return ResponseEntity.ok(actualRegistrationService.getAllActualRegistrations());
    }

    @Operation(summary = "create Actual Registration", tags = "ActualRegistration")
    @ApiResponse(
            responseCode = "200",
            description = "create Actual Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ActualRegistrationDTO.class)))
            })
    @PostMapping("/create")
    public ResponseEntity<ActualRegistrationDTO> createActualRegistration(@RequestBody ActualRegistrationDTO actualRegistrationDTO) {
        return ResponseEntity.ok(actualRegistrationService.createActualRegistration(actualRegistrationDTO));
    }
    @Operation(summary = "update Actual Registration by id", tags = "ActualRegistration")
    @ApiResponse(
            responseCode = "200",
            description = "update Actual Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ActualRegistrationDTO.class)))
            })
    @PutMapping("/update/{id}")
    public ResponseEntity<ActualRegistrationDTO> updateActualRegistration(@PathVariable Long id, @RequestBody ActualRegistrationDTO actualRegistrationDTO) {
        return ResponseEntity.ok(actualRegistrationService.updateActualRegistration(id, actualRegistrationDTO));
    }
    @Operation(summary = "delete Actual Registration by id", tags = "ActualRegistration")
    @ApiResponse(
            responseCode = "200",
            description = "delete Actual Registration",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ActualRegistrationDTO.class)))
            })
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteActualRegistration(@PathVariable Long id) {
        actualRegistrationService.deleteActualRegistration(id);
        return HttpStatus.OK;
    }
}
