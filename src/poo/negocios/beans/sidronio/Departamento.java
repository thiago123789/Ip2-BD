package poo.negocios.beans.sidronio;

public class Departamento {

	private String nome;
	private int codigo;
	
	public Departamento(){
		
	}
	
	public Departamento(String nome, int codigo){
		this.nome=nome;
		this.codigo=codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", codigo=" + codigo + "]";
	}
	
	
}
