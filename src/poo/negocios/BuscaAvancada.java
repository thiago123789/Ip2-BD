package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.negocios.beans.Disciplina;

public class BuscaAvancada {
	private DisciplinaDAO command;
	
	public BuscaAvancada(){
		command = new DisciplinaDAO();
	}
	
	public ArrayList<Disciplina> searchAdvanced(String nom){
		return command.searchAdvanced(nom);
	}
	
	
}
