package com.project.uber.uberApp.services;

import java.util.List;

public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body);
    void sendEmail(List<String> toEmail, String subject, String body);
}
