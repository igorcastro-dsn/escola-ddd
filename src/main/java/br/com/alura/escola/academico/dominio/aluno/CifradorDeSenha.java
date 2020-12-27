package br.com.alura.escola.academico.dominio.aluno;

public interface CifradorDeSenha {

	String cifrar(String senha);
	
	boolean validarSenhaCifrada(String senhaCifrada, String senha);
	
}
