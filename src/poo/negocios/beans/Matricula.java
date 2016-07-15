package poo.negocios.beans;

import java.util.Calendar;

public class Matricula {
	private int codigo;
	private OfertaDisciplina oferta;
	private Aluno a;
	private int ano, semestre;
	boolean onus;
	Calendar data_matricula;

	public Matricula(OfertaDisciplina oferta, Aluno a, int ano, int semestre){
            this.setAno(ano);
            this.setSemestre(semestre);
            this.setOferta(oferta);
            this.setA(a);
	}

	public Calendar getData_matricula() {
		return data_matricula;
	}

	public void setData_matricula(Calendar data_matricula) {
		this.data_matricula = data_matricula;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setOnus(boolean value){
		this.onus = value;
	}

	public boolean haveOnus(){
		return this.onus;
	}

	public OfertaDisciplina getOferta() {
		return oferta;
	}
	public void setOferta(OfertaDisciplina oferta) {
		this.oferta = oferta;
	}
	public Aluno getA() {
		return a;
	}
	public void setA(Aluno a) {
		this.a = a;
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

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", oferta=" + oferta + ", a=" + a + ", ano=" + ano + ", semestre=" + semestre + ", onus=" + onus + ", data_matricula=" + data_matricula + '}';
    }






}
