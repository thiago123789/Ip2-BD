package poo.negocios.beans;

import java.util.ArrayList;

public class OfertaDisciplina {
	private Disciplina disciplina;
	private int ano, semestre;
	private int id;
	private Localizacao local;
	
	public OfertaDisciplina(Disciplina disciplina, int ano, int semetre, Localizacao local){
		this.setDisciplina(disciplina);
		this.setAno(ano);
		this.setSemestre(semetre);
		this.setLocal(local);
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
		if(this.disciplina != null){
			if(ano >= this.disciplina.getCurso().getAno_inicio()){
				this.ano = ano;
			}
		}
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		if(semestre == 1 || semestre == 2){
			this.semestre = semestre;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0){
			this.id = id;
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
	
	
	
}
