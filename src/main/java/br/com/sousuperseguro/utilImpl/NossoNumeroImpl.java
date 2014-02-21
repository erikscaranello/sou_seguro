package br.com.sousuperseguro.utilImpl;

import org.springframework.stereotype.Component;

import br.com.sousuperseguro.util.NossoNumero;

@Component
public class NossoNumeroImpl implements NossoNumero {

	@Override
	public String gerarNossoNumero(String string) {
		
		
		return "00000000154";
	}

}
