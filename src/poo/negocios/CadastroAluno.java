package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.negocios.beans.Aluno;

public class CadastroAluno {
	private static CadastroAluno instance;
	private AlunoDAO command;
	private PessoaDAO commandA;
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
