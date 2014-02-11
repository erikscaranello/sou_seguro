package br.com.sousuperseguro.utilImpl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;

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

}
