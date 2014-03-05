package br.com.sousuperseguro.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sousuperseguro.util.Ftp;

@Controller
public class FtpController {

	@Autowired
	Ftp ftp;
	
	
	@RequestMapping("/enviar_bradesco")
	public void enviarBradesco() {
		
		ftp.enviarArquivosFtpCliente();
		
	}
	
	
	@RequestMapping("/receber_bradesco")
	public void receberBradesco() throws IOException, IOException {
		
		ftp.receberArquivosFtpCliente();
		
	}

}
