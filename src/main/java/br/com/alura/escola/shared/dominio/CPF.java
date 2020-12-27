package br.com.alura.escola.shared.dominio;

/**
 * 
 * @author igorcastro.dsn
 *
 */
public class CPF {

	private String numero;

	public CPF(String numero) {
		setNumero(numero);
	}

	private void setNumero(String numero) {
		if (numero == null || !numero.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")) {
			throw new IllegalArgumentException("CPF inválido");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return this.numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.numero == ((CPF) obj).getNumero();
	}
}
