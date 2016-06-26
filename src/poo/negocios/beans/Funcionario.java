package poo.negocios.beans;

import java.util.Calendar;

import poo.excecoes.CPFInvalidoException;

public class Funcionario extends Pessoa {
	private int permissaoDeAcesso;
	private Departamento departamento;
	private Cargo cargo;
	private boolean professor;

	public Funcionario(String pNome, String uNome, String cpf, boolean sexo,
                String senha, String email, Endereco endereco,
                Cargo cargo, Departamento depat,String lattes,Calendar nascimento) throws CPFInvalidoException{
		super(pNome, uNome, cpf, sexo, senha, email, endereco, 2, nascimento, lattes);
		this.setCargo(cargo);
		this.setDepartamento(departamento);

	}
        

	public void setProfessor(boolean value){
		this.professor = value;
	}

	public boolean isProfessor(){
		return this.professor;
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Cargo getCargo(){
		return this.cargo;
	}

	public void setCargo(Cargo cargo){
		this.cargo = cargo;
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
