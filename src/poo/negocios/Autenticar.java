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
    PessoaDAO comand;
    HistoricoLoginDAO comandA;
    
    public Autenticar(){
        this.comand = new PessoaDAO();
        this.comandA = new HistoricoLoginDAO();
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
//    
//    public String getDateTime() { 
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        
//        return dateFormat.format(date);; 
//    }

    public void logar(String cpf) throws SQLException{
        comandA.inserir(cpf);
    }

    
    public String ultimoLogin(String cpf){
        String aux = comandA.buscaCN(cpf);
        System.out.println(aux);
        if(aux.length() < 3){
            return null;
        }else{
            return aux.substring(0, 19);
        }
               
    }
    
    
    
    
}
