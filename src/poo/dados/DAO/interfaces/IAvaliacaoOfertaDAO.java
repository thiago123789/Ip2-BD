package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.AvaliacaoOferta;

public interface IAvaliacaoOfertaDAO {
	public boolean atualizar(AvaliacaoOferta av) throws SQLException;
	public ArrayList<AvaliacaoOferta> listar();
}
