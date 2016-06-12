//CLASSE P/ DAVI
package poo.negocios.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

import poo.excecoes.CPFInvalidoException;

public class Pessoa {
	private String pNome;
	private String uNome;
	private String cpf;
	private Calendar dataNascimento;
	private boolean sexo;
	private String senha;
	private String email;
	private Endereco endereco;
	private int tipo_pessoa;
	private String lattes;

	public Pessoa(String pNome, String uNome, String cpf, boolean sexo,
			String senha, String email, Endereco endereco, int tipo_pessoa, Calendar nascimento, String lattes) throws CPFInvalidoException
	{
		this.setPnome(pNome);
		this.setUnome(uNome);
		this.setCpf(cpf);
		this.setSexo(sexo);
		this.setSenha(senha);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setTipo(tipo_pessoa);
		this.setDataNascimento(nascimento);
	}

	public Pessoa(String cpf) throws CPFInvalidoException{
		this.setCpf(cpf);
	}


	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public int getTipo(){
		return this.tipo_pessoa;
	}

	public void setTipo(int tp){
		if(tp >= 0 && tp <= 2){
			this.tipo_pessoa = tp;
		}
	}

	public void setUnome(String nome){
		if(nome != null){
			this.uNome = nome;
		}
	}

	public String getUnome(){
		return this.uNome;
	}

	public void setPnome(String nome)
	{
		if(nome != null)
		{
			this.pNome = nome;
		}
	}

	public void setCpf(String cpf) throws CPFInvalidoException
	{
		if (this.validarCPF(cpf) == true)
		{
			this.cpf = cpf;
		}
		else
		{
			throw new CPFInvalidoException();
		}
	}

	public String getPnome()
	{
		return this.pNome;
	}

	public String getCpf()
	{
		return this.cpf;
	}


	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Calendar nascimento) {
		if(nascimento != null){
			this.dataNascimento = nascimento;
		}
	}

	public boolean getSexo() {
		return this.sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null){
			this.senha = senha;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		if(email != null){
			this.email = email;
		}
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean validarCPF(String numeroCPF) throws CPFInvalidoException {

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (numeroCPF.equals("00000000000") || numeroCPF.equals("11111111111")
				|| numeroCPF.equals("22222222222") || numeroCPF.equals("33333333333")
				|| numeroCPF.equals("44444444444") || numeroCPF.equals("55555555555")
				|| numeroCPF.equals("66666666666") || numeroCPF.equals("77777777777")
				|| numeroCPF.equals("88888888888") || numeroCPF.equals("99999999999")
				|| (numeroCPF.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) { //
				// converte o i-esimo caractere do CPF em um numero: por
				// exemplo,
				// transforma o caractere '0' no inteiro 0 (48 eh a
				// posicao de '0' na tabela ASCII)
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			// Verifica se os digitos calculados
			// conferem com os digitos informados.
			if ((dig10 == numeroCPF.charAt(9)) && (dig11 == numeroCPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}


}
