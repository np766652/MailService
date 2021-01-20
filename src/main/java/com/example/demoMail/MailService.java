package com.example.demoMail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailService {

    private JavaMailSender javaMailSender;





    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(User user) throws MailException {



        SimpleMailMessage mail = new SimpleMailMessage();
//        String string=user.getEmailAddress();
//        int index = string.indexOf('*');
//        String email = string.substring(0,index);
//        String orderlist = string.substring(index+1);
//       String [] arrayOfOrder = orderlist.split(",", 10);
//       for(String a: arrayOfOrder){
//           System.out.println(a);
//       }

        mail.setTo(user.getEmailAddress());
        mail.setSubject("Laptopium");
        mail.setText("Thank you for Order");




        javaMailSender.send(mail);
    }
}
