package com.terra.sendemail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.terra.sendemail.service.EmailService;
import com.terra.sendemail.service.SmtpEmailService;

@Configuration
public class DevConfig {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
