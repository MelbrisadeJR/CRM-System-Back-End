package com.melbrisade.project.services.impl;

import com.melbrisade.project.exceptions.ServiceAccessException;
import com.melbrisade.project.services.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private Configuration configuration;

    @Value("${mail.from}")
    private String from;

    @Override
    public void sendVerificationCode(String to) {

        //check email Validation to be sent to
        boolean b = checkEmail(to);
        if (!b) {
            throw new ServiceAccessException(-1, "Email is not valid");
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setFrom(from);
        mailMessage.setText(generateSixNumber());
        mailSender.send(mailMessage);

    }

    @Override
    public void sendHtmlVerificationCode(String to) {

        //check email Validation to be sent to
        boolean b = checkEmail(to);
        if (!b) {
            throw new ServiceAccessException(-1, "Email is not valid");
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject("Verification Code from Melbrisade CRM"); //Set Email subject

            Map<String, Object> params = new HashMap<>();
            params.put("verificationCode", generateSixNumber());

            Template template = configuration.getTemplate("verificationCode.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);

            messageHelper.setText(html, true);//parse html; if false displays source html
            mailSender.send(mimeMessage);
        } catch (IOException | TemplateException | MessagingException e) {
            log.error("{ }", e);
            throw new ServiceAccessException(-1, "Something is wrong when sending email");
        }

    }

    private boolean checkEmail(String targetEmail) {
        return EMAIL_PATTERN.matcher(targetEmail).matches();
    }

    private String generateSixNumber() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
