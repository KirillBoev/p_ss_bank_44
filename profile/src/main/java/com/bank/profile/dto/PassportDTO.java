package com.bank.profile.dto;

import com.bank.profile.entity.Registration;
import lombok.Data;
import java.sql.Date;

@Data
public class PassportDTO {
    private Long Id;

    private Integer series;

    private Long number;

    private String firstName;

    private String middleName;

    private String gender;

    private Date birthDate;

    private String birthPlace;

    private String issuedBy;

    private Date dateOfIssue;

    private Integer divisionCode;

    private Date expirationDate;

    private Registration registrationId;
}


