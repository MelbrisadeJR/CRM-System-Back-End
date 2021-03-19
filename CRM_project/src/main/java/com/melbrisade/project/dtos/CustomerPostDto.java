package com.melbrisade.project.dtos;

import lombok.Data;

@Data
public class CustomerPostDto {

    private String firstName;

    private String lastName;

    private String password;

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
