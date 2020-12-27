package br.com.alura.escola.academico;

import java.util.List;

import br.com.alura.escola.academico.aplicacao.aluno.matricula.AlunoDto;
import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatriculaDeAluno;
import br.com.alura.escola.academico.dominio.EmissorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.JDBCConnection;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosComJDBC;

public class MatriculaCLI {
	
	private MatriculaCLI() {
	}

	public static void main(String[] args) {
		EmissorDeEventos emissorDeEventos = new EmissorDeEventos();
		emissorDeEventos.adicionar(new LogDeAlunoMatriculado());
		MatriculaDeAluno matricula = new MatriculaDeAluno(new RepositorioDeAlunosComJDBC(JDBCConnection.getConnection()), emissorDeEventos);

		String nome = "Fulano";
		String cpf = "149.902.012-22";
		String email = "fulano@email.com";
		matricula.matricular(new AlunoDto(nome, cpf, email));
		
		List<Aluno> alunos = matricula.listarMatriculados();
		alunos.forEach(aluno -> System.out.println(String.format("CPF: %s - Nome: %s", aluno.getCpf(), aluno.getNome())));
	}
	
}