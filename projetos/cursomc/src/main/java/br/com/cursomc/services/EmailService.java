package br.com.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.cursomc.domain.Pedido;

//CONTRATO
public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
