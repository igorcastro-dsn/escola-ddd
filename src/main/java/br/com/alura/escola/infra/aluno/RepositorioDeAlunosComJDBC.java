package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoBuilder;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Telefone;
import br.com.alura.escola.exceptions.AlunoNaoEncontradoException;

/**
 * Implementação do respositório de alunos utilizando JDBC 
 * @author igorcastro.dsn
 */
public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void matricular(Aluno aluno) {
		String sql = "INSERT INTO aluno(cpf, nome, email) VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (!generatedKeys.next()) {
				throw new IllegalArgumentException("Não foi possível identificar o id gerado");
			}
			
			long id = generatedKeys.getLong(1);
			sql = "INSERT INTO telefone(ddd, numero, aluno_id) VALUES(?, ?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone: aluno.getTelefones()) {
				ps.setString(1, telefone.getDDD());
				ps.setString(2, telefone.getNumero());
				ps.setLong(3, id);
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		String sql = "SELECT id, nome, email FROM aluno WHERE cpf = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());
			
			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontradoException(cpf);
			}
			
			long id = rs.getLong("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			
			AlunoBuilder alunoBuilder = new AlunoBuilder().comNomeCPFEmail(nome, cpf.getNumero(), email);
			
			sql = "SELECT ddd, numero, FROM telefone WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				alunoBuilder.comTelefone(rs.getString("ddd"), rs.getString("numero"));
			}
			
			return alunoBuilder.build();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			while (rs.next()) {
				AlunoBuilder alunoBuilder = new AlunoBuilder().comNomeCPFEmail(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"));
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					alunoBuilder.comTelefone(rsTelefone.getString("numero"), rsTelefone.getString("ddd"));
				}
				alunos.add(alunoBuilder.build());
			}
			
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
