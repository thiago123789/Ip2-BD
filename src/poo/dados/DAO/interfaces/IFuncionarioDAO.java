package poo.dados.DAO.interfaces;

import java.sql.SQLException;

import poo.negocios.beans.Funcionario;

public interface IFuncionarioDAO {
	public void inserir(Funcionario func) throws SQLException;

}
