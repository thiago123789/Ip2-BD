package poo.dados.DAO.interfaces;

import java.sql.SQLException;

public interface IHistoricoLoginDAO {
	public void inserir(String cpf) throws SQLException;
	public String buscaCN(String cpf);
}
