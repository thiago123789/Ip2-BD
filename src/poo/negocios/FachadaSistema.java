package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Professor;

public class FachadaSistema {
	private static FachadaSistema instance;
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
    private EditarDisciplina edit;
    private ListarProfessores prof;
    private ListarLocalizacao local;

    private FachadaSistema(){
    	addDisciplina = CadastroDisciplina.getInstance();
    	addTeacher = CadastroProfessor.getInstance();
        list = ListarDisciplinas.getInstance();
        listCurso = ListarCursos.getInstance();
        cadDepat = CadastroDepartamento.getInstance();
        listDepat = ListarDepartamentos.getInstance();
        cadCurso = CadastroCurso.getInstance();
        advanced = BuscaAvancada.getInstance();
        info = InfoUsuario.getInstance();
        cadAlu = CadastroAluno.getInstance();
        aux = Auxiliar.getInstance();
        preList = ListarPreRequisitos.getInstance();
        details = DetalhesDisciplina.getInstance();
        edit = EditarDisciplina.getInstance();
        prof = ListarProfessores.getInstance();
        local = ListarLocalizacao.getInstance();
    }

	public static FachadaSistema getInstance(){
		if(instance == null){
			instance = new FachadaSistema();
		}
		return instance;
	}

	public boolean existeDisciplina(String codigo) {
		return addDisciplina.existeDisciplina(codigo);
	}

	public void inserirDisciplina(Disciplina a) throws DisciplinaJaExisteException {
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

	public String mostrarDetalhes(Disciplina a) {
		return list.mostrarDetalhes(a);
	}

	public String[] listarCodigosPreRequisitos1(String cod) throws SQLException {
		return list.listarCodigosPreRequisitos(cod);
	}

	public String[] listarNomesPreRequisitos1(String cod) {
		return list.listarNomesPreRequisitos(cod);
	}

	public String[] listarCursosPorNome() {
		return listCurso.listarCursosPorNome();
	}

	public ArrayList<String> listarCursosPorNomeList() {
		return listCurso.listarCursosPorNomeList();
	}

	public int anoInicioCurso(String nomeCurso) {
		return listCurso.anoInicioCurso(nomeCurso);
	}

	public void cadastraDepat(Departamento depat) {
		cadDepat.cadastraDepat(depat);
	}

	public String[] listaDepartamentosPorNome() throws SQLException {
		return listDepat.listaDepartamentosPorNome();
	}

	public ArrayList<String> listaDepartamentosPorNomeList() throws SQLException {
		return listDepat.listaDepartamentosPorNomeList();
	}

	public int idDepartamento(String nome) {
		return cadCurso.idDepartamento(nome);
	}

	public void cadastroCurso(Curso curso) {
		cadCurso.cadastroCurso(curso);
	}

	public ArrayList<Disciplina> searchAdvanced(String nom) {
		return advanced.searchAdvanced(nom);
	}

	public int cursoAluno(String cpf) {
		return info.cursoAluno(cpf);
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

	public ArrayList<Integer> retornarAnosAPartirDeList(int inicio) {
		return aux.retornarAnosAPartirDeList(inicio);
	}

	public int[] retornarAnosAPartirDe(int inicio) {
		return aux.retornarAnosAPartirDe(inicio);
	}

	public Disciplina buscarDisciplina(String codigo) {
		return preList.buscarDisciplina(codigo);
	}

	public Curso buscarCursoPorID(int id) {
		return details.buscarCursoPorID(id);
	}

	public Disciplina buscarDisciplinaPorCodigo(String codigo) {
		return details.buscarDisciplinaPorCodigo(codigo);
	}

	public String detalheDisciplina(String codig) {
		return details.detalheDisciplina(codig);
	}

	public ArrayList<String> listarCodigosPreRequisitos(String cod) throws SQLException {
		return preList.listarCodigosPreRequisitos(cod);
	}

	public ArrayList<String> listarNomesPreRequisitos(String cod) throws SQLException {
		return preList.listarNomesPreRequisitos(cod);
	}

	public ArrayList<Disciplina> searchAdvancedVariasChaves(ArrayList<String> chaves) {
		return advanced.searchAdvancedVariasChaves(chaves);
	}

	public ArrayList<String> listarCursosPorDepartamentoList(String depat){
		return listCurso.listarCursosPorDepartamentoList(depat);
	}

	public ArrayList<Disciplina> listarDisciplinasPorCurso(String nomeCurso) {
		return list.listarDisciplinasPorCurso(nomeCurso);
	}

	public ArrayList<Professor> listarProfessores() {
		return prof.listarProfessores();
	}

	public ArrayList<String> listaPredios() {
		return local.listaPredios();
	}

	public ArrayList<Integer> listaSalasPorPredio(String predio) {
		return local.listaSalasPorPredio(predio);
	}

	public int buscarIdLocalizacao(String predio, int sala) {
		return local.buscarIdLocalizacao(predio, sala);
	}



}
