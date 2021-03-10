package com.melbrisade.project.services;

import com.melbrisade.project.dtos.EmailGetDto;
import com.melbrisade.project.dtos.EmailPostDto;
import com.melbrisade.project.entities.Email;
import com.melbrisade.project.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;

    public EmailGetDto createEmail(EmailPostDto emailPostDto) {
        Email emailFromDB = emailRepository.save(mapPostDtoToEntity(emailPostDto));
        return mapEntityToGetDto(emailFromDB);
    }

    private Email mapPostDtoToEntity(EmailPostDto emailPostDto) {
        Email email = new Email();
        email.setRecipient(emailPostDto.getRecipient());
        email.setSubject(emailPostDto.getSubject());
        email.setContent(emailPostDto.getContent());
        return email;
    }

    private EmailGetDto mapEntityToGetDto(Email email) {
        EmailGetDto emailGetDto = new EmailGetDto();
        emailGetDto.setId(email.getEmail_id());
        emailGetDto.setRecipient(email.getRecipient());
        emailGetDto.setSubject(email.getSubject());
        emailGetDto.setContent(email.getContent());
        return emailGetDto;
    }
    //get email list
    public List<Email> getEmailList() {
        List<Email> emails = emailRepository.findAll();
        return emails;
    }
}
