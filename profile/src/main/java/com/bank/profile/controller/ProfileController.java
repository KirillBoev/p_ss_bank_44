package com.bank.profile.controller;

import com.bank.profile.dto.ProfileDTO;
import com.bank.profile.entity.Profile;
import com.bank.profile.service.profileService.ProfileService;
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
@RequestMapping
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @Operation(summary = "Get Profile list", tags = "Profile")
    @ApiResponse(
            responseCode = "200",
            description = "Found Profile list",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class)))
            })
    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @Operation(summary = "create Profile", tags = "Profile")
    @ApiResponse(
            responseCode = "200",
            description = "create Profile",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class)))
            })
    @PostMapping("/create")
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.createProfile(profileDTO));
    }
    @Operation(summary = "update Profile by id", tags = "Profile")
    @ApiResponse(
            responseCode = "200",
            description = "update Profile",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class)))
            })
    @PutMapping("/update/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.updateProfile(id, profileDTO));
    }
    @Operation(summary = "delete Profile by id", tags = "Profile")
    @ApiResponse(
            responseCode = "200",
            description = "delete Profile",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProfileDTO.class)))
            })
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return HttpStatus.OK;
    }
}
