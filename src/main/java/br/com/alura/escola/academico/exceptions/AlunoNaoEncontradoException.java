package br.com.alura.escola.academico.exceptions;

import br.com.alura.escola.shared.dominio.CPF;

public class AlunoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontradoException(CPF cpf) {
		super(String.format("Aluno n�o encontrado com o CPF %s", cpf.getNumero()));
	}

}
