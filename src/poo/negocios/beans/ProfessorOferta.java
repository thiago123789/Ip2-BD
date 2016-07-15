package poo.negocios.beans;

public class ProfessorOferta {
	private Professor professor;
	private OfertaDisciplina offer;

	public ProfessorOferta(Professor professor, OfertaDisciplina offer){
		this.setProfessor(professor);
		this.setOffer(offer);
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public OfertaDisciplina getOffer() {
		return offer;
	}

	public void setOffer(OfertaDisciplina offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "ProfessorOferta [professor=" + professor.getCpf() + ", offer=" + offer.getCodigo() + "]";
	}



}
