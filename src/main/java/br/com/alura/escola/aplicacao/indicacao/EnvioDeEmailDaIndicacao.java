package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

public interface EnvioDeEmailDaIndicacao {

	void enviarPara(Aluno indicado);
	
}
