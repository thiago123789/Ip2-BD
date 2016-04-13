package poo.negocios.beans.sidronio;

public class Graduacao {

	private String nome;
	private String area;
	
	public Graduacao(String nome, String area){
		this.nome=nome;
		this.area=area;
	}
	
	public Graduacao(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Graduacao [nome=" + nome + ", area=" + area + "]";
	}
	
	
}
