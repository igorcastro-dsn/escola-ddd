package br.com.alura.escola.exceptions;

public class NumeroMaximoDeTelefonesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NumeroMaximoDeTelefonesException() {
		super("N�mero m�ximo de telefones por aluno j� foi atingido");
	}

}
