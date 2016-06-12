package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Pessoa;

public interface IPessoaDAO {
	public boolean inserir(Pessoa p) throws SQLException;
	public boolean atualiza(Pessoa a) throws SQLException;
	public ArrayList<Pessoa> listar() throws SQLException;
}
