package br.com.agendacontato.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoMysql implements ConexaoJdbc {
	private Connection connection = null;

    //Driver de conexao om o banco
    private String driver = "com.mysql.cj.jdbc.Driver";
    // caminho onde o banco esta fisicamente
    private static final String DATABASE_URL =
            "jdbc:mysql://127.0.0.1:3306/agenda?useTimezone=true&serverTimezone=UTC";

    // usuario do banco
    private static final String USERNAME = "root";
    // senha do banco
    private static final String PASSWORD = "";

    public ConexaoMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        this.connection.setAutoCommit(false);
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		
	}
}