package com.bank.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actual_registration")
public class ActualRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;
    @Column(name = "region", nullable = true)
    private String region;
    @Column(name = "city", nullable = true)
    private String city;
    @Column(name = "district", nullable = true)
    private String district;

    @Column(name = "locality", nullable = true)
    private String locality;
    @Column(name = "street", nullable = true)
    private String street;
    @Column(name = "house_number", nullable = true)
    private String houseNumber;

    @Column(name = "house_block", nullable = true)
    private String houseBlock;
    @Column(name = "flat_number", nullable = true)
    private String flatNumber;
    @Column(name = "index")
    private Long index;
}


