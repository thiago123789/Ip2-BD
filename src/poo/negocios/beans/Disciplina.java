package poo.negocios.beans;
import java.io.File;
import java.util.ArrayList;

public class Disciplina implements Comparable{
	private String nome;
	private String codigo;
	private ArrayList<Disciplina> preRequisito, coRequisito;
	private String tipo_disciplina;
	private Curso curso;
	private Trilha trilha;
	private int cargaHoraria;
	private File ementa;
	private int periodoDisciplina;

	public Disciplina(String codigo, String nome, int carga){
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCargaHoraria(carga);
	}

	public Disciplina(String nome, Trilha trilha, Curso curso, String tipo_disciplina,
			int tipoDisciplinaCurso){
		this.setTipo_disciplina(tipo_disciplina);
		this.setNome(nome);
		this.setTrilha(trilha);
		this.setCurso(curso);
		this.setCodigo();
	}

	public Disciplina(String nome, int requisito,
			ArrayList<Disciplina> preRequisito, int corequisito,
			ArrayList<Disciplina> coRequisito,
			Trilha trilha, Curso curso, int tipoDisciplina,
			int tipoDisciplinaCurso){
		this.setNome(nome);
		if(requisito == 1){
			this.setPreRequisito(preRequisito);
		}
		if(corequisito == 1){
			this.setCoRequisito(coRequisito);
		}
		this.setTrilha(trilha);
		this.setCurso(curso);
		this.setCodigo();
	}

	public Disciplina(String codigo){
		this.setCodigo();
	}

	public int getPeriodoDisciplina() {
		return periodoDisciplina;
	}


	public void setPeriodoDisciplina(int periodoDisciplina) {
		this.periodoDisciplina = periodoDisciplina;
	}

	public String getTipo_disciplina() {
		return tipo_disciplina;
	}

	public void setTipo_disciplina(String tipo_disciplina) {
		this.tipo_disciplina = tipo_disciplina;
	}

	public File getEmenta() {
		return ementa;
	}

	public void setEmenta(File ementa) {
		this.ementa = ementa;
	}

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}


	public Disciplina(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}


	public int getCargaHoraria(){
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int carga){
		this.cargaHoraria = carga;
	}

	public Trilha getTrilha(){
		return this.trilha;
	}

	public void setTrilha(Trilha trilha){
		this.trilha = trilha;
	}

	public void setCurso(Curso curso){
		this.curso = curso;
	}

	public Curso getCurso(){
		return this.curso;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null){
			this.nome = nome;
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	private void setCodigo() {
		String codigoFinal = "";
		boolean espace = false;
		char[] temp = this.getNome().toCharArray();
		for(int i = 0; i < temp.length; i++){
			if(i >= 0 && i <= 2){
				codigoFinal+=temp[i];
			}else if(temp[i] == ' '){
				if(i+2 <= temp.length-1){
					if(temp[i+2] == ' ' || temp[i+3] == ' '){
						espace = true;
						codigoFinal+=".";
						if(temp[i+2] == ' '){
							i+=2;
						}else if(temp[i+3] == ' '){
							i+=3;
						}
					}else{
						espace = true;
						codigoFinal+=".";
					}
				}else{
					codigoFinal+="."+temp[i+1];
				}
			}else if(espace){
				int j = i, k = 0;
				while(j<temp.length && k < 3){
					codigoFinal+=temp[j];
					j++;
					k++;

				}
				if(temp[temp.length-1] == '1' || temp[temp.length-1] == '2'){
					codigoFinal+= "."+temp[temp.length-1];
				}
				break;
			}
		}
		this.codigo = codigoFinal.toUpperCase();
	}

	public ArrayList<Disciplina> getPreRequisito() {
		return this.preRequisito;
	}

	public void setPreRequisito(ArrayList<Disciplina> preRequisito1) {
		if(preRequisito1 != null){
			this.preRequisito = preRequisito1;
		}
	}

	public ArrayList<Disciplina> getCoRequisito() {
		return this.coRequisito;
	}

	public void setCoRequisito(ArrayList<Disciplina> coRequisito) {
		if(coRequisito != null){
			this.coRequisito = coRequisito;
		}
	}

	public String toString(){
		String resultado = "";
		resultado += "COD: "+this.getCodigo()+"\nNome: "+this.getNome()+"\nCurso: "+this.getCurso().getNome()+"\nTipo: "+this.getTipo_disciplina();
		return resultado;
	}

	public boolean equals(Object ob){
		boolean igual = false;
		if(ob instanceof Disciplina){
			Disciplina aux = (Disciplina) ob;
			if(this.getCodigo().equals(aux.getCodigo())){
				igual = true;
			}
		}
		return igual;
	}


	@Override
	public int compareTo(Object ob) {
		int igual = 0;
		if(ob instanceof Disciplina){
			if(this.equals(ob)){
				igual = 1;
			}
		}
		return igual;
	}

}
