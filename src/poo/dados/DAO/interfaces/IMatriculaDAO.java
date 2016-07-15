package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Matricula;

public interface IMatriculaDAO {
	public int inserir(Matricula a) throws SQLException;
	public ArrayList<Matricula> listar() throws SQLException, CPFInvalidoException;
}
