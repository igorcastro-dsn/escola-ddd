package br.com.alura.escola.gamificacao.dominio.selo;

import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.CPF;

/**
 * @author igorcastro.dsn
 */
public interface RepositorioDeSelos {

	void adicionar(Selo selo);
	
	List<Selo> listar();
	
	List<Selo> listar(CPF cpf);
	
}
