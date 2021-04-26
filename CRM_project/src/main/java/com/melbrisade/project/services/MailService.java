package com.melbrisade.project.services;

import com.melbrisade.project.entities.EmailVerifier;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

//    void sendVerificationCode(String to);

//    void sendHtmlVerificationCode(String to);

    void sendVerificationEmail(Long userId);

    EmailVerifier getEmailVerifierByUserId(Long userId);

    void addEmailVerifier(Long userId, String email, String token);

    EmailVerifier getEmailVerifierByToken(String token);

    void setUserEmailVerified(Long userId);
}
