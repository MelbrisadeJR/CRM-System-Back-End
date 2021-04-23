package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "gender")
    private int gender;

    @Column(name = "email")
    private String email;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "zip")
    private int zip;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "tag")
    private int tag;

}
