package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveCriarEmailComEnderecoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("email-invalido"));
	}
	
	@Test
	void deveCriarEmailComEnderecoValido() {
		String endereco = "igorcastro.dsn@gmail.com";
		Email email = new Email(endereco);
		assertNotNull(email);
		assertNotNull(email.getEndereco());
		assertTrue(email.getEndereco().equals(endereco));
	}

}
