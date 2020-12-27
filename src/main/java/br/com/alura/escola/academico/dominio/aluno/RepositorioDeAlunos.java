package br.com.alura.escola.academico.dominio.aluno;

import java.util.List;

import br.com.alura.escola.shared.dominio.CPF;

/**
 * Embora a persist�ncia seja um conceito t�cnico (de infra),
 * a persist�ncia de dados faz parte do dom�nio da aplica��o mas ele n�o 
 * pode ficar preso a detalhes de implementa��o. Com isso mantemos a camada de dom�nio
 * isolada de detalhes de outras camadas.   
 * @author igorcastro.dsn
 */
public interface RepositorioDeAlunos {

	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(CPF cpf);
	
	List<Aluno> listarTodosAlunosMatriculados();
	
}
