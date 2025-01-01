package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mail) {
        this.mailSender = mail;
    }

    public void sendWelcomeEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to RemotePay");
        message.setText("Hello " + userName + ",\n\nThank you for signing up with us!\nWe're excited to have you on board.\n Founder \n Viddolee");
        mailSender.send(message);
    }

    public void sendOtp(String toEmail) {
        Random random = new Random();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("OTP");
        message.setText("Your OTP is " + random.nextInt(98765432));
        mailSender.send(message);
    }


}
