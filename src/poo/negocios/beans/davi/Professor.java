//CLASSE PARA DAVI;
package poo.negocios.beans.davi;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.sidronio.Curso;

public class Professor extends Pessoa{
	private String titulo;
	private Curso curso;
	private String lattes;
	
	public Professor(String titulo, String lattes, Curso curso, String pNome, String uNome, String cpf) throws CPFInvalidoException
	{
		super(pNome, uNome, cpf);
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
