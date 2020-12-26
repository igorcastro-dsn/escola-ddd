package br.com.alura.escola;

import java.util.List;

import br.com.alura.escola.aplicacao.aluno.matricula.AlunoDto;
import br.com.alura.escola.aplicacao.aluno.matricula.MatriculaDeAluno;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.infra.JDBCConnection;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosComJDBC;

public class MatriculaCLI {
	
	private MatriculaCLI() {
	}

	public static void main(String[] args) {
		MatriculaDeAluno matricula = new MatriculaDeAluno(new RepositorioDeAlunosComJDBC(JDBCConnection.getConnection()));

		String nome = "Fulano";
		String cpf = "149.902.012-22";
		String email = "fulano@email.com";
		matricula.matricular(new AlunoDto(nome, cpf, email));
		
		nome = "Outro Fulano";
		cpf = "150.902.012-32";
		email = "outro@email.com";
		matricula.matricular(new AlunoDto(nome, cpf, email));
		
		List<Aluno> alunos = matricula.listarMatriculados();
		alunos.forEach(aluno -> System.out.println(String.format("CPF: %s - Nome: %s", aluno.getCpf(), aluno.getNome())));
	}
	
}
