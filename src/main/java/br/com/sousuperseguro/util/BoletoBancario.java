package br.com.sousuperseguro.util;

import org.jrimum.bopepo.view.BoletoViewer;

import br.com.sousuperseguro.entities.RecebidoSouSuperSeguro;

public interface BoletoBancario {

	BoletoViewer gerarBoleto(RecebidoSouSuperSeguro dadosDoCliente);	
	
}
