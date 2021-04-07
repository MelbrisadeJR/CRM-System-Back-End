package com.melbrisade.project.controllers;

import com.melbrisade.project.dtos.EmailGetDto;
import com.melbrisade.project.dtos.EmailPostDto;
import com.melbrisade.project.entities.Email;
import com.melbrisade.project.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
@CrossOrigin
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailGetDto> createCustomer(@RequestBody EmailPostDto emailPostDto) {
        EmailGetDto emailGetDto = emailService.createEmail(emailPostDto);
        return ResponseEntity.ok(emailGetDto);
    }

    @GetMapping //
    public List<Email> getCustomerList() {
        return emailService.getEmailList();
    }

//    @PutMapping

//    @DeleteMapping
}
