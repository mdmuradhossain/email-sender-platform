package io.murad.email_sender_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendEmailController {

    @GetMapping("/sendEmail")
    public String sendEmailPage(){
        return "sendEmailPage";
    }
}
