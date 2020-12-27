package br.com.alura.escola.exceptions;

public class NumeroMaximoDeTelefonesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NumeroMaximoDeTelefonesException() {
		super("Número máximo de telefones por aluno já foi atingido");
	}

}
