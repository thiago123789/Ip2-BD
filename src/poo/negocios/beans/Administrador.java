package poo.negocios.beans;

import java.util.Calendar;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.PermissaoInvalidaException;

public class Administrador extends Funcionario{
    private int permissao;

    public Administrador(String cpf, String pNome, String uNome, int permissao, String senha, String email, Cargo cargo, Departamento depat,
    		boolean sexo, Endereco endereco, Calendar nascimento, String lattes) throws PermissaoInvalidaException, CPFInvalidoException{
        super(pNome, uNome, cpf, sexo, senha, email, endereco, cargo, depat, lattes, nascimento);
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
