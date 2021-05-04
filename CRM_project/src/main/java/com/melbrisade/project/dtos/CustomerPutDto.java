package com.melbrisade.project.dtos;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerPutDto {
    private String firstName;

    private String lastName;

    private String password;

    private String mobile;

    private String gender;

    private String email;

    private String addressLine1;

    private String addressLine2;

    private int zip;

    private String city;

    private String country;

    private Date dateOfBirth;

    private int tag;

    private Date updateAt;

    private boolean deleted;
}
