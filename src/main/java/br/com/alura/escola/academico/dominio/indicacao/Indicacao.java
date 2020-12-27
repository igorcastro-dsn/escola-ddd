package br.com.alura.escola.academico.dominio.indicacao;

import java.time.LocalDateTime;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

public class Indicacao {

	private Aluno indicante;
	private Aluno indicado;
	private LocalDateTime data;

	public Indicacao(Aluno indicante, Aluno indicado) {
		this.data = LocalDateTime.now();
		this.indicante = indicante;
		this.indicado = indicado;
	}

	public Aluno getIndicante() {
		return indicante;
	}

	public Aluno getIndicado() {
		return indicado;
	}

	public LocalDateTime getData() {
		return data;
	}

}
