package com.melbrisade.project.services;

public interface MailService {
    void sendVerificationCode(String to);

    void sendHtmlVerificationCode(String to);
}
