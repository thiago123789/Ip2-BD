package poo.negocios.beans;

import java.util.Calendar;

import poo.excecoes.CPFInvalidoException;

public class Aluno extends Pessoa{
	private Curso curso;
	private Graduacao graduacao;
	private OfertaDisciplina ofertaDisciplina;
	private String turno;
	private int anoEntrada, semestreEntrada;
	private Historico historico;
	private boolean prioridade;
	
        
    public Aluno(Curso curso, String pNome, 
    		String uNome, String cpf, String turno, int anoEntrada, 
    		int semestreEntrada, boolean prioridade, boolean sexo, String senha, String email, 
    		Endereco endereco, Calendar nascimento) throws CPFInvalidoException {
	super(pNome, uNome, cpf, sexo, senha, email, endereco, 0, nascimento);
	this.setCurso(curso);
	this.setGraduacao(graduacao);
	this.setSemestre(ofertaDisciplina);
	this.setAnoEntrada(anoEntrada);
	this.setTurno(turno);
	this.setHistorico(historico);
	this.setSemestreEntrada(semestreEntrada);
	this.setPrioridade(prioridade);
	}
    
public void setCurso(Curso curso){
	if(curso!= null){
		this.curso = curso;
	}
}

public void setGraduacao(Graduacao graduacao){
	if(graduacao != null){
		this.graduacao = graduacao;
	}
}

public void setSemestre(OfertaDisciplina ofertaDisciplina){
	if(ofertaDisciplina != null){
		this.ofertaDisciplina = ofertaDisciplina;
	}
}
public Curso getCurso(){
	return this.curso;
}

public Graduacao getGraduacao(){
	return this.graduacao;
}

public OfertaDisciplina getSemestre(){
	return this.ofertaDisciplina;
}

public String getTurno() {
	return turno;
}

public void setTurno(String turno) {
	if(turno != null){
	this.turno = turno;
	}
}

public int getAnoEntrada() {
	return anoEntrada;
}

public void setAnoEntrada(int anoEntrada) {
	if(anoEntrada >= 2000){
	this.anoEntrada = anoEntrada;
	}
}

public int getSemestreEntrada() {
	return semestreEntrada;
}

public void setSemestreEntrada(int semestreEntrada) {
	if(semestreEntrada >= 1 && semestreEntrada <= 2){
	this.semestreEntrada = semestreEntrada;
	}
}

public Historico getHistorico() {
	return historico;
}

public void setHistorico(Historico historico) {
	if(ofertaDisciplina != null){
	this.historico = historico;
	}
}

public boolean getPrioridade() {
	
		return this.prioridade;
	
}

public void setPrioridade(boolean prioridade) {
	this.prioridade = prioridade;
}


	
}
