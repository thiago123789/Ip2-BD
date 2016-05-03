package poo.negocios;

import poo.dados.DAO.PessoaDAO;

public class InfoUsuario {
	private PessoaDAO command;
	
	public InfoUsuario(){
		command = new PessoaDAO();
	}
	
	public int cursoUsuario(String cpf){
		return command.cursoUsuario(cpf);
	}
	
}
