/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.SenhaIncorretaException;
import poo.excecoes.UsuarioNaoExiste;

/**
 *
 * @author Thiago Gomes
 */
public class FachadaUsuario {
    private static FachadaUsuario instance;
    private Autenticar auto;
    private AlterarSenha changePassword;
    private Auxiliar aux;
    private FormatacaoAuxiliar auxFormat;
    
    public FachadaUsuario(){
        aux = new Auxiliar();
        changePassword = new AlterarSenha();
        auto = new Autenticar();
        auxFormat = new FormatacaoAuxiliar();
    }
    
    public static FachadaUsuario getInstance(){
        if(instance == null){
            instance = new FachadaUsuario();
        }
        return instance;
    }

	public boolean autenticaSenha(String user, String senha)
			throws SenhaIncorretaException {
		
		return auto.autenticaSenha(user, senha);
	}

	public boolean alterarSenha(String cpf, String novaSenha) {
		return changePassword.alterarSenha(cpf, novaSenha);
	}

	public boolean usuarioExiste(String cpf) throws UsuarioNaoExiste {
		return auto.usuarioExiste(cpf);
	}

	public int tipoDeUsuario(String cpf) {
		return auto.tipoDeUsuario(cpf);
	}

	public String nomeUsuario(String cpf) {
		return auto.nomeUsuario(cpf);
	}

	public void logar(String cpf) throws SQLException {
		auto.logar(cpf);
	}

	public String ultimoLogin(String cpf) {
		return auto.ultimoLogin(cpf);
	}

	public int[] retornarAnosAteAtual() {
		return aux.retornarAnosAteAtual();
	}

	public String verificaSenha(String user) {
		return auto.verificaSenha(user);
	}

	public String formatarCpf(String cpf) {
		return auxFormat.formatarCpf(cpf);
	}

	public String soNumerosCPF(String cpf) {
		return auxFormat.soNumerosCPF(cpf);
	}

	public boolean validarCPF(String numeroCPF) throws CPFInvalidoException {
		return auxFormat.validarCPF(numeroCPF);
	}
    
    
    
    
}
