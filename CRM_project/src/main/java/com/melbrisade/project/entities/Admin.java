package com.melbrisade.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Long admin_id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "passWord", nullable = false)
    private String passWord;
    
    @Column(name = "avatar", nullable = true)
    private byte avatar;

    @Column(name = "phoneNumCountryCode", nullable = true)
    private int phoneNumCountryCode;

    @Column(name = "phoneNum", nullable = false, unique = true)
    private int phoneNum;

    @Column(name = "trustedPhone", nullable = false)
    private int trustedPhone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "languages", nullable = true)
    private String languages;

    @Column(name = "signature", nullable = true)
    private byte signature;

    public Admin() {
    }

    public Admin(String firstName, String lastName, String passWord, byte avatar,int phoneNumCountryCode,
                 int phoneNum, int trustedPhone,String email, String languages, byte signature){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.avatar = avatar;
        this.phoneNumCountryCode = phoneNumCountryCode;
        this.phoneNum = phoneNum;
        this.trustedPhone = trustedPhone;
        this.email = email;
        this.languages = languages;
        this.signature = signature;
    }

    public Long getId() {
        return admin_id;
    }

    public void setId(Long id) {
        this.admin_id = admin_id;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String passWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public byte avatar() {
        return avatar;
    }

    public void setAvatar(byte avatar) {
        this.avatar = avatar;
    }

    public int phoneNumCountryCode() {
        return phoneNumCountryCode;
    }

    public void setphoneNumCountryCode(int phoneNumCountryCode) {
        this.phoneNumCountryCode = phoneNumCountryCode;
    }

    public int phoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int trustedPhone() {
        return trustedPhone;
    }

    public void setTrustedPhone(int trustedPhone) {
        this.trustedPhone = trustedPhone;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String languages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public byte signature() {
        return signature;
    }

    public void setSignature(byte signature) {
        this.signature = signature;
    }
}