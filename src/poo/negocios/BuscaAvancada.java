package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.negocios.beans.Disciplina;

public class BuscaAvancada {
	private static BuscaAvancada instance;
	private DisciplinaDAO command;
	
	public static BuscaAvancada getInstance(){
		if(instance == null){
			instance = new BuscaAvancada();
		}
		return instance;
	}
	
	private BuscaAvancada(){
		command = DisciplinaDAO.getInstance();
	}
	
	public ArrayList<Disciplina> searchAdvanced(String nom){
		return command.searchAdvanced(nom);
	}
	
	
}
