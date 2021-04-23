package com.melbrisade.project.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerGetDto {
    private Long customerId;

    private String firstName;

    private String lastName;

    private String mobile;

    private int gender;

    private String email;

    private String addressLine1;

    private String addressLine2;

    private int zip;

    private String city;

    private String country;

    private String dateOfBirth;

    private int tag;
}
