package poo.dados.DAO.interfaces;

import java.sql.SQLException;

import poo.negocios.beans.Professor;

public interface IProfessorDAO {
	public boolean inserir(Professor p) throws SQLException;
}
