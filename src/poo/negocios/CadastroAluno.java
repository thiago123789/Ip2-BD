package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.interfaces.IAlunoDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.negocios.beans.Aluno;

public class CadastroAluno {
	private static CadastroAluno instance;
	private IAlunoDAO command;
	private IPessoaDAO commandA;

	public static CadastroAluno getInstance(){
		if(instance == null){
			instance = new CadastroAluno();
		}
		return instance;
	}

	private CadastroAluno(){
		command = AlunoDAO.getInstance();
		commandA = PessoaDAO.getInstance();
	}

	public void cadastraAluno(Aluno a){
		try {
			commandA.inserir(a);
			command.inserir(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}





}
