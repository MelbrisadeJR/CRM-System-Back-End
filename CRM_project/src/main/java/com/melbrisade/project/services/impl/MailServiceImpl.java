package com.melbrisade.project.services.impl;

import com.melbrisade.project.entities.EmailVerifier;
import com.melbrisade.project.exceptions.ServiceAccessException;
import com.melbrisade.project.repositories.EmailRepository;
import com.melbrisade.project.repositories.UserRepository;
import com.melbrisade.project.services.MailService;
import com.melbrisade.project.services.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9]+([-_\\\\.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_\\\\.][a-zA-Z0-9]+)*\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Configuration configuration;

    @Value("${mail.from}")
    private String from;

    @Async("taskExecutor")
    @Override
    public void sendVerificationEmail(Long userId) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = null;

            EmailVerifier emailVerifier = getEmailVerifierByUserId(userId);
            String email = emailVerifier.getEmail();
            String token = emailVerifier.getToken();

            messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(email);
            messageHelper.setSubject("Verification Code from Melbrisade CRM");

            Map<String, Object> params = new HashMap<>();
            params.put("verificationCode", token);

            Template template = configuration.getTemplate("verificationCode.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);

            messageHelper.setText(html, true);//parse html; if false displays source html
            mailSender.send(mimeMessage);

        } catch(IOException | TemplateException | MessagingException e) {
            log.error("{ }", e);
            throw new ServiceAccessException(-1, "Something is wrong when sending email");
        }
    }
    @Override
    public void addEmailVerifier(Long userId, String email, String token) {
        EmailVerifier em = new EmailVerifier();
        em.setUserId(userId);
        em.setEmail(email);
        em.setToken(token);
        emailRepository.save(em);
    }
    @Override
    public EmailVerifier getEmailVerifierByUserId(Long userId) {
        return emailRepository.getEmailVerifierByUserId(userId);
    }
    @Override
    public EmailVerifier getEmailVerifierByToken(String token) {
        EmailVerifier emailVerifier = emailRepository.getEmailVerifierByToken(token);
        return emailVerifier;
    }
    @Override
    public void setUserEmailVerified(Long userId) {
        Boolean isVerified = true;
        userRepository.updateEmailVerified(isVerified, userId);
    }
}
