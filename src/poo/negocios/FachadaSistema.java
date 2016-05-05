package poo.negocios;

import java.util.ArrayList;

import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Disciplina;

public class FachadaSistema {
	public static FachadaSistema instance;
	private CadastroDisciplina addDisciplina;
	private CadastroProfessor addTeacher;
	private ListarDisciplinas list;
	private ListarCursos listCurso;
    private CadastroDepartamento cadDepat;
    private ListarDepartamentos listDepat;
    private CadastroCurso cadCurso;
    private BuscaAvancada advanced;
    private InfoUsuario info;
    private CadastroAluno cadAlu;
    private Auxiliar aux;
    private ListarPreRequisitos preList;
    private DetalhesDisciplina details;
    
    public FachadaSistema(){
    	addDisciplina = new CadastroDisciplina();
    	addTeacher = new CadastroProfessor();
        list = new ListarDisciplinas();
        listCurso = new ListarCursos();
        cadDepat = new CadastroDepartamento();
        listDepat = new ListarDepartamentos();
        cadCurso = new CadastroCurso();
        advanced = new BuscaAvancada();
        info = new InfoUsuario();
        cadAlu = new CadastroAluno();
        aux = new Auxiliar();
        preList = new ListarPreRequisitos();
        details = new DetalhesDisciplina();
    }

	public static FachadaSistema getInstance(){
		if(instance == null){
			instance = new FachadaSistema();
		}
		return instance;
	}

	public void inserirDisciplina(Disciplina a)
			throws DisciplinaJaExisteException {
		addDisciplina.inserirDisciplina(a);
	}

	public String[] listarCodigo() {
		return list.listarCodigo();
	}

	public ArrayList<String> listarArrayCodigos() {
		return list.listarArrayCodigos();
	}

	public String[] listarNomes() {
		return list.listarNomes();
	}

	public String[] listarCursosPorNome() {
		return listCurso.listarPorNome();
	}

	public ArrayList<String> listarCursosPorNomeList() {
		return listCurso.listarPorNomeList();
	}

	public void cadastraDepat(Departamento depat) {
		cadDepat.cadastraDepat(depat);
	}

	public String[] listaDepartamentosPorNome() {
		return listDepat.listaDepartamentosPorNome();
	}

	public ArrayList<String> listaDepartamentosPorNomeList() {
		return listDepat.listaDepartamentosPorNomeList();
	}

	public void cadastroCurso(Curso curso, Departamento depat) {
		cadCurso.cadastroCurso(curso, depat);
	}

	
	/*
	 * FALTA EDITAR ESTE METODO PARA MOSTRAR APENAS DISCIPLINAS DO CURSO NO QUAL A PESSOA QUE ESTÁ PESQUISANDO PERTENCE
	 */
	public ArrayList<Disciplina> searchAdvanced(String nom) {
//		int cursoUser = info.cursoUsuario(cpf);
//		if()
		return advanced.searchAdvanced(nom);
	}

	public void cadastraAluno(Aluno a) {
		cadAlu.cadastraAluno(a);
	}

	public int[] retornarAnosAteAtual() {
		return aux.retornarAnosAteAtual();
	}

	public ArrayList<Integer> retornarAnosAteAtualList() {
		return aux.retornarAnosAteAtualList();
	}

	public int okcancel(String theMessage, String titulo) {
		return aux.okcancel(theMessage, titulo);
	}

	public ArrayList<String> listarCodigosPreRequisitos(String cod) {
		return preList.listarCodigosPreRequisitos(cod);
	}

	public ArrayList<String> listarNomesPreRequisitos(String cod) {
		return preList.listarNomesPreRequisitos(cod);
	}

	public String detalheDisciplina(String codig) {
		return details.detalheDisciplina(codig);
	}

	public String[] listarPorNome() {
		return listCurso.listarPorNome();
	}

	public ArrayList<String> listarPorNomeList() {
		return listCurso.listarPorNomeList();
	}

	public int anoInicioCurso(String nomeCurso) {
		return listCurso.anoInicioCurso(nomeCurso);
	}

	public ArrayList<Integer> retornarAnosAPartirDeList(int inicio) {
		return aux.retornarAnosAPartirDeList(inicio);
	}

	public int[] retornarAnosAPartirDe(int inicio) {
		return aux.retornarAnosAPartirDe(inicio);
	}
	
	
	
	
	
	
	
	
	
	
}
