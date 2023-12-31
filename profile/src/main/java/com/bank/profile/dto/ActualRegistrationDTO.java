package com.bank.profile.dto;

import lombok.Data;

@Data
public class ActualRegistrationDTO {
    private Long Id;

    private String country;
    private String region;
    private String city;
    private String district;

    private String locality;
    private String street;
    private String houseNumber;

    private String houseBlock;
    private String flatNumber;
    private Long index;
}
