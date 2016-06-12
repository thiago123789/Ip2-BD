package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Pessoa;

public class BuscaAvancada {
	private static BuscaAvancada instance;
	private IDisciplinaDAO command;

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
		ArrayList<Disciplina> listando = command.listar();
		ArrayList<Disciplina> retorno = new ArrayList<Disciplina>();
		for(Disciplina aux : listando){
			if(aux.getNome().contains(nom)){
				if(!retorno.contains(aux)){
					retorno.add(aux);
				}
			}
		}
		return retorno;
	}


}
