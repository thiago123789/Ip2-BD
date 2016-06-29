package poo.negocios.beans;

import java.util.ArrayList;

public class DisciplinaMatriculada{
	
	private Aluno aluno;
	private Disciplina disciplina;
	private float aV1, aV2, aV3, pFinal, media;
	private String situacao;
        private int faltas;
	
	public DisciplinaMatriculada(int codigo, Aluno aluno, float av1, float av2,
			float av3, float pfinal, float media) {
		this.setSituacao(situacao);
		this.setaV1(av1);
		this.setaV2(av2);
		this.setaV3(av3);
		this.setAluno(aluno);
		this.setpFinal(pfinal);
		this.setMedia(media);
	}
        
        public int getFaltas(){
            return this.faltas;
        }

        public void setFaltas(int faltas){
            if(faltas >= 0){
                this.faltas = faltas;
            }
        }
        
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public float getaV1() {
		return aV1;
	}

	public void setaV1(float aV1) {
		this.aV1 = aV1;
	}

	public float getaV2() {
		return aV2;
	}

	public void setaV2(float aV2) {
		this.aV2 = aV2;
	}

	public float getaV3() {
		return aV3;
	}

	public void setaV3(float aV3) {
		this.aV3 = aV3;
	}

	public float getpFinal() {
		return pFinal;
	}

	public void setpFinal(float pFinal) {
		this.pFinal = pFinal;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
	
	
}
