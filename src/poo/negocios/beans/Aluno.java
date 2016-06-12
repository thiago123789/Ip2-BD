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
	private boolean prioridade, monitor, bolsista, voluntario, desistiu;
	private float media_geral;

	public Aluno(String cpf, boolean prioridade, Curso curso, int ano_entrada, int semestre_entrada,
			String turno, boolean monitor, boolean voluntario, boolean bolsista,
			boolean desistiu) throws CPFInvalidoException{
		super();
		this.setCpf(cpf);
		this.setPrioridade(prioridade);
		this.setCurso(curso);
		this.setAnoEntrada(ano_entrada);
		this.setSemestreEntrada(semestre_entrada);
		this.setTurno(turno);
		this.setMonitor(monitor);
		this.setVoluntario(voluntario);
		this.setBolsista(bolsista);
		this.setDesistiu(desistiu);
	}


	public Aluno(Curso curso, String pNome,
			String uNome, String cpf, String turno, int anoEntrada,
			int semestreEntrada, boolean prioridade, boolean sexo, String senha, String email,
			Endereco endereco, boolean monitor, boolean bolsista,
			boolean voluntario, boolean desistiu, Calendar nascimento) throws CPFInvalidoException {
		super(pNome, uNome, cpf, sexo, senha, email, endereco, 0, nascimento);
		this.setCurso(curso);
		this.setGraduacao(graduacao);
		this.setSemestre(ofertaDisciplina);
		this.setAnoEntrada(anoEntrada);
		this.setTurno(turno);
		this.setHistorico(historico);
		this.setSemestreEntrada(semestreEntrada);
		this.setPrioridade(prioridade);
		this.setMonitor(monitor);
		this.setBolsista(bolsista);
		this.setVoluntario(voluntario);
		this.setDesistiu(desistiu);

	}

	public Aluno(float media_geral){
		super();
		this.setMedia_geral(media_geral);
	}


	public Aluno(String cpf) throws CPFInvalidoException{
		super();
		this.setCpf(cpf);
	}


	public float getMedia_geral() {
		return media_geral;
	}



	public void setMedia_geral(float media_geral) {
		this.media_geral = media_geral;
	}



	public boolean isBolsista() {
		return bolsista;
	}



	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}



	public boolean isVoluntario() {
		return voluntario;
	}



	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}



	public boolean isDesistiu() {
		return desistiu;
	}



	public void setDesistiu(boolean desistiu) {
		this.desistiu = desistiu;
	}



	public boolean isMonitor() {
		return monitor;
	}



	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
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
