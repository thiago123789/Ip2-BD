package poo.negocios.beans;

public class HistoricoAluno {
	private String aluno;
	private String cpf_aluno;
	private String codigo_dis, nome_disciplina;
	private int ano, semestre;
	private float va1, va2, va3, nota_final, media_final;
	private String situacao;

	public HistoricoAluno(String aluno, String cpf, String codigo, String nomeD,
			float va1, float va2, float va3, float nota_final, float media_final, String situacao){
		this.setAluno(aluno);
		this.setCpf_aluno(cpf);
		this.setCodigo_dis(codigo);
		this.setNome_disciplina(nomeD);
		this.setVa1(va1);
		this.setVa2(va2);
		this.setVa3(va3);
		this.setNota_final(nota_final);
		this.setMedia_final(media_final);
		this.setSituacao(situacao);
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getCpf_aluno() {
		return cpf_aluno;
	}

	public void setCpf_aluno(String cpf_aluno) {
		this.cpf_aluno = cpf_aluno;
	}

	public String getCodigo_dis() {
		return codigo_dis;
	}

	public void setCodigo_dis(String codigo_dis) {
		this.codigo_dis = codigo_dis;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public float getVa1() {
		return va1;
	}

	public void setVa1(float va1) {
		this.va1 = va1;
	}

	public float getVa2() {
		return va2;
	}

	public void setVa2(float va2) {
		this.va2 = va2;
	}

	public float getVa3() {
		return va3;
	}

	public void setVa3(float va3) {
		this.va3 = va3;
	}

	public float getNota_final() {
		return nota_final;
	}

	public void setNota_final(float nota_final) {
		this.nota_final = nota_final;
	}

	public float getMedia_final() {
		return media_final;
	}

	public void setMedia_final(float media_final) {
		this.media_final = media_final;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}





}
