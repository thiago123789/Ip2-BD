package poo.negocios.beans;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.PermissaoInvalidaException;

public class Administrador extends Funcionario{
    private int permissao;
       
    public Administrador(String cpf, String pNome, String uNome, int permissao, 
    		boolean sexo, Endereco endereco) throws PermissaoInvalidaException, CPFInvalidoException{
        super(pNome, uNome, cpf, sexo, cpf, cpf, endereco, cpf);
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
