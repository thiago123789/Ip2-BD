package poo.negocios.beans;
import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String codigo;
	private Disciplina preRequisito1, preRequisito2,preRequisito3, preRequisito4, coRequisito;
//	private Disciplina[] preReq;
	private boolean optativa, obrigatoria, graduacao, posGraducao;
	private Curso curso;
	private Trilha trilha;
	private int cargaHoraria;

	public Disciplina(String nome, int requisito,
			Disciplina preRequisito1,Disciplina preRequisito2,Disciplina preRequisito3,Disciplina preRequisito4, int corequisito,
			Disciplina coRequisito, 
			Trilha trilha, Curso curso, int tipoDisciplina, 
			int tipoDisciplinaCurso){
		this.setNome(nome);
		if(requisito == 1){
			this.setPreRequisito(preRequisito1);
			this.setPreRequisito2(preRequisito2);
			this.setPreRequisito3(preRequisito3);
			this.setPreRequisito4(preRequisito4);
		}
		if(corequisito == 1){
			this.setCoRequisito(coRequisito);
		}
		this.setTipoDisciplina(tipoDisciplina);
		this.setTipoDisciplinaCurso(tipoDisciplinaCurso);	
		this.setTrilha(trilha);
		this.setCurso(curso);
		this.setCodigo();
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

	public boolean getGraducao(){
		return this.graduacao;
	}

	public boolean getPosGraduacao(){
		return this.posGraducao;
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

	public void setTipoDisciplinaCurso(int op){
		if(op == 0){
			this.setGraduacao(true);
			this.setPosGraduacao(false);
		}else{
			this.setGraduacao(false);
			this.setPosGraduacao(true);
		}
	}

	private void setGraduacao(boolean value){
		this.graduacao = value;
	}

	private void setPosGraduacao(boolean value){
		this.posGraducao = value;
	}

	public boolean getOptativa(){
		return this.optativa;
	}

	public boolean getObrigatoria(){
		return this.obrigatoria;
	}

	//SE FOR O É OBRIGATORIA SE FOR QUALQUER OUTRO VALOR SERÁ OPTATIVA;
	public void setTipoDisciplina(int op){
		if(op == 0){
			this.setObrigatoria(true);
			this.setOptativa(false);
		}else{
			this.setObrigatoria(false);
			this.setOptativa(true);
		}
	}

	private void setOptativa(boolean value){
		this.optativa = value;
	}

	private void setObrigatoria(boolean value){
		this.obrigatoria = value;
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

	private void setCodigo(String codigo){
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

//		codigoFinal+="-";
//		if(this.getGraducao()){
//			codigoFinal+="GRA";
//		}else{
//			codigoFinal+="POS";
//		}
//		codigoFinal+="-";
//		if(this.getObrigatoria()){
//			codigoFinal+="OBG";
//		}else{
//			codigoFinal+="OPT";
//		}
		this.codigo = codigoFinal.toUpperCase();
	}

	public Disciplina getPreRequisito() {
		return this.preRequisito1;
	}

	public void setPreRequisito(Disciplina preRequisito1) {
		if(preRequisito1 != null){
			this.preRequisito1 = preRequisito1;
		}
	}

	public Disciplina getCoRequisito() {
		return this.coRequisito;
	}

	public void setCoRequisito(Disciplina coRequisito) {
		if(coRequisito != null){
			this.coRequisito = coRequisito;
		}
	}

	public String toString(){
		String resultado = "";
		resultado += "COD: "+this.getCodigo()+"\nNome: "+this.getNome()+"\nCurso: "+this.getCurso().getNome()+"\nTipo: ";
		if(this.getGraducao()){
			if(this.getObrigatoria()){
				resultado += "Gradução / Obrigatoria";
			}else{
				resultado += "Gradução / Optativa";
			}
		}else{
			resultado += "Pos-graducao";
		}
		
		if(this.getPreRequisito() != null || this.getPreRequisito2() != null || this.getPreRequisito3() != null || this.getPreRequisito4() != null){
			resultado += "\nPre-requisitos\\/\n";
			if(this.getPreRequisito() != null){
				resultado += this.preRequisito1.getCodigo()+"\n";
			}
			if(this.getPreRequisito2() != null){
				resultado += this.preRequisito2.getCodigo()+"\n";
			}
			if(this.getPreRequisito3() != null){
				resultado += this.preRequisito3.getCodigo()+"\n";
			}
			if(this.getPreRequisito4() != null){
				resultado += this.preRequisito4.getCodigo()+"\n";
			}
//			resultado += this.preRequisito2.getCodigo()+"\n";
//			resultado += this.preRequisito3.getCodigo()+"\n";
//			resultado += this.preRequisito4.getCodigo()+"\n";
		}else{
			resultado += "\nPre-requisitos\\/\nNone";
		}


		return resultado;
	}


	public Disciplina getPreRequisito2() {
		return this.preRequisito2;
	}


	public void setPreRequisito2(Disciplina preRequisito2) {
		this.preRequisito2 = preRequisito2;
	}


	public Disciplina getPreRequisito3() {
		return this.preRequisito3;
	}


	public void setPreRequisito3(Disciplina preRequisito3) {
		this.preRequisito3 = preRequisito3;
	}


	public Disciplina getPreRequisito4() {
		return this.preRequisito4;
	}


	public void setPreRequisito4(Disciplina preRequisito4) {
		this.preRequisito4 = preRequisito4;
	}



}
