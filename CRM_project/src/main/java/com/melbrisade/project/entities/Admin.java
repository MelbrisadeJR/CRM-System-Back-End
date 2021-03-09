package com.melbrisade.project.entities;

@Entity
@Table(name = "admin"）
public class Admin {

    @Id
    @GeneratedValue
    private Long admin_id;

    @Column(name = firstName, nullable = false)
    private String firstName;

    @Column(name = lastName, nullable = false)
    private String lastName;

    @Column(name = passWord, nullable = false)
    private String passWord;
    
    @Column(name = avatar, nullable = true)
    private byte avatar;

    @Column(name = avatar, nullable = true)
    private byte avatar;

    @Column(name = phoneNumCountryCode, nullable = true)
    private Int phoneNumCountryCod;

    @Column(name = phoneNum, nullable = false, unique = true)
    private Int phoneNum;

    @Column(name = trustedPhone, nullable = false)
    private Int trustedPhone;

    @Column(name = email, nullable = false, unique = true)
    private String email;

    @Column(name = languages, nullable = true)
    private String languages;

    @Column(name = signature, nullable = true)
    private byte signature;

    public Admin() {
    } 

    public Admin（String firstName, String lastName, String passWord, byte avatar，
    Int phoneNumCountryCode，Int phoneNum, Int trustedPhone, String email,
    String languages, byte signature）{
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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAvatar(Byte avatar) {
        this.avatar = avatar;
    }

    public Int phoneNumCountryCode() {
        return phoneNumCountryCode;
    }

    public void setphoneNumCountryCode(Int phoneNumCountryCode) {
        this.phoneNumCountryCode = phoneNumCountryCode;
    }

    public Int phoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Int trustedPhone() {
        return trustedPhone;
    }

    public void setTrustedPhone(Int trustedPhone) {
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

    public Byte signature() {
        return signature;
    }

    public vodi setSignature(Byte signature) {
        this.signature = signature;
    }
}