package teste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sousuperseguro.utilImpl.MontagemDeArquivoImpl;

@Controller
public class FazerArquivo {
		
	@RequestMapping("/fazer_teste")
	public void fazerTeste() {
		
		MontagemDeArquivoImpl repository = new MontagemDeArquivoImpl(); 
		
		repository.montagemCTipoRegistro();
		
	}
}
