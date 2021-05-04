package com.melbrisade.project.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

@Data
public class CustomerGetDto {
    private Long customerId;

    private String firstName;

    private String lastName;

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

    private Date createAt;
    private Date updateAt;

}
