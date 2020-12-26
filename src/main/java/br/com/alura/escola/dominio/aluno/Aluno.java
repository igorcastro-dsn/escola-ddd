package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.infra.aluno.CifradorDeSenhaComMD5;

/**
 * Como é uma classe que tem um atributo (cpf) que pode ser usado para
 * diferenciar um objeto do outro, esse tipo de classe é considerada como
 * Entidade.
 * 
 * @author igorcastro.dsn
 *
 */
public class Aluno {

	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new ArrayList<>();
	private String senha;

	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}

	public String getCpf() {
		return cpf.getNumero();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public void setSenha(String senha) {
		CifradorDeSenha cifrador = new CifradorDeSenhaComMD5();
		this.senha = cifrador.cifrar(senha);
	}

	public final String getSenha() {
		return senha;
	}
	
}
