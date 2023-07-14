package com.example.onlineshop.controller;

import com.example.onlineshop.service.MailSenderService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.onlineshop.config.SwaggerConfig.MAIL;

@Api(tags = MAIL)
@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailSenderController {
    private final MailSenderService mailSenderService;
    @PostMapping("/sendMail")
    public void sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text){
        mailSenderService.sendSimpleMessage(to, subject, text);
    }
}
