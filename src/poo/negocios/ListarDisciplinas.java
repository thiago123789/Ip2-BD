package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Stream;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaCursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaCursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.DisciplinaCurso;
import poo.negocios.beans.PreRequisito;

public class ListarDisciplinas {
	private static ListarDisciplinas instance;
	private IDisciplinaDAO repositorio;
	private IPreRequisitoDAO req;
	private ICursoDAO curso;	
	private IDisciplinaCursoDAO disC;

	public static ListarDisciplinas getInstance(){
		if(instance == null){
			instance = new ListarDisciplinas();
		}
		return instance;
	}

	private ListarDisciplinas(){
		repositorio = DisciplinaDAO.getInstance();
		curso = CursoDAO.getInstance();
		req = PreRequisitoDAO.getInstance();
		disC = DisciplinaCursoDAO.getInstance();
	}
	
	public ArrayList<Disciplina> listarDisciplinasPorCurso(String nomeCurso){
		ArrayList<Disciplina> retorno = new ArrayList<Disciplina>();
		ArrayList<Curso> listaDeCursos = curso.listar();
		ArrayList<DisciplinaCurso> listaDisC = disC.litar();
		ArrayList<Disciplina> listDisciplina = repositorio.listar();
		ArrayList<String> codigosDis = new ArrayList<String>();
		Stream<Curso> streamCursos = listaDeCursos.stream();
		Integer idCurso = streamCursos.filter(c -> c.getNome().equals(nomeCurso)).mapToInt(c -> c.getCodigo()).sum();
		listaDisC.forEach(d -> {
			if(d.getCodidgoCurso() == idCurso){
				if(!codigosDis.contains(d.getCodigoDisciplina())){
					codigosDis.add(d.getCodigoDisciplina());
				}
			}
		});
		codigosDis.forEach(s -> {
			listDisciplina.forEach(d -> {
				if(d.getCodigo().equals(s)){
					if(!retorno.contains(d)){
						retorno.add(d);
					}
				}
			});
		});
		return retorno;
	}
	

	public String[] listarCodigo(){
		ArrayList<Disciplina> list = repositorio.listar();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] codigos = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
			aux[i] = a;
			codigos[i] = a.getCodigo();
			i++;
		}
		return codigos;
	}

	public ArrayList<String> listarArrayCodigos(){
		ArrayList<Disciplina> list = repositorio.listar();
		ArrayList<String> listS = new ArrayList<String>();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] codigos = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
			listS.add(a.getCodigo());
		}
		return listS;
	}

	public String[] listarNomes(){
		ArrayList<Disciplina> list = repositorio.listar();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] nomes = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
			aux[i] = a;
			nomes[i] = a.getNome();
			i++;
		}
		return nomes;
	}

	public String mostrarDetalhes(Disciplina a){
		String detalhes = "";
		detalhes += "Codigo: "+a.getCodigo();
		detalhes += "\nNome: "+a.getNome();
		detalhes += "\nCarga Horaria: "+a.getCargaHoraria();
		return detalhes;
	}

	//INCOMPLETO
	public String[] listarCodigosPreRequisitos(String cod) throws SQLException{
		ArrayList<PreRequisito> a = req.listar();
		String[] aux = new String[a.size()];

		return aux;
	}

	//INCOMPLETO
	public String[] listarNomesPreRequisitos(String cod){
		String[] aux = new String[10];

		return aux;
	}

}
