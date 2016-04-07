//CLASSE PARA DAVI;
package poo.negocios.beans.davi;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.sidronio.Curso;

public class Professor extends Pessoa{
	private String titulo;
	private Curso curso;
	private String lates;
	
	public Professor(String titulo, String lates, Curso curso, String nome, String cpf) throws CPFInvalidoException
	{
		super(nome, cpf);
		this.setTitulo(titulo);
		this.setCurso(curso);
		this.setLates(lates);
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
	
	public void setLates(String lates)
	{
		if(lates != null)
		{
			this.lates = lates;
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
	
	public String getLates()
	{
		return this.lates;
	}
	
}
