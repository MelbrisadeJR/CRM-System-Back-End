package com.melbrisade.project.controllers;

import com.melbrisade.common.ApiResponse;
import com.melbrisade.project.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/verification_code")
    public ApiResponse sendVerificationCode(@RequestParam(value = "to", required = true) String to) {
        //plain text
        //mailService.sendVerificationCode(to);

        //html of freemarker template
        mailService.sendHtmlVerificationCode(to);

        return ApiResponse.OK();
    }
}
