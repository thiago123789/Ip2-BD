package poo.negocios.beans;

public class Curso {
	private String nome;
	private String departamento;
	
	public Curso(String nome, String departamento)
	{
		this.setDepartamento(departamento);
		this.setNome(nome);
	}
	
	public void setNome(String nome)
	{
		if(nome != null)
		{
			this.nome = nome;
		}	
	}
	
	public void setDepartamento(String departamento)
	{
		if(departamento != null)
		{
			this.departamento = departamento;
		}
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getDepartamento()
	{
		return this.departamento;
	}
	
}
