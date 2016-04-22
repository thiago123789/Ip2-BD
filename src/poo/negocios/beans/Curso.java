package poo.negocios.beans;

public class Curso {
	private int codigo;
	private String nome;
	private Aluno [] alunos;
	private Disciplina [] disciplinas;
	
	public Curso(int codigo, String nome)
	{
		this.setCodigo(codigo);
		this.nome=nome;
	}
	
	public Curso(){
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
