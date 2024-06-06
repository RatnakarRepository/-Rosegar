package com.ratanit.emailapi.controller;

import com.ratanit.emailapi.model.EmailRequest;
import com.ratanit.emailapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public EmailRequest sendEmail(@RequestBody EmailRequest emailRequest){
        System.out.println("EmailController::emailRequest ->"+emailRequest);
        EmailRequest result = emailService.sendEmail(emailRequest);
        //result.setTo("Akshara2");
        System.out.println("EmailController::Name ->"+result.getName());
        if(result!=null){
            System.out.println("Sucess...");
            //return ResponseEntity.ok("Sucess....");
            return result;
        }else{
            System.out.println("values not got...");
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Values not got...");
            return result;
        }


    }
}
