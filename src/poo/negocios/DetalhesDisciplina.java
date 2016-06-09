package poo.negocios;

import poo.dados.IDisciplinaDAO;
import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;

public class DetalhesDisciplina {
	private static DetalhesDisciplina instance;
	private IDisciplinaDAO command;
	private CursoDAO commandA;

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

	public String detalheDisciplina(String codig){
		Disciplina temp = command.buscaCN(codig);
		String resultado = "";
		Curso aux = commandA.buscaCursoPorID(temp.getCurso().getCodigo());
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
