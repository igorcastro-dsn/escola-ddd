package br.com.alura.escola.academico.aplicacao.aluno.matricula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.EmissorDeEventos;

class MatriculaDeAlunoTest {

	private final RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

	@Test
	public void alunoDeveSerPersistido() {
		MatriculaDeAluno matricula = new MatriculaDeAluno(repositorio, new EmissorDeEventos());
		String nome = "Fulano";
		String cpf = "111.111.110-00";
		String email = "fulano@email.com";
		AlunoDto dto = new AlunoDto(nome, cpf, email);
		matricula.matricular(dto);
		
		Aluno alunoEncontrado = repositorio.buscarPorCpf(new CPF(cpf));
		assertEquals(nome, alunoEncontrado.getNome());
		assertEquals(cpf, alunoEncontrado.getCpf());
		assertEquals(email, alunoEncontrado.getEmail());
	}

}
