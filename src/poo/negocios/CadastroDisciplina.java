package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaCursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaCursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;

public class CadastroDisciplina {
	private IDisciplinaCursoDAO dc;
	private ICursoDAO curso;
	private IDisciplinaDAO comand;
	private IPreRequisitoDAO comandA;
	public static CadastroDisciplina instance;

	public static CadastroDisciplina getInstance(){
		if(instance == null){
			instance = new CadastroDisciplina();
		}
		return instance;
	}

	private CadastroDisciplina(){
		this.comand = DisciplinaDAO.getInstance();
		this.comandA = PreRequisitoDAO.getInstance();
		this.dc = DisciplinaCursoDAO.getInstance();
		this.curso = CursoDAO.getInstance();
	}

	public boolean existeDisciplina(String codigo){
		boolean existe = false;
		ArrayList<Disciplina> listando = comand.listar();
		for(Disciplina aux : listando){
			if(aux.getCodigo().equals(codigo)){
				existe = true;
				break;
			}
		}
		return existe;
	}

	private int idCurso(String nome){
		int retorno = -1;
		ArrayList<Curso> listaCursos = curso.listar();
		for(Curso c : listaCursos ){
			if(c.getNome().equals(nome)){
				retorno = c.getCodigo();
				break;
			}
		}
		return retorno;
	}

	public void inserirDisciplina(Disciplina a) throws DisciplinaJaExisteException{
		try {
			if(!this.existeDisciplina(a.getCodigo())){
				comand.inserir(a);
				for(Curso c : a.getCurso()){
					c.setCodigo(this.idCurso(c.getNome()));
				}
				dc.inserir(a);
			}else{
				throw new DisciplinaJaExisteException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
