package poo.negocios;

import java.sql.SQLException;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.negocios.beans.Professor;

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
        
        public void cadastraProfessor(Professor p){
		try {
			commandA.inserir(p);
			command.inserir(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}

}
}
