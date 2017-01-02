package poo.dados;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.*;
import poo.dados.DAO.DisciplinaDAO;
import poo.negocios.beans.Disciplina;

public interface IDisciplinaDAO {
	public ArrayList<Disciplina> consulta();
	public boolean inserir(Disciplina disciplina) throws SQLException;
	public boolean atualiza(Disciplina disciplina) throws SQLException;
	public ArrayList<Disciplina> listarDisciplinasPorCurso(int curso);
	public Disciplina buscaCN(String codigoDis);
	public ArrayList<Disciplina> searchAdvanced(String nomeD);
	public boolean existeDis(String codigoDis);
}

