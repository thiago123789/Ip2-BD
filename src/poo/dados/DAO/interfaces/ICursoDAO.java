package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Curso;

public interface ICursoDAO {
	public boolean inserir(Curso c) throws SQLException;
	public boolean atualizar(Curso c) throws SQLException;
	public ArrayList<Curso> listar();
}
