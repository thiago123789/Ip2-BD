package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Aluno;

public interface IAlunoDAO {
	public boolean inserir(Aluno a) throws SQLException;
	public boolean atualizar(Aluno a) throws SQLException;
	public ArrayList<Aluno> listar();
}
