package com.melbrisade.project.controllers;

import com.melbrisade.project.payload.ApiResponse;
import com.melbrisade.project.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public ApiResponse sendVerificationCode(@RequestParam(value = "to", required = true) String to) {
        //plain text
        //mailService.sendVerificationCode(to);

        //html of freemarker template
//        mailService.sendVerificationEmail(to);

        return ApiResponse.OK();
    }

    @GetMapping("/check")
    public boolean checkEmail(@RequestParam("code") String code,@RequestParam("u") String user){
        if(code.equals("12345") && user.equals("XXXXXX@qq.com")){
            return true;
        }
        return false;
    }
}
