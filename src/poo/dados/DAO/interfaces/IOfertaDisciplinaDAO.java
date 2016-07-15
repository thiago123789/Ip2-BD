package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.OfertaDisciplina;

public interface IOfertaDisciplinaDAO {
	public int inserir(OfertaDisciplina offer) throws SQLException;
	public ArrayList<OfertaDisciplina> listar();
}
