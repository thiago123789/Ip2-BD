/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.SenhaIncorretaException;
import poo.excecoes.UsuarioNaoExiste;
import poo.negocios.beans.Pessoa;

public class FachadaUsuario {
    private static FachadaUsuario instance;
    private Autenticar auto;
    private AlterarSenha changePassword;
    private Auxiliar aux;
    private FormatacaoAuxiliar auxFormat;

    private FachadaUsuario(){
        aux = Auxiliar.getInstance();
        changePassword = AlterarSenha.getInstance();
        auto = Autenticar.getInstance();
        auxFormat = FormatacaoAuxiliar.getInstance();
    }

    public static FachadaUsuario getInstance(){
        if(instance == null){
            instance = new FachadaUsuario();
        }
        return instance;
    }

	public String retornaSenha(String cpf) throws SQLException {
		return auto.retornaSenha(cpf);
	}

	public boolean autenticaSenha(String user, String senha) throws SenhaIncorretaException, SQLException {
		return auto.autenticaSenha(user, senha);
	}

	public boolean usuarioExiste(String cpf) throws UsuarioNaoExiste, SQLException {
		return auto.usuarioExiste(cpf);
	}

	public int tipoDeUsuario(String cpf) throws SQLException {
		return auto.tipoDeUsuario(cpf);
	}

	public String nomeUsuario(String cpf) throws SQLException {
		return auto.nomeUsuario(cpf);
	}

	public String ultimoLogin(String cpf) {
		return auto.ultimoLogin(cpf);
	}

	public Pessoa buscarPessoa(String cpf) throws SQLException {
		return changePassword.buscarPessoa(cpf);
	}

	public boolean alterarSenha(String cpf, String novaSenha) {
		return changePassword.alterarSenha(cpf, novaSenha);
	}

	public int[] retornarAnosAteAtual() {
		return aux.retornarAnosAteAtual();
	}

	public ArrayList<Integer> retornarAnosAteAtualList() {
		return aux.retornarAnosAteAtualList();
	}

	public ArrayList<Integer> retornarAnosAPartirDeList(int inicio) {
		return aux.retornarAnosAPartirDeList(inicio);
	}

	public int[] retornarAnosAPartirDe(int inicio) {
		return aux.retornarAnosAPartirDe(inicio);
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

	public void logar(String cpf) throws SQLException {
		auto.logar(cpf);
	}





}
