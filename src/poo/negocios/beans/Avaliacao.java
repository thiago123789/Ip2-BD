package poo.negocios.beans;

import java.util.Arrays;

public class Avaliacao {

	private int notas[];
	private String descricao;
	private boolean anonima;
	private String nome_aluno;
	
	public Avaliacao(String descricao,boolean anonima, String nome_aluno ){
		this.descricao=descricao;
		this.anonima=anonima;
		this.nome_aluno=nome_aluno;
		this.notas= new int[5];
	}
	
	public Avaliacao(){
		
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAnonima() {
		return anonima;
	}

	public void setAnonima(boolean anonima) {
		this.anonima = anonima;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	@Override
	public String toString() {
		return "Avaliacoes [notas=" + Arrays.toString(notas) + ", descricao=" + descricao + ", anonima=" + anonima
				+ ", nome_aluno=" + nome_aluno + "]";
	}
	
	





	
}
