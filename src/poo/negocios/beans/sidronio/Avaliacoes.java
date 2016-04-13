package poo.negocios.beans.sidronio;

public class Avaliacoes {

	private int nota;
	private String avaliacao;
	
	public Avaliacoes(int nota, String avaliacao){
		this.nota=nota;
		this.avaliacao=avaliacao;
	}
	
	public Avaliacoes(){
		
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "Avaliacoes [nota=" + nota + ", avaliacao=" + avaliacao + "]";
	}
	
	
}
