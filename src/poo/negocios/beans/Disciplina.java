package poo.negocios.beans;
import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private int codigo;
	private ArrayList<Disciplina> preRequisito, coRequisito;
	private ArrayList<Professor> professores;
	private boolean optativa, obrigatoria, graduacao, posGraducao;
	private Curso curso;
	private String area, trilha;
	private Horario horario;
	
	public Disciplina(String nome, int codigo, 
			ArrayList<Disciplina> preRequisito, 
			ArrayList<Disciplina> coRequisito, ArrayList<Professor> professores, 
			String trilha, String area, Curso curso, int tipoDisciplina, 
			int tipoDisciplinaCurso, Horario horario){
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setPreRequisito(preRequisito);
		this.setCoRequisito(coRequisito);
		this.setProfessores(professores);
		this.setTipoDisciplina(tipoDisciplina);
		this.setTipoDisciplinaCurso(tipoDisciplinaCurso);	
		this.setTrilha(trilha);
		this.setCurso(curso);
		this.setArea(area);
		this.setHorario(horario);
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public boolean getGraducao(){
		return this.graduacao;
	}
	
	public boolean getPosGraduacao(){
		return this.posGraducao;
	}
	
	public void setTrilha(String trilha){
		this.trilha = trilha;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	
	public String getArea(){
		return this.area;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0){
			this.codigo = codigo;
		}	
	}

	public ArrayList<Disciplina> getPreRequisito() {
		return preRequisito;
	}

	public void setPreRequisito(ArrayList<Disciplina> preRequisito) {
		if(preRequisito != null){
			this.preRequisito = preRequisito;
		}
	}

	public ArrayList<Disciplina> getCoRequisito() {
		return coRequisito;
	}

	public void setCoRequisito(ArrayList<Disciplina> coRequisito) {
		if(coRequisito != null){
			this.coRequisito = coRequisito;
		}
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		if(!professores.isEmpty()){
			this.professores = professores;
		}
	}
		
}
