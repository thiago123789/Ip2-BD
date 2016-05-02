package poo.negocios.beans;

import java.util.ArrayList;

public class Departamento {
        private int id;
	private String nome;
	private String sigla;
	private ArrayList<Curso> cursos;
	private ArrayList<Funcionario> funcionarios;
	private Professor diretor,vice;
	
	public Departamento(String nome){
		this.setNome(nome);
	}
	
        public Departamento(String nome, String sigla){
            this.setNome(nome);
            this.setSigla(sigla);
        }
        
	public Departamento(){
		
	}
	
	public Departamento(String nome, String sigla, Professor diretor, Professor vice,
			ArrayList<Curso> cursos, ArrayList<Funcionario> funcionarios){
		this.setNome(nome);
		this.setDiretor(diretor);;
		this.setVice(vice);
		this.setSigla(sigla);
		this.setFuncionarios(funcionarios);
		this.setCursos(cursos);
	}
	
	public void setId(int id){
            if(id>=1){
                this.id = id;
            }
        }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public ArrayList<Curso> getCursos(){
		return this.cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	

	public Professor getDiretor() {
		return diretor;
	}

	public void setDiretor(Professor diretor) {
		this.diretor = diretor;
	}

	public Professor getVice() {
		return vice;
	}

	public void setVice(Professor vice) {
		this.vice = vice;
	}

	/*
	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", sigla=" + sigla + ", cursos=" + Arrays.toString(cursos) + "]";
	}
	 */
	

	
	
	
	
}
