package poo.negocios;

import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;

public class CadastroProfessor {
	private static CadastroProfessor instance;
	private PessoaDAO command;
	private ProfessorDAO commandA;
	
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
