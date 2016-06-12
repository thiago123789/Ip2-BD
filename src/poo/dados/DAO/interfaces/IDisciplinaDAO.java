package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Disciplina;

public interface IDisciplinaDAO {
	public boolean inserir(Disciplina disciplina) throws SQLException;
	public boolean atualizar(Disciplina disciplina) throws SQLException;
	public ArrayList<Disciplina> listar();
}
