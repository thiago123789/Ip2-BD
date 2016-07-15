package poo.dados.DAO.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IBancoConnection {
	public Connection getConexao();
	public void setConnectionNull();
	public boolean commit() throws SQLException;
}
