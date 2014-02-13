package br.com.sousuperseguro.utilImpl;

import java.math.BigDecimal;
import java.util.Date;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Banco;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

import br.com.sousuperseguro.entities.RecebidoSouSuperSeguro;
import br.com.sousuperseguro.util.BoletoBancario;

public class BoletoBancarioImpl implements BoletoBancario {

	@Override
	public BoletoViewer gerarBoleto(RecebidoSouSuperSeguro dadosDoCliente) {
		
		
		//?????
		Cedente cedente = new Cedente("PROJETO JRimum", "00.000.208/0001-00");
		Sacado sacado = new Sacado(dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getNmTitCorrente(), "222.222.222-22");
		
		
		Endereco enderecoSac = new Endereco();
		enderecoSac.setUF(unidadeFederativa(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getUfCobr()));
		enderecoSac.setLocalidade(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getCidadeCobr());
		
		enderecoSac.setCep(new CEP(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getCepCobr()));
		enderecoSac.setBairro(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getBairroCobr());
		enderecoSac.setLogradouro(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getrLogradCobr());
		
		enderecoSac.setNumero(dadosDoCliente.getRecebidoSouSuperSeguroCobranca().getrNumeroCobr());
		sacado.addEndereco(enderecoSac);

		ContaBancaria contaBancaria = new ContaBancaria(banco(dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getNroBanco().getBanco()));
		
		contaBancaria.setAgencia(
			new Agencia(Integer.parseInt(dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getNroAgencia()), dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getDvAgencia())
		);
		contaBancaria.setNumeroDaConta(
				new NumeroDaConta(Integer.parseInt(dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getcCorrente()), dadosDoCliente.getRecebidoSouSuperSeguroPagamentoMensalidade().getDvConta())
		);
		
		///???
		contaBancaria.setCarteira(new Carteira(30));
		
		
		Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
		
		//???
		titulo.setNumeroDoDocumento("123456");
		
		//???
		titulo.setNossoNumero("99345678912");
		
		//???
		titulo.setDigitoDoNossoNumero("5");
		
		//???
		titulo.setValor(BigDecimal.valueOf(0.23));
		titulo.setDataDoDocumento(new Date());
		
		//date + 3
		titulo.setDataDoVencimento(new Date());
		
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(Aceite.A);
		
		//???
		titulo.setDesconto(new BigDecimal(0.05));
		titulo.setDeducao(BigDecimal.ZERO);
		titulo.setMora(BigDecimal.ZERO);
		titulo.setAcrecimo(BigDecimal.ZERO);
		titulo.setValorCobrado(BigDecimal.ZERO);
		
		
		
		Boleto boleto = new Boleto(titulo);
        
		boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em " +
		                "qualquer Banco até o Vencimento.");
		boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor " +
		                "cobrado não é o esperado, aproveite o DESCONTÃO!");
		boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
		boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
		boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
		boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
		boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
		boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
		boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
		boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");
		
		BoletoViewer boletoViewer = new BoletoViewer(boleto);

		return boletoViewer;
		
	}
	
	
	
	
	private UnidadeFederativa unidadeFederativa(String uf) {
		UnidadeFederativa retornoUnidadeFederativa;
		switch (uf) {
		case "AC":
			retornoUnidadeFederativa = UnidadeFederativa.AC;
			break;
		case "AL":
			retornoUnidadeFederativa = UnidadeFederativa.AL;
			break;
		case "AP":
			retornoUnidadeFederativa = UnidadeFederativa.AP;
			break;	
		case "AM":
			retornoUnidadeFederativa = UnidadeFederativa.AM;
			break;
		case "BA":
			retornoUnidadeFederativa = UnidadeFederativa.BA;
			break;
		case "CE":
			retornoUnidadeFederativa = UnidadeFederativa.CE;
			break;	
		case "DF":
			retornoUnidadeFederativa = UnidadeFederativa.DF;
			break;
		case "ES":
			retornoUnidadeFederativa = UnidadeFederativa.ES;
			break;
		case "GO":
			retornoUnidadeFederativa = UnidadeFederativa.GO;
			break;
		case "MA":
			retornoUnidadeFederativa = UnidadeFederativa.MA;
			break;
		case "MT":
			retornoUnidadeFederativa = UnidadeFederativa.MT;
			break;	
		case "MS":
			retornoUnidadeFederativa = UnidadeFederativa.MS;
			break;	
		case "MG":
			retornoUnidadeFederativa = UnidadeFederativa.MG;
			break;
		case "PR":
			retornoUnidadeFederativa = UnidadeFederativa.PR;
			break;
		case "PB":
			retornoUnidadeFederativa = UnidadeFederativa.PB;
			break;
		case "PA":
			retornoUnidadeFederativa = UnidadeFederativa.PA;
			break;
		case "PE":
			retornoUnidadeFederativa = UnidadeFederativa.PE;
			break;
		case "PI":
			retornoUnidadeFederativa = UnidadeFederativa.PI;
			break;	
		case "RJ":
			retornoUnidadeFederativa = UnidadeFederativa.RJ;
			break;
		case "RN":
			retornoUnidadeFederativa = UnidadeFederativa.RN;
			break;
		case "RS":
			retornoUnidadeFederativa = UnidadeFederativa.RS;
			break;
		case "RO":
			retornoUnidadeFederativa = UnidadeFederativa.RO;
			break;
		case "RR":
			retornoUnidadeFederativa = UnidadeFederativa.RR;
			break;
		case "SC":
			retornoUnidadeFederativa = UnidadeFederativa.SC;
			break;
		case "SE":
			retornoUnidadeFederativa = UnidadeFederativa.SE;
			break;
		case "SP":
			retornoUnidadeFederativa = UnidadeFederativa.SP;
			break;
		case "TO":
			retornoUnidadeFederativa = UnidadeFederativa.TO;
			break;	
		default:
			retornoUnidadeFederativa = null;
			break;
		}
		return retornoUnidadeFederativa;
	}
	
	
	private Banco banco(Integer numeroBanco) {
		Banco retornoDeBanco;
		switch (numeroBanco) {
		case 237:
			retornoDeBanco = BancosSuportados.BANCO_BRADESCO.create();
			break;
		case 341:
			retornoDeBanco = BancosSuportados.BANCO_ITAU.create();
			break;	
		case 001:
			retornoDeBanco = BancosSuportados.BANCO_DO_BRASIL.create();
			break;	
		default:
			retornoDeBanco = null;
			break;
		}
		return retornoDeBanco;
	}

}
