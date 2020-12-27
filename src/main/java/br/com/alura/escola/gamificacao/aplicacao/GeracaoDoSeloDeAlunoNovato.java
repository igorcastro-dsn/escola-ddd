package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

/**
 * @author igorcastro.dsn
 */
public class GeracaoDoSeloDeAlunoNovato extends Ouvinte {
	
	private final RepositorioDeSelos repositorio;
	
	public GeracaoDoSeloDeAlunoNovato(RepositorioDeSelos repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	protected void reagirAo(Evento evento) {
		CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
		Selo selo = new Selo(cpfDoAluno, "Novato");
		repositorio.adicionar(selo);
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo().equals(TipoDeEvento.ALUNO_MATRICULADO);
	}

}
