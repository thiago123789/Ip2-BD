package poo.negocios.beans;

import poo.excecoes.CPFInvalidoException;

public class Funcionario extends Pessoa {
	private int permissaoDeAcesso;
	private Departamento departamento;
	
	public Funcionario(String pNome, String uNome, String cpf, String sexo, String senha, String email, Endereco endereco) throws CPFInvalidoException
	{
	super(pNome, uNome, cpf, sexo, senha, email, endereco);
}
	public int getPermissaoDeAcesso(){
		return this.permissaoDeAcesso;
	}
	
	public Departamento getDepartamento(){
		return this.departamento;
	}
	
	public void setPermissaoDeAcesso(int permissaoDeAcesso){
		if(permissaoDeAcesso >= 0){
			this.permissaoDeAcesso = permissaoDeAcesso;
		}
	}
	public void setDepartamento(Departamento departamento){
		if(departamento != null){
			this.departamento = departamento;
		}
	}
}
