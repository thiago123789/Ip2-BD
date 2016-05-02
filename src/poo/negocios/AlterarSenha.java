/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;

import poo.dados.UsuarioDAO;
import poo.negocios.beans.Pessoa;

/**
 *
 * @author Thiago Gomes
 */
class AlterarSenha {
    private UsuarioDAO comand;
    
    public AlterarSenha(){
    	comand = new UsuarioDAO();
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
