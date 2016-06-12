package poo.negocios.beans;

public class Localizacao {
	private int codigo;
	private int sala;
	private String predio;

	public Localizacao(String predio, int sala){
		this.setPredio(predio);
		this.setSala(sala);
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		if(sala > 0){
			this.sala = sala;
		}
	}

	public void setCodigo(int codigo){
		if(codigo > 0){
			this.codigo = codigo;
		}
	}

	public int getCodigo(){
		return this.codigo;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		if(predio != null){
			this.predio = predio;
		}
	}






}
