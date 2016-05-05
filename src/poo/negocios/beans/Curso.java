package poo.negocios.beans;

public class Curso {
	private int codigo;
	private String nome;
	private Aluno [] alunos;
	private Disciplina [] disciplinas;
	private boolean graduacao, posgraduacao;
        private int ano_inicio;
	
	public Curso(int codigo, String nome, int ano_inicio)
	{
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	
	public Curso(String nome, boolean graducao)
	{
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setGraduacao(graduacao);
		this.setPosGraducao(!graduacao);	
	}
        
        public int getAnoInicio(){
            return this.ano_inicio;
        }
	
        public void setAnoInicio(int ano){
            this.ano_inicio = ano;
        }
        
	public boolean getPosGraduacao(){
		return this.posgraduacao;
	}
	
	public boolean getGraducao(){
		return this.graduacao;
	}
	
	public void setGraduacao(boolean b){
		this.graduacao = b;
	}
	
	public void setPosGraducao(boolean c){
		this.posgraduacao = c;
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
