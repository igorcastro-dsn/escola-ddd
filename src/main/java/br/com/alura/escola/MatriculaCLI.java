package br.com.alura.escola;

import java.util.List;

import br.com.alura.escola.academico.aplicacao.aluno.matricula.AlunoDto;
import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatriculaDeAluno;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.JDBCConnection;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosComJDBC;
import br.com.alura.escola.gamificacao.aplicacao.GeracaoDoSeloDeAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.EmissorDeEventos;

/**
 * Ponto de entrada da aplicação, podendo ser um CLI, uma API e etc. Não tem problema essa camada acessar
 * múltiplos contextos da aplicação. 
 * @author igorcastro.dsn
 */
public class MatriculaCLI {
	
	private MatriculaCLI() {
	}

	public static void main(String[] args) {
		EmissorDeEventos emissorDeEventos = new EmissorDeEventos();
		emissorDeEventos.adicionar(new LogDeAlunoMatriculado());
		emissorDeEventos.adicionar(new GeracaoDoSeloDeAlunoNovato(new RepositorioDeSelosEmMemoria()));
		MatriculaDeAluno matricula = new MatriculaDeAluno(new RepositorioDeAlunosComJDBC(JDBCConnection.getConnection()), emissorDeEventos);

		String nome = "Fulano";
		String cpf = "149.902.012-22";
		String email = "fulano@email.com";
		matricula.matricular(new AlunoDto(nome, cpf, email));
		
		List<Aluno> alunos = matricula.listarMatriculados();
		alunos.forEach(aluno -> System.out.println(String.format("CPF: %s - Nome: %s", aluno.getCpf(), aluno.getNome())));
	}
	
}
