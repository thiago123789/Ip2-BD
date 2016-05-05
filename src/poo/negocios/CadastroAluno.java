package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.negocios.beans.Aluno;

public class CadastroAluno {
	private AlunoDAO command;
	private PessoaDAO commandA;
	
	public CadastroAluno(){
		command = new AlunoDAO();
		commandA = new PessoaDAO();
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
