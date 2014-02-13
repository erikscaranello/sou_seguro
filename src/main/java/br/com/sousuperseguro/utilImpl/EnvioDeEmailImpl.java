package br.com.sousuperseguro.utilImpl;

import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.jrimum.bopepo.view.BoletoViewer;
import org.springframework.stereotype.Component;

import br.com.sousuperseguro.entities.RecebidoSouSuperSeguro;
import br.com.sousuperseguro.entities.Users;
import br.com.sousuperseguro.util.EnvioDeEmail;

@Component
public class EnvioDeEmailImpl implements EnvioDeEmail {

	@Override
	public void enviarEmail(Users user) {
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("erikscaranello@gmail.com", "natale0506"));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("erikscaranello@gmail.com");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		email.setSubject("TestMail");
		
		try {
		
			email.setMsg("This is a test mail ... :-)");
		
		} catch (EmailException e) {
			e.printStackTrace();
		}
		try {
			
			email.addTo(user.getInfosPessoais().getEmail());
		
		} catch (EmailException e) {
			e.printStackTrace();
		}
		try {
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void enviarEmailComBoleto(RecebidoSouSuperSeguro cliente, BoletoViewer boleto) {
		
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("" + boleto);
//		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("boleto para " + cliente.getRecebidoSouSuperSeguroCobranca().getNmCobr());
		attachment.setName(cliente.getRecebidoSouSuperSeguroCobranca().getNmCobr());
		
		
		MultiPartEmail  email = new MultiPartEmail ();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("erikscaranello@gmail.com", "natale0506"));
		email.setSSLOnConnect(true);
		email.setSubject("Email de verificacao");
		
		try {
			email.setFrom("erikscaranello@gmail.com");
			email.setMsg("This is a test mail ... :-)");
			email.addTo(cliente.getRecebidoSouSuperSeguroCobranca().getEmail());
			
			email.attach(new ByteArrayDataSource(boleto.getPdfAsByteArray(), "application/pdf"),
				      "boleto de: " + cliente.getRecebidoSouSuperSeguroCobranca().getNmCobr() + ".pdf", 
				      "",
				       EmailAttachment.ATTACHMENT);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}		
	}
}
