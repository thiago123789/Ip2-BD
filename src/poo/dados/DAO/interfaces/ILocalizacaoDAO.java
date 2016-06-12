package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Localizacao;

public interface ILocalizacaoDAO {
	public boolean inserir(Localizacao l) throws SQLException;
	public ArrayList<Localizacao> listar() throws SQLException;
	public boolean atualizar(Localizacao l) throws SQLException;
}
