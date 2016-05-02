package poo.negocios;

import java.util.ArrayList;

import poo.excecoes.DisciplinaJaExisteException;
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
        
    public FachadaSistema(){
    	addDisciplina = new CadastroDisciplina();
    	addTeacher = new CadastroProfessor();
        list = new ListarDisciplinas();
        listCurso = new ListarCursos();
        cadDepat = new CadastroDepartamento();
        listDepat = new ListarDepartamentos();
        cadCurso = new CadastroCurso();
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
	
	
	
	
	
	
	
}
