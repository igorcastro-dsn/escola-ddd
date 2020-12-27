package br.com.alura.escola.academico.dominio.aluno;

/**
 * Essa classe n�o tem nenhuma diferencia��o entre objetos, pois n�o tem um atributo que os diferencia.
 * Ou seja, n�o � uma entidade. S� o valor importa e com isso dizemos que ela segue o padr�o de Value Object
 * @author igorcastro.dsn
 *
 */
public class Email {

	private String endereco;
	
	public Email(String endereco) {
		setEndereco(endereco);
	}

	private void setEndereco(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail inv�lido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}
	
}
