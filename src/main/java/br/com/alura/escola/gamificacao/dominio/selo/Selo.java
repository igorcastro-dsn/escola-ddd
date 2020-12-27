package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;

/**
 * @author igorcastro.dsn
 */
public class Selo {

	private CPF cpfDoAluno;
	private String nome;

	public Selo(CPF cpfDoAluno, String nome) {
		this.cpfDoAluno = cpfDoAluno;
		this.nome = nome;
	}

	public final CPF getCpfDoAluno() {
		return cpfDoAluno;
	}

	public final String getNome() {
		return nome;
	}
	
}
