package br.com.alura.escola.aplicacao.aluno.matricula;

import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

/**
 * Use case - Serviço que pertence à camada de aplicação
 * @author igorcastro.dsn
 */
public class MatriculaDeAluno {

	private final RepositorioDeAlunos repositorio;
	
	public MatriculaDeAluno(RepositorioDeAlunos repositorio) {
		this.repositorio = repositorio;
	}
	
	public void matricular(AlunoDto dto) {
		Aluno aluno = dto.build();
		repositorio.matricular(aluno);
	}

	public List<Aluno> listarMatriculados() {
		return repositorio.listarTodosAlunosMatriculados();
	}
	
}
