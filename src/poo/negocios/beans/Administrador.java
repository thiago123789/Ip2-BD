package poo.negocios.beans;

import java.util.Date;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.PermissaoInvalidaException;
import poo.negocios.beans.davi.*;
import poo.negocios.beans.sidronio.*;




public class Administrador extends Pessoa{
    private int permissao;
    private String usuario;
    private String senha;
    private Date data_nasc;
       
    public Administrador(String pNome,Date data_nasc, String uNome, String cpf, int permissao, String usuario, String senha) throws CPFInvalidoException, PermissaoInvalidaException{
        super(pNome, uNome, cpf);
        this.setPermissao(permissao);
        this.data_nasc = data_nasc;
        
    }
    
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
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
    
    
    
    private void setUsuario(){
        this.usuario = this.gerarUsuario();
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public String gerarUsuario(){
        String resultado = "";
        boolean existeUsuario = false;
        
        do{
        	char symbol = this.gerarSimbolo();
            resultado = this.getPnome()+symbol+this.getUnome();
            /*
                CRIAR METODO PARA VERIFICAR SE USUARIO JA EXISTE OU NAO;
            if(existeUsuario(resultado)){
                existeUsuario = true;
            }else{
                existeUsuario = false;
            }
            */
        }while(!existeUsuario);
               
        return resultado;
    }
    
    public char gerarSimbolo(){
        char resultado = 0;
        
        
        
        return resultado;
    }
    
   
}
