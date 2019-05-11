package com.terra.sendemail.service;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import com.terra.sendemail.model.Email;

public abstract class AbstractEmailService implements EmailService {

	@Override
	@Async("asyncExecutor")
	public void sendOrderConfirmationEmail(Email obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Email email) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("ateliebrig@gmail.com");
		sm.setFrom("ateliebrig@gmail.com");
		sm.setSubject(email.getAssunto());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(email.getMensagem());
		return sm;
	}

}
