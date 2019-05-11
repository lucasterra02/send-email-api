package com.terra.sendemail.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terra.sendemail.model.Email;
import com.terra.sendemail.service.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailResource {

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> send(@Valid @RequestBody Email email) {

		emailService.sendOrderConfirmationEmail(email);

		return ResponseEntity.noContent().build();
	}

}
