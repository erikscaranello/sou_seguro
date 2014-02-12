package teste;

import java.math.BigInteger;

import org.junit.Test;

import br.com.sousuperseguro.serviceImpl.PropostServiceImpl;


public class FazerArquivo {
	
	@Test
	public void fazerTeste() {
		
		PropostServiceImpl proposta = new PropostServiceImpl();
		proposta.calcularProposta(new BigInteger("40"));
		
	}
}
