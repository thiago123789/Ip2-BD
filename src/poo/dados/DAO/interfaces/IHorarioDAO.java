package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.Horario;

public interface IHorarioDAO {
	public boolean inserir(Horario a) throws SQLException;
	public boolean atualizar(Horario a) throws SQLException;
	public ArrayList<Horario> listar() throws SQLException;
	public boolean remover(Horario h) throws SQLException;
}
