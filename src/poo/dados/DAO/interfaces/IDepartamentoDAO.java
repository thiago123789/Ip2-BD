package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Departamento;

public interface IDepartamentoDAO {
	public boolean inserir(Departamento depat) throws SQLException;
	public boolean atualizar(Departamento depat) throws SQLException;
	public ArrayList<Departamento> listar() throws SQLException;
}
