package poo.negocios;

import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;

public class CadastroProfessor {
	private static CadastroProfessor instance;
	private IPessoaDAO command;
	private IProfessorDAO commandA;

	public static CadastroProfessor getInstance(){
		if(instance == null){
			instance = new CadastroProfessor();
		}
		return instance;
	}

	private CadastroProfessor(){
		command = PessoaDAO.getInstance();
		commandA = ProfessorDAO.getInstance();
	}

}
