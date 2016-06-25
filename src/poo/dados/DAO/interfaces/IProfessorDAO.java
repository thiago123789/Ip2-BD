package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Professor;

public interface IProfessorDAO {
	public boolean inserir(Professor p) throws SQLException;
	public ArrayList<Professor> listar();
}
