package poo.dados.DAO.interfaces;

import java.util.ArrayList;

import poo.negocios.beans.Disciplina;
import poo.negocios.beans.DisciplinaCurso;

public interface IDisciplinaCursoDAO {
	public boolean inserir(Disciplina a);
	public ArrayList<DisciplinaCurso> litar();
}
