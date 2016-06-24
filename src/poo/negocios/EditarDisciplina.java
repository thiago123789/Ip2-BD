package poo.negocios;

import java.util.ArrayList;
import java.util.stream.Stream;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaCursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaCursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.negocios.beans.Disciplina;

public class EditarDisciplina {
	private static EditarDisciplina instance;
	private IDisciplinaDAO repositorio;
	private IPreRequisitoDAO req;
	private ICursoDAO curso;	
	private IDisciplinaCursoDAO disC;

	public static EditarDisciplina getInstance(){
		if(instance == null){
			instance = new EditarDisciplina();
		}
		return instance;
	}

	private EditarDisciplina(){
		repositorio = DisciplinaDAO.getInstance();
		curso = CursoDAO.getInstance();
		req = PreRequisitoDAO.getInstance();
		disC = DisciplinaCursoDAO.getInstance();
	}
	
	public Disciplina buscarDisciplinaPorCodigo(String codigo){
		Disciplina retorno = null;
		ArrayList<Disciplina> lista = repositorio.listar();
		retorno = (Disciplina) lista.stream().filter(e -> e.getCodigo().equals(codigo));
		return retorno;
	}
	
	
	
}
