package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.exceptions.NumeroMaximoDeTelefonesException;

class AlunoTest {

	@Test
	void testaCriacaoDeAlunoValido() {
		Aluno aluno = new AlunoBuilder().comNomeCPFEmail("Igor", "111.222.333-44", "igor@email.com")
										.comTelefone("21", "999887766")
										.build();
		assertNotNull(aluno);
	}
	
	@Test
	void testaCriacaoDeAlunoComDoisTelefones() {
		Aluno aluno = new AlunoBuilder().comNomeCPFEmail("Igor", "111.222.333-44", "igor@email.com")
										.comTelefone("21", "999887766")
										.comTelefone("21", "955443322")
										.build();
		assertNotNull(aluno);
	}

	@Test
	void alunoComMaisDeDoisTelefonesDeveGerarExcecao() {
		assertThrows(NumeroMaximoDeTelefonesException.class, () -> new AlunoBuilder()
										.comNomeCPFEmail("Igor", "111.222.333-44", "igor@email.com")
										.comTelefone("21", "999887766")
										.comTelefone("21", "955443322")
										.comTelefone("21", "9544332211")
										.build());
	}
}
