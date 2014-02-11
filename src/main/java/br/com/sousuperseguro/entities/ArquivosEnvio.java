package br.com.sousuperseguro.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivos_envio")
public class ArquivosEnvio implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	
	private Calendar dataArquivo;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Calendar getDataArquivo() {
		return dataArquivo;
	}

	public void setDataArquivo(Calendar dataArquivo) {
		this.dataArquivo = dataArquivo;
	}
	
	
}
