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
	
        
    public Aluno(Curso curso, Graduacao graduacao,Semestre semestre, String pNome, String uNome, String cpf) throws CPFInvalidoException {
	super(pNome, uNome, cpf);
	this.setCurso(curso);
	this.setGraduacao(graduacao);
	this.setSemestre(semestre);

		// TODO Auto-generated constructor stub
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


	
}
