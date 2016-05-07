package poo.negocios;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import poo.dados.DAO.HistoricoLoginDAO;
import poo.dados.DAO.PessoaDAO;
import poo.excecoes.SenhaIncorretaException;
import poo.excecoes.UsuarioNaoExiste;

public class Autenticar {
    private PessoaDAO comand;
    private HistoricoLoginDAO comandA;
    private static Autenticar instance;
    
    public static Autenticar getInstance(){
    	if(instance == null){
    		instance = new Autenticar();
    	}
    	return instance;
    }
    
    private Autenticar(){
        this.comand = PessoaDAO.getInstance();
        this.comandA = HistoricoLoginDAO.getInstance();
    }
    
    public String verificaSenha(String user){
    	return comand.verificaSenha(user);
    }
    
    public boolean autenticaSenha(String user, String senha) throws SenhaIncorretaException{
        boolean ok = false;
        if(comand.autenticar(user, senha)){
            ok = true;
        }else{
            throw new SenhaIncorretaException();
        }
        
        return ok;
    }
    
    public boolean usuarioExiste(String cpf) throws UsuarioNaoExiste{
        boolean ok = false;
        if(comand.existeUsuario(cpf)){
            ok = true;
        }else{
            throw new UsuarioNaoExiste();
        }
        return ok;
    }
    
    public int tipoDeUsuario(String cpf) {
        return comand.tipoDeUsuario(cpf);
    }
    
    public String nomeUsuario(String cpf){
        return comand.nomeUsuario(cpf);
    }

    public void logar(String cpf) throws SQLException{
        comandA.inserir(cpf);
    }

    
    public String ultimoLogin(String cpf){
        String aux = comandA.buscaCN(cpf);
        if(aux.length() < 3){
            return null;
        }else{
            return aux.substring(0, 19);
        }
               
    }
    
    
    
    
}
