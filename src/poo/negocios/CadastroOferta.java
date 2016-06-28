package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.LocalizacaoDAO;
import poo.dados.DAO.OfertaDisciplinaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.ProfessorOfertaDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.ILocalizacaoDAO;
import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.dados.DAO.interfaces.IProfessorOfertaDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.OfertaDisciplina;

public class CadastroOferta {
	private static CadastroOferta instance;
	private IOfertaDisciplinaDAO command;
	private ICursoDAO curso;
	private IDisciplinaDAO disciplina;
	private ILocalizacaoDAO local;
	private IProfessorDAO professor;
	private IProfessorOfertaDAO profOff;

	public static CadastroOferta getInstance(){
		if(instance == null){
			instance = new CadastroOferta();
		}
		return instance;
	}

	private CadastroOferta(){
		command = OfertaDisciplinaDAO.getInstance();
		curso = CursoDAO.getInstance();
		disciplina = DisciplinaDAO.getInstance();
		local = LocalizacaoDAO.getInstance();
		professor = ProfessorDAO.getInstance();
		profOff = ProfessorOfertaDAO.getInstance();
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

	public boolean inserirOferta(OfertaDisciplina of){
		boolean inseriu = false;
		int idCurso = this.idCurso(of.getCurso().getNome());
		of.getCurso().setCodigo(idCurso);
		command.inserir(of);
		inseriu = true;
		return inseriu;
	}





}
