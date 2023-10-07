package com.bank.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "name_on_card", nullable = true)
    private String nameOnCard;

    @Column(name = "inn", unique = true, nullable = true)
    private Long inn;

    @Column(name = "snils", unique = true, nullable = true)
    private Long snils;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actual_registration_id")
    private ActualRegistration actualRegistrationId;
}
