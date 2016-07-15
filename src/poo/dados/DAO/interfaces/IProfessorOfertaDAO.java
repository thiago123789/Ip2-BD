package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.ProfessorOferta;

public interface IProfessorOfertaDAO {
	public boolean inserir(String cpf, int id) throws SQLException;
	public ArrayList<ProfessorOferta> listar();
}
