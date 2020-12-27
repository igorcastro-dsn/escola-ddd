package br.com.alura.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.alura.escola.dominio.Evento;

public class AlunoMatriculado implements Evento {

	private final CPF cpfDoALuno;
	private final LocalDateTime momento;

	public AlunoMatriculado(CPF cpfDoALuno) {
		this.cpfDoALuno = cpfDoALuno;
		this.momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

	public final CPF getCpfDoALuno() {
		return cpfDoALuno;
	}

}
