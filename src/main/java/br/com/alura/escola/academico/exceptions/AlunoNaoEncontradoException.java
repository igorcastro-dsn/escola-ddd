package br.com.alura.escola.academico.exceptions;

import br.com.alura.escola.academico.dominio.aluno.CPF;

public class AlunoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontradoException(CPF cpf) {
		super(String.format("Aluno não encontrado com o CPF %s", cpf.getNumero()));
	}

}
