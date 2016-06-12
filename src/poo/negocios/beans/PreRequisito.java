package poo.negocios.beans;

public class PreRequisito {
	private Disciplina disciplina;
	private Disciplina preRequisito;

	public PreRequisito(Disciplina disciplina, Disciplina preRequisito){
		this.setDisciplina(disciplina);
		this.setPreRequisito(preRequisito);
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Disciplina getPreRequisito() {
		return preRequisito;
	}
	public void setPreRequisito(Disciplina preRequisito) {
		this.preRequisito = preRequisito;
	}
}
