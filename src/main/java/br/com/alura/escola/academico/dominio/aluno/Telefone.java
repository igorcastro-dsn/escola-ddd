package br.com.alura.escola.academico.dominio.aluno;

import com.google.common.base.Preconditions;

public class Telefone {

	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		setDDD(ddd);
		setNumero(numero);
	}

	private void setDDD(String ddd) {
		Preconditions.checkArgument(ddd != null, "DDD não pode ser nulo");
		Preconditions.checkArgument(ddd.length() == 2, "DDD tem que ter 2 dígitos");
		this.ddd = ddd;
	}

	private void setNumero(String numero) {
		Preconditions.checkArgument(numero != null, "Número não pode ser nulo");
		Preconditions.checkArgument(numero.length() == 8 || numero.length() == 9, "Número tem que ter 8 ou 9 dígitos");
		this.numero = numero;
	}

	public String getDDD() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
