package com.melbrisade.project.entities;

import javax.persistence.*;

    /*
     To verify user emails when register, store tokens for verification
    */

@Entity
@Table(name="email_verifier")
public class EmailVerifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private long userId;

    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
