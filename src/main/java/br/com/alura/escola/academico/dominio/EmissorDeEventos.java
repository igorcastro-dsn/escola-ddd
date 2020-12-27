package br.com.alura.escola.academico.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author igorcastro.dsn
 */
public class EmissorDeEventos {

	private List<Ouvinte> ouvintes = new ArrayList<>();
	
	public void adicionar(Ouvinte ouvinte) {
		this.ouvintes.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		this.ouvintes.forEach(ouvinte -> ouvinte.processar(evento));
	}
	
}
