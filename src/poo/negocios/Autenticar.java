package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.HistoricoLoginDAO;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.interfaces.IHistoricoLoginDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.excecoes.SenhaIncorretaException;
import poo.excecoes.UsuarioNaoExiste;
import poo.negocios.beans.Pessoa;

public class Autenticar {
	private IPessoaDAO comand;
	private IHistoricoLoginDAO comandA;
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

	public String retornaSenha(String cpf) throws SQLException{
		String senha = null;
		ArrayList<Pessoa> listando = comand.listar();
		for(Pessoa aux : listando){
			if(aux.getCpf().equals(cpf)){
				senha = aux.getSenha();
				break;
			}
		}
		return senha;
	}

	public boolean autenticaSenha(String user, String senha) throws SenhaIncorretaException, SQLException{
		boolean ok = false;
		if(this.retornaSenha(user).equals(senha)){
			ok = true;
		}else{
			throw new SenhaIncorretaException();
		}
		return ok;
	}

	public boolean usuarioExiste(String cpf) throws UsuarioNaoExiste, SQLException{
		boolean existe = false;
		ArrayList<Pessoa> listando = comand.listar();
		for(Pessoa aux : listando){
			if(aux.getCpf().equals(cpf)){
				existe = true;
				break;
			}
		}
		return existe;
	}

	public int tipoDeUsuario(String cpf) throws SQLException{
		int tipoUsuario = -1;
		ArrayList<Pessoa> listando = comand.listar();
		for(Pessoa aux : listando){
			if(aux.getCpf().equals(cpf)){
				tipoUsuario = aux.getTipo();
				break;
			}
		}
		return tipoUsuario;
	}

	public String nomeUsuario(String cpf) throws SQLException{
		String nomePessoa = null;
		ArrayList<Pessoa> listando = comand.listar();
		for(Pessoa aux : listando){
			if(aux.getCpf().equals(cpf)){
				nomePessoa = aux.getPnome()+" "+aux.getUnome();
				break;
			}
		}
		return nomePessoa;
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
