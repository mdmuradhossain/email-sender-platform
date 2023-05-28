package io.murad.email_sender_platform.controller;

import io.murad.email_sender_platform.model.EmailModel;
import io.murad.email_sender_platform.service.EmailSenderService;
import io.murad.email_sender_platform.utils.ReadFromFile;
import io.murad.email_sender_platform.utils.UploadEmailFile;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class SendEmailController {

    private UploadEmailFile uploadEmailFile;
    private EmailSenderService emailSenderService;
    private ReadFromFile readFromFile;

    public SendEmailController(UploadEmailFile uploadEmailFile, EmailSenderService emailService, ReadFromFile readFromFile) {
        this.uploadEmailFile = uploadEmailFile;
        this.emailSenderService = emailService;
        this.readFromFile = readFromFile;
    }

    @GetMapping("/sendEmail")
    public String sendEmailPage(Model model){
        model.addAttribute("email",new EmailModel());
        return "sendEmailPage";
    }

    @PostMapping("/send")
    public String sendEMail(@ModelAttribute("email") EmailModel email, @RequestParam("file") MultipartFile file, Model model)
            throws IOException, MessagingException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String subject = email.getSubject();
        String body = email.getBody();
        String emailsFilePath = uploadEmailFile.uploadFile(file);
        String[] emails = readFromFile.readEmailsFromCSV(emailsFilePath);
        emailSenderService.sendEmail(emails,subject,body);
        model.addAttribute("subject",email.getSubject());
        return "success";
    }
}
