package com.example.service;

import com.example.model.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {
    Email email = new Email() ;

    @Override
    public void update(Email email1) {
     email.setLanguages(email1.getLanguages());
     email.setSize(email1.getSize());
     email.setSpam(email1.isSpam());
     email.setSignature(email1.getSignature());
    }
}
