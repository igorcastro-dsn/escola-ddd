package br.com.alura.escola.aplicacao.aluno.matricula;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoBuilder;

/**
 * Classe com dados mais primitivos e sem lógicas de negócio, usada para trafegar esses dados.
 * @author igorcastro.dsn
 */
public class AlunoDto {

	private String nome;
	private String cpf;
	private String email;
	
	public AlunoDto(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public final String getNome() {
		return nome;
	}

	public final String getCpf() {
		return cpf;
	}

	public final String getEmail() {
		return email;
	}
	
	public Aluno build() {
		return new AlunoBuilder().comNomeCPFEmail(this.nome, this.cpf, this.email)
								 .build();
	}
	
}
