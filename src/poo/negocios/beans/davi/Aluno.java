//CLASSE P/ DAVI
package poo.negocios.beans.davi;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.sidronio.Curso;
import poo.negocios.beans.sidronio.Graduacao;
import poo.negocios.beans.veneranda.Semestre;

public class Aluno extends Pessoa{
	private Curso curso;
	private Graduacao graduacao;
	private Semestre semestre;
	private String turno;
	private int anoEntrada, semestreEntrada;
	private Historico historico;
	private boolean prioridade;
	
        
    public Aluno(Curso curso, Graduacao graduacao,Semestre semestre, String pNome, 
    		String uNome, String cpf, String turno, int anoEntrada, 
    		int semestreEntrada, Historico historico,
    		boolean prioridade, String sexo, String senha, String email, Endereco endereco) throws CPFInvalidoException {
	super(pNome, uNome, cpf, sexo, senha, email, endereco);
	this.setCurso(curso);
	this.setGraduacao(graduacao);
	this.setSemestre(semestre);
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

public void setSemestre(Semestre semestre){
	if(semestre != null){
		this.semestre = semestre;
	}
}
public Curso getCurso(){
	return this.curso;
}

public Graduacao getGraduacao(){
	return this.graduacao;
}

public Semestre getSemestre(){
	return this.semestre;
}

public String getTurno() {
	return turno;
}

public void setTurno(String turno) {
	if(semestre != null){
	this.turno = turno;
	}
}

public int getAnoEntrada() {
	return anoEntrada;
}

public void setAnoEntrada(int anoEntrada) {
	if(semestre != null){
	this.anoEntrada = anoEntrada;
	}
}

public int getSemestreEntrada() {
	return semestreEntrada;
}

public void setSemestreEntrada(int semestreEntrada) {
	if(semestre != null){
	this.semestreEntrada = semestreEntrada;
	}
}

public Historico getHistorico() {
	return historico;
}

public void setHistorico(Historico historico) {
	if(semestre != null){
	this.historico = historico;
	}
}

public boolean setPrioridade() {
	if(semestre != null){
	return prioridade;
	}
}

public void setPrioridade(boolean prioridade) {
	this.prioridade = prioridade;
}


	
}