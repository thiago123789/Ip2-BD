package poo.negocios.beans.sidronio;

public class PosGraduacao {

	private String nome;
	private String area;
	private String especialidade;
	
	public PosGraduacao(String nome, String area, String especialidade){
		this.nome=nome;
		this.area=area;
		this.especialidade=especialidade;
	}
	
	public PosGraduacao(){
		
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

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "PosGraduacao [nome=" + nome + ", area=" + area + ", especialidade=" + especialidade + "]";
	}
	
	
}
