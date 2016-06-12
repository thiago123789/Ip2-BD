//CLASSE PARA DAVI;
package poo.negocios.beans;

import java.util.Calendar;

import poo.excecoes.CPFInvalidoException;

public class Professor extends Funcionario{
	private String titulo;
	private Curso curso;
	private String ies;
	private String externo;

	public Professor(String titulo, String lattes,boolean sexo, String senha,
			String email, Endereco endereco, Curso curso,
			String pNome, String uNome, String cpf, Cargo cargo, Calendar nascimento,
			Departamento depat, String lattes1) throws CPFInvalidoException	{
		super(pNome, uNome, cpf, sexo, senha, email, endereco, cargo, depat, lattes1, nascimento);
		this.setTitulo(titulo);
		this.setCurso(curso);

	}

	public Professor(String cpf) throws CPFInvalidoException{
		super();
		this.setCpf(cpf);

	}

	public String getIes() {
		return ies;
	}

	public void setIes(String ies) {
		this.ies = ies;
	}

	public String getExterno() {
		return externo;
	}

	public void setExterno(String externo) {
		this.externo = externo;
	}

	public void setTitulo(String titulo)
	{
		if(titulo != null)
		{
			this.titulo = titulo;
		}
	}

	public void setCurso(Curso curso)
	{
		if(curso != null)
		{
			this.curso = curso;
		}
	}



	public String getTitulo()
	{
		return this.titulo;
	}

	public Curso getCurso()
	{
		return this.curso;
	}

}
