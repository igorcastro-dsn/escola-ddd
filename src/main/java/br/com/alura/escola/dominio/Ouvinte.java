package br.com.alura.escola.dominio;

/**
 * @author igorcastro.dsn
 */
public abstract class Ouvinte {

	public void processar(Evento evento) {
		if (this.deveProcessar(evento)) {
			this.reagirAo(evento);
		}
	}

	protected abstract void reagirAo(Evento evento);
	protected abstract boolean deveProcessar(Evento evento);
	
}
