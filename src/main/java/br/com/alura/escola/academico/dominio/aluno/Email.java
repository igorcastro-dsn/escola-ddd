package br.com.alura.escola.academico.dominio.aluno;

/**
 * Essa classe não tem nenhuma diferenciação entre objetos, pois não tem um atributo que os diferencia.
 * Ou seja, não é uma entidade. Só o valor importa e com isso dizemos que ela segue o padrão de Value Object
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
			throw new IllegalArgumentException("E-mail inválido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}
	
}
