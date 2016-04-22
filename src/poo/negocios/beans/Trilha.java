package poo.negocios.beans;

public class Trilha {
	private int codigo;
	private AreaDePesquisa area;
	private String nome;
	
	public Trilha(int codigo, AreaDePesquisa area, String nome){
		this.setCodigo(codigo);
		this.setArea(area);
		this.setNome(nome);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public AreaDePesquisa getArea() {
		return area;
	}
	public void setArea(AreaDePesquisa area) {
		this.area = area;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
