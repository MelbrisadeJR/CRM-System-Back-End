package com.melbrisade.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private String gender;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Column(name = "tag")
    private int tag;

    @Column(name = "deleted")
    private boolean deleted;

    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    private Date createAt;

    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
        this.deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = new Date();
    }


}
