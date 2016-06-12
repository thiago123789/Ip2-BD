package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;

public class DetalhesDisciplina {
	private static DetalhesDisciplina instance;
	private IDisciplinaDAO command;
	private ICursoDAO commandA;

	public static DetalhesDisciplina getInstance(){
		if(instance == null){
			instance = new DetalhesDisciplina();
		}
		return instance;
	}

	private DetalhesDisciplina(){
		command = DisciplinaDAO.getInstance();
		commandA = CursoDAO.getInstance();
	}

	public Curso buscarCursoPorID(int id){
		Curso retorno = null;
		ArrayList<Curso> listando = commandA.listar();
		for(Curso aux : listando){
			if(aux.getCodigo() == id){
				retorno = aux;
				break;
			}
		}
		return retorno;
	}

	public Disciplina buscarDisciplinaPorCodigo(String codigo){
		Disciplina retorno = null;
		ArrayList<Disciplina> listando = command.listar();
		for(Disciplina aux : listando){
			if(aux.getCodigo().equals(codigo)){
				retorno = aux;
				break;
			}
		}
		return retorno;
	}

	public String detalheDisciplina(String codig){
		Disciplina temp = this.buscarDisciplinaPorCodigo(codig);
		String resultado = "";
		Curso aux = this.buscarCursoPorID(temp.getCurso().getCodigo());
		resultado += "------Detalhe Disciplina------"
				+ "\nCodigo: "+temp.getCodigo()+""
				+ "\nNome: "+temp.getNome()+""
				+ "\nCarga Horária: "+temp.getCargaHoraria()+""
				+ "\nCurso: "+aux.getNome();
		if(temp.getObrigatoria()){
			resultado += "\nTipo: Obrigatoria";
		}else if(temp.getOptativa()){
			resultado += "\nTipo: Optativa";
		}
		return resultado;
	}




}
