package com.ratanit.emailapi.service;

import com.ratanit.emailapi.model.EmailRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public EmailRequest sendEmail(EmailRequest emailRequest) {
        System.out.println("EmailService::emailRequest ->"+emailRequest);
    return emailRequest;
    }
}
