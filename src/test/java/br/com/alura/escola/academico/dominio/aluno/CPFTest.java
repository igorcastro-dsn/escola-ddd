package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void naoDeveCriarCPFComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("15s-"));
	}
	
	@Test
	void deveCriarCPFComNumeroValido() {
		String numero = "111.222.333-99";
		CPF email = new CPF(numero);
		assertNotNull(email);
		assertNotNull(email.getNumero());
		assertTrue(email.getNumero().equals(numero));
	}

}
