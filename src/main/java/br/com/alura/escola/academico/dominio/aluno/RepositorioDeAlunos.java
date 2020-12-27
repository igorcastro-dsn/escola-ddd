package br.com.alura.escola.academico.dominio.aluno;

import java.util.List;

import br.com.alura.escola.shared.dominio.CPF;

/**
 * Embora a persistência seja um conceito técnico (de infra),
 * a persistência de dados faz parte do domínio da aplicação mas ele não 
 * pode ficar preso a detalhes de implementação. Com isso mantemos a camada de domínio
 * isolada de detalhes de outras camadas.   
 * @author igorcastro.dsn
 */
public interface RepositorioDeAlunos {

	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(CPF cpf);
	
	List<Aluno> listarTodosAlunosMatriculados();
	
}
