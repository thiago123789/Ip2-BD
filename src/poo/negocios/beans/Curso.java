package poo.negocios.beans;

public class Curso {
	private String nome;
	private Aluno [] alunos;
	private Disciplina [] disciplinas;
	
	public Curso(String nome)
	{
		this.nome=nome;;
	}
	
	public Curso(){
		
	}
	
	public void setNome(String nome)
	{
		if(nome != null)
		{
			this.nome = nome;
		}	
	}
	
	
	public String getNome()
	{
		return this.nome;
	}

	public Aluno[] getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + "]"; 
	}
	
	
	
	
}
