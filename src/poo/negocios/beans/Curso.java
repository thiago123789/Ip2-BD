package poo.negocios.beans;

public class Curso {
	private int codigo;
	private String nome;
	private Aluno [] alunos;
	private Disciplina [] disciplinas;
	private boolean graduacao, posgraduacao;
        private int ano_inicio;
    private Departamento depat;
    private Professor coordenador, vice;
    
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
	
	
	
	public int getAno_inicio() {
		return ano_inicio;
	}

	public void setAno_inicio(int ano_inicio) {
		if(ano_inicio >= 1900){
			this.ano_inicio = ano_inicio;
		}
	}

	public void setCoordenador(Professor a){
		if(a != null){
			this.coordenador = a;
		}
	}
	
	public void setVice(Professor a){
		if(a != null){
			this.vice = a;
		}
	}
	
	public Professor getCoordenador(){
		return this.coordenador;
	}
	
	public Professor getVice(){
		return this.vice;
	}
	
	public Departamento getDepat(){
		return this.depat;
	}
        
	public void setDepat(Departamento depat){
		if(depat != null){
			this.depat = depat;
		}
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
