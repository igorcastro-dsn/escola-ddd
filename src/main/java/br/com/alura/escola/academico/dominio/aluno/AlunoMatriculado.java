package br.com.alura.escola.academico.dominio.aluno;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

/**
 * @author igorcastro.dsn
 */
public class AlunoMatriculado implements Evento {

	private final CPF cpfDoALuno;
	private final LocalDateTime momento;

	public AlunoMatriculado(CPF cpfDoALuno) {
		this.cpfDoALuno = cpfDoALuno;
		this.momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

	public final CPF getCpfDoALuno() {
		return cpfDoALuno;
	}

	@Override
	public TipoDeEvento tipo() {
		return TipoDeEvento.ALUNO_MATRICULADO;
	}

	@Override
	public Map<String, Object> informacoes() {
		return Map.of("cpf", this.cpfDoALuno);
	}

}
