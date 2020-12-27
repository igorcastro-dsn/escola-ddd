package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void naoDeveCriarTelefoneComDDDInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone("555", "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("5", "123456789"));
	}
	
	@Test
	void naoDeveCriarTelefoneComNumeroInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone("21", "1234567"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("21", "12345678910"));
	}
	
	@Test
	void deveCriarTelefoneComDDDENumeroValidos() {
		String ddd = "21";
		String numero = "123456789";
		Telefone telefone = new Telefone(ddd, numero);
		assertNotNull(telefone);
		assertNotNull(telefone.getDDD());
		assertNotNull(telefone.getNumero());
		assertTrue(telefone.getDDD().equals(ddd));
		assertTrue(telefone.getNumero().equals(numero));
	}

}
