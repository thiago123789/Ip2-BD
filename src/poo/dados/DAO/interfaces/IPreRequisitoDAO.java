package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.PreRequisito;

public interface IPreRequisitoDAO {
	public boolean inserir(PreRequisito pre) throws SQLException;
	public ArrayList<PreRequisito> listar() throws SQLException;
}
