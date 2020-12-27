package br.com.alura.escola.aplicacao.aluno.matricula;

import java.util.List;

import br.com.alura.escola.dominio.EmissorDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

/**
 * Use case - Serviço que pertence à camada de aplicação
 * @author igorcastro.dsn
 */
public class MatriculaDeAluno {

	private final RepositorioDeAlunos repositorio;
	private final EmissorDeEventos emissorDeEventos;
	
	public MatriculaDeAluno(RepositorioDeAlunos repositorio, EmissorDeEventos emissorDeEventos) {
		this.repositorio = repositorio;
		this.emissorDeEventos = emissorDeEventos;
	}
	
	public void matricular(AlunoDto dto) {
		Aluno aluno = dto.build();
		repositorio.matricular(aluno);
		emitirEvento(aluno);
	}

	public List<Aluno> listarMatriculados() {
		return repositorio.listarTodosAlunosMatriculados();
	}
	
	private void emitirEvento(Aluno aluno) {
		AlunoMatriculado alunoMatriculado = new AlunoMatriculado(aluno.getCpf());
		emissorDeEventos.publicar(alunoMatriculado);
	}
	
}
