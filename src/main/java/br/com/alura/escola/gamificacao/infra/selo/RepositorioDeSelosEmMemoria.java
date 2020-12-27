package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;

/**
 * @author igorcastro.dsn
 */
public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}
	
	@Override
	public List<Selo> listar() {
		return this.selos;
	}

	@Override
	public List<Selo> listar(CPF cpf) {
		return this.selos
				   .stream()
				   .filter(selo -> selo.getCpfDoAluno().equals(cpf))
				   .collect(Collectors.toList());
	}

}
