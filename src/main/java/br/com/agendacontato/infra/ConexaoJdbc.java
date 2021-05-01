package br.com.agendacontato.infra;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJdbc {

    Connection getConnection();

    void close();

    void commit() throws SQLException;

    void rollback();
}
