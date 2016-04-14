package poo.negocios.beans;

import java.util.Date;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.PermissaoInvalidaException;
import poo.negocios.beans.davi.*;
import poo.negocios.beans.sidronio.*;

public class Administrador extends Pessoa{
    private int permissao;
       
    public Administrador(String pNome, String uNome, String cpf, int permissao) throws CPFInvalidoException, PermissaoInvalidaException{
        super(pNome, uNome, cpf);
        this.setPermissao(permissao);
    }
    
	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int persmissao) throws PermissaoInvalidaException{
        if(permissao >= 0 && permissao < 3){
            this.permissao = permissao;
        }else{
            throw new PermissaoInvalidaException();
        }
    }
   
}