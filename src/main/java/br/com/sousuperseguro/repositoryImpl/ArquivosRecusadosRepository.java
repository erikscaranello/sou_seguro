package br.com.sousuperseguro.repositoryImpl;

import java.math.BigInteger;
import java.util.List;

import br.com.sousuperseguro.entities.recusadas.RecebidoSouSuperSeguroRecusada;

public interface ArquivosRecusadosRepository {

	List<RecebidoSouSuperSeguroRecusada> obterArquivosRecusadosLimitCinco();

	RecebidoSouSuperSeguroRecusada obterArquivoRecusado(BigInteger numeroDados);
	
}
