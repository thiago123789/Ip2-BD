package poo.negocios;

import poo.dados.DAO.PessoaDAO;

public class InfoUsuario {
	private static InfoUsuario instance;
	private PessoaDAO command;
	
	public static InfoUsuario getInstance(){
		if(instance == null){
			instance = new InfoUsuario();
		}
		return instance;
	}
	
	private InfoUsuario(){
		command = PessoaDAO.getInstance();
	}
	
	public int cursoUsuario(String cpf){
		return command.cursoUsuario(cpf);
	}
	
}
