package br.com.alura.escola.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utilizado apenas para testes com o banco sem preocupação com pool de conexões
 * 
 * @author igorcastro.dsn
 */
public class JDBCConnection {

	private JDBCConnection() {
	}

	static {
		inicializarTabelas();
	}
	
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				connection = DriverManager.getConnection("jdbc:hsqldb:file:\\C:\\dsn\\back\\hsqldb\\escola\\escola", "sa", "");
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return connection;
	}

	public static void inicializarTabelas() {
		Connection connection = getConnection();
		inicializarTabelaDeAlunos(connection);
		inicializarTabelaDeTelefone(connection);
	}

	private static void inicializarTabelaDeAlunos(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS aluno (" + 
							   "id BIGINT IDENTITY PRIMARY KEY, " + 
							   "nome VARCHAR(50) NOT NULL, " + 
							   "cpf VARCHAR(14) NOT NULL, " + 
							   "email VARCHAR(30));");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static void inicializarTabelaDeTelefone(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS telefone (" + 
							   "id BIGINT IDENTITY PRIMARY KEY, " + 
							   "ddd VARCHAR(2) NOT NULL, " + 
							   "numero VARCHAR(9) NOT NULL, "+ 
							   "aluno_id BIGINT," + 
							   "FOREIGN KEY (aluno_id) REFERENCES aluno(id));");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
