package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.interfaces.IAlunoDAO;
import poo.negocios.beans.Aluno;

public class InfoUsuario {
	private static InfoUsuario instance;
	private IAlunoDAO command;

	public static InfoUsuario getInstance(){
		if(instance == null){
			instance = new InfoUsuario();
		}
		return instance;
	}

	private InfoUsuario(){
		command = AlunoDAO.getInstance();
	}

	public int cursoAluno(String cpf){
		int curso = -1;
		ArrayList<Aluno> listando = command.listar();
		for(Aluno aux : listando){
			if(aux.getCpf().equals(cpf)){
				curso = aux.getCurso().getCodigo();
			}
		}
		return curso;
	}

}
