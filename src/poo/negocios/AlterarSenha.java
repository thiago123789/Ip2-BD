/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.PessoaDAO;
import poo.negocios.beans.Pessoa;

/**
 *
 * @author Thiago Gomes
 */
class AlterarSenha {
    private PessoaDAO comand;
    private static AlterarSenha instance;
    
    public static AlterarSenha getInstance(){
    	if(instance == null){
    		instance = new AlterarSenha();
    	}
    	return instance;
    }
    
    private AlterarSenha(){
    	comand = PessoaDAO.getInstance();
    }
    
    public boolean alterarSenha(String cpf, String novaSenha){
    	boolean ok = false;       
        Pessoa a = comand.buscaPessoa(cpf);
        
        System.out.println(cpf);
        System.out.println(a.toString());
        System.out.println(novaSenha);
        a.setSenha(novaSenha);
        System.out.println(a.toString());
    	try {
			comand.atualiza(a);
                        ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return ok;
    }
    
    
}
