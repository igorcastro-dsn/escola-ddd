package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

/**
 * Ouvindo do evento AlunoMatriculado
 * @author igorcastro.dsn
 */
public class LogDeAlunoMatriculado extends Ouvinte {
	
	private static final DateTimeFormatter DATE_TIME_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	@Override
	protected void reagirAo(Evento evento) {
		System.out.println(String.format("Aluno com CPF %s matriculado em %s", 
				((AlunoMatriculado) evento).getCpfDoALuno().getNumero(), 
				evento.momento().format(DATE_TIME_FMT)));
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}
	
}
