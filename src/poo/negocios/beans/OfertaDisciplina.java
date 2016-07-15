package poo.negocios.beans;

import java.util.ArrayList;

public class OfertaDisciplina {
	private int codigo;
	private Disciplina disciplina;
	private ArrayList<Horario> horarios;
	private ArrayList<Professor> professores;
	private int ano, semestre;
	private Localizacao local;
	private Aluno monitor;
	private Curso curso;

	public OfertaDisciplina(int codigo, Disciplina disciplina, int ano, int semetre, Localizacao local, Aluno monitor){
		this.setCodigo(codigo);
		this.setDisciplina(disciplina);
		this.setAno(ano);
		this.setSemestre(semetre);
		this.setLocal(local);
                this.setMonitor(monitor);
	}

        public OfertaDisciplina(){

        }

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		if(horarios != null){
			this.horarios = horarios;
		}
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		if(professores != null){
			this.professores = professores;
		}
	}

	public OfertaDisciplina(int codigo){
		this.setCodigo(codigo);
	}

	public Aluno getMonitor() {
		return monitor;
	}

	public void setMonitor(Aluno monitor) {
		this.monitor = monitor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		if(disciplina != null){
			this.disciplina = disciplina;
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
//		if(this.disciplina != null){
//			if(ano >= this.getCurso().getAno_inicio()){
				this.ano = ano;
//			}
//		}
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		if(semestre == 1 || semestre == 2){
			this.semestre = semestre;
		}
	}
	
	public Localizacao getLocal() {
		return local;
	}

	public void setLocal(Localizacao local) {
		if(local != null){
			this.local = local;
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public boolean equals(Object o){
		boolean igual = false;
		if(o instanceof OfertaDisciplina){
			OfertaDisciplina aux = (OfertaDisciplina) o;
			if(this.getCodigo() == aux.getCodigo()){
				igual = true;
			}
		}
		return igual;
	}

    @Override
    public String toString() {
        return "OfertaDisciplina{" + "codigo=" + codigo + ", disciplina=" + disciplina + ", ano=" + ano + ", semestre=" + semestre + ", id=" + codigo + '}';
    }


        
        
        
        
}
