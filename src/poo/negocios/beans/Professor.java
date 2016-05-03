//CLASSE PARA DAVI;
package poo.negocios.beans;

import poo.excecoes.CPFInvalidoException;

public class Professor extends Funcionario{
	private String titulo;
	private Curso curso;
	private String lattes;
	
	public Professor(String titulo, String lattes,boolean sexo, String senha, 
			String email, Endereco endereco, Curso curso,
			String pNome, String uNome, String cpf, String cargo) throws CPFInvalidoException
	{
		super(pNome, uNome, cpf, sexo, senha, email, endereco, cargo);
		this.setTitulo(titulo);
		this.setCurso(curso);
		this.setLattes(lattes);
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
	
	public void setLattes(String lattes)
	{
		if(lattes != null)
		{
			this.lattes = lattes;
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
	
	public String getLattes()
	{
		return this.lattes;
	}
	
}
