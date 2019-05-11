package com.terra.sendemail.service;

import org.springframework.mail.SimpleMailMessage;

import com.terra.sendemail.model.Email;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationEmail(Email obj);

}
