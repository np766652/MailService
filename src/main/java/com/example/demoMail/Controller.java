package com.example.demoMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {


    @Autowired
    private MailService notificationService;

    @Autowired
    private User user;


    @KafkaListener(topics = "123",groupId = "mail")
    public void send( String mail) {

        System.out.println(mail);
        user.setEmailAddress(mail);  //Receiver's email address
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        System.out.println("Mailed");
    }
}
