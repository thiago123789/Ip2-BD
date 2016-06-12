/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;
import poo.dados.DAO.interfaces.*;
import poo.dados.DAO.PessoaDAO;
import poo.negocios.beans.Pessoa;

class AlterarSenha {
	private IPessoaDAO command;
	private static AlterarSenha instance;

	public static AlterarSenha getInstance(){
		if(instance == null){
			instance = new AlterarSenha();
		}
		return instance;
	}

	private AlterarSenha(){
		command = PessoaDAO.getInstance();
	}

	public Pessoa buscarPessoa(String cpf) throws SQLException{
		Pessoa a = null;
		ArrayList<Pessoa> listando = command.listar();
		for(Pessoa aux : listando){
			if(aux.getCpf().equals(cpf)){
				a = aux;
				break;
			}
		}
		return a;
	}

	public boolean alterarSenha(String cpf, String novaSenha){
		boolean ok = false;
		try {
			Pessoa a = this.buscarPessoa(cpf);
			a.setSenha(novaSenha);
			command.atualiza(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}


}
