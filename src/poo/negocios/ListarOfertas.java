package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.HorarioDAO;
import poo.dados.DAO.HorarioOfertaDAO;
import poo.dados.DAO.LocalizacaoDAO;
import poo.dados.DAO.OfertaDisciplinaDAO;
import poo.dados.DAO.ProfessorOfertaDAO;
import poo.dados.DAO.interfaces.IAlunoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IHorarioDAO;
import poo.dados.DAO.interfaces.IHorarioOfertaDAO;
import poo.dados.DAO.interfaces.ILocalizacaoDAO;
import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.dados.DAO.interfaces.IProfessorOfertaDAO;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Horario;
import poo.negocios.beans.HorarioOferta;
import poo.negocios.beans.Localizacao;
import poo.negocios.beans.OfertaDisciplina;
import poo.negocios.beans.Professor;
import poo.negocios.beans.ProfessorOferta;

public class ListarOfertas {
	private static ListarOfertas instance;
	private IOfertaDisciplinaDAO off;
	private IDisciplinaDAO dis;
	private ILocalizacaoDAO local;
	private ICursoDAO curso;
	private IHorarioOfertaDAO horaoff;
	private IHorarioDAO hora;
	private IProfessorOfertaDAO profoff;
	private ListarProfessores list;
	private IAlunoDAO aluno;

	public static ListarOfertas getInstance(){
		if(instance == null){
			instance = new ListarOfertas();
		}
		return instance;
	}

	private ListarOfertas(){
		off = OfertaDisciplinaDAO.getInstance();
		dis = DisciplinaDAO.getInstance();
		local = LocalizacaoDAO.getInstance();
		curso = CursoDAO.getInstance();
		horaoff = HorarioOfertaDAO.getInstancce();
		hora = HorarioDAO.getInstance();
		profoff = ProfessorOfertaDAO.getInstance();
		list = ListarProfessores.getInstance();
		aluno = AlunoDAO.getInstance();
	}

	private int buscarCurso(String nome){
		int id = 0;
		ArrayList<Curso> cursos = curso.listar();
		for(Curso c : cursos){
			if(c.getNome().equals(nome)){
				id = c.getCodigo();
			}
		}
		return id;
	}

	private Disciplina buscarDisciplina(String cod){
		Disciplina retorno = null;
		ArrayList<Disciplina> listad = dis.listar();
		for(Disciplina d : listad){
			if(d.getCodigo().equals(cod)){
				retorno = d;
				break;
			}
		}
		return retorno;
	}

	private Curso buscaCurso(int cod){
		Curso retorno = null;
		ArrayList<Curso> listC = curso.listar();
		for(Curso c : listC){
			if(c.getCodigo() == cod){
				retorno = c;
				break;
			}
		}
		return retorno;
	}

	private Horario buscarHorario(int cod_horario){
		Horario retorno = null;
		ArrayList<Horario> listH = hora.listar();
		for(Horario h : listH){
			if(h.getId() == cod_horario){
				retorno = h;
				break;
			}
		}
		return retorno;
	}

	private ArrayList<Horario> buscarHorarios(int cod_oferta){
		ArrayList<Horario> retorno = new ArrayList<Horario>();
		ArrayList<HorarioOferta> listaHorarios = horaoff.listar();
		for(HorarioOferta ho: listaHorarios){
			if(ho.getCodigoOferta() == cod_oferta){
				Horario aux = this.buscarHorario(ho.getCodigoHorario());
				if(!retorno.contains(aux)){
					retorno.add(aux);
				}
			}
		}
		return retorno;
	}

	private Localizacao buscarLocal(int cod){
		Localizacao retorno = null;
		ArrayList<Localizacao> listaLocal = local.listar();
		for(Localizacao l : listaLocal){
			if(l.getCodigo() == cod){
				retorno = l;
				break;
			}
		}
		return retorno;
	}

	private ArrayList<Professor> buscarProfessore(int cod_oferta){
		ArrayList<Professor> retorno = new ArrayList<Professor>();
		ArrayList<ProfessorOferta> listProfe = profoff.listar();
		for(ProfessorOferta po : listProfe){
			if(po.getOffer().getCodigo() == cod_oferta){
				if(!retorno.contains(po.getProfessor())){
					retorno.add(list.buscarProfessorPorCPF(po.getProfessor().getCpf()));
				}
			}
		}
		return retorno;
	}

	public ArrayList<OfertaDisciplina> listarTodasOfertas(String curso){
		int idCurso = this.buscarCurso(curso);
		ArrayList<OfertaDisciplina> retorno = new ArrayList<OfertaDisciplina>();
		ArrayList<OfertaDisciplina> listaOfertas = off.listar();
		for(OfertaDisciplina of : listaOfertas){
			if(of.getCurso().getCodigo() == idCurso){
				Disciplina aux = this.buscarDisciplina(of.getDisciplina().getCodigo());
				Curso auxC = this.buscaCurso(idCurso);
				ArrayList<Horario> horarios = this.buscarHorarios(of.getCodigo());
				Localizacao lol = this.buscarLocal(of.getLocal().getCodigo());
				ArrayList<Professor> professores = this.buscarProfessore(of.getCodigo());
				of.setDisciplina(aux);
				of.setHorarios(horarios);
				of.setProfessores(professores);
				of.setLocal(lol);
				of.setCurso(auxC);
                               
				if(!retorno.contains(of)){
					retorno.add(of);
				}
			}
		}
		return retorno;
	}

	public ArrayList<OfertaDisciplina> listarOfertas(String curso){
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
		int month = a.get(Calendar.MONTH);
		int semestre;
		if(month >= 0 && month <= 6){
			semestre = 1;
		}else{
			semestre = 2;
		}
		int idCurso = this.buscarCurso(curso);
		ArrayList<OfertaDisciplina> retorno = new ArrayList<OfertaDisciplina>();
		ArrayList<OfertaDisciplina> listaOfertas = off.listar();
		for(OfertaDisciplina of : listaOfertas){
			if(of.getCurso().getCodigo() == idCurso && of.getAno() == ano && of.getSemestre() == semestre){
				Disciplina aux = this.buscarDisciplina(of.getDisciplina().getCodigo());
				Curso auxC = this.buscaCurso(idCurso);
				ArrayList<Horario> horarios = this.buscarHorarios(of.getCodigo());
				Localizacao lol = this.buscarLocal(of.getLocal().getCodigo());
				ArrayList<Professor> professores = this.buscarProfessore(of.getCodigo());
				of.setDisciplina(aux);
				of.setHorarios(horarios);
				of.setProfessores(professores);
				of.setLocal(lol);
				of.setCurso(auxC);
				if(!retorno.contains(of)){
					retorno.add(of);
				}
			}
		}
		return retorno;


	}


	private Curso buscarCursoDeAluno(String cpf){
		Curso retorno = null;
		try {
                    System.out.println("CURSO: >>>>>");
			ArrayList<Aluno> listaAlunos = aluno.listar();
			for(Aluno a : listaAlunos){
                            System.out.println(a);
				if(a.getCpf().equals(cpf)){
					System.out.println("CURSO: "+a.getCurso());
					retorno = a.getCurso();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public ArrayList<OfertaDisciplina> listarOfertasParaAluno(String cpf){
                System.out.println("CPF do aluno "+cpf);
		Calendar a = Calendar.getInstance();
		int ano = a.get(Calendar.YEAR);
		int month = a.get(Calendar.MONTH);
		int semestre;
		if(month >= 0 && month <= 6){
			semestre = 1;
		}else{
			semestre = 2;
		}
		Curso c = this.buscarCursoDeAluno(cpf);
		System.out.println(c);
		int idCurso = c.getCodigo();
		ArrayList<OfertaDisciplina> retorno = new ArrayList<OfertaDisciplina>();
		ArrayList<OfertaDisciplina> listaOfertas = off.listar();
		for(OfertaDisciplina of : listaOfertas){
			if(of.getCurso().getCodigo() == idCurso && of.getAno() == ano && of.getSemestre() == semestre){
				Disciplina aux = this.buscarDisciplina(of.getDisciplina().getCodigo());
				Curso auxC = this.buscaCurso(idCurso);
				ArrayList<Horario> horarios = this.buscarHorarios(of.getCodigo());
				Localizacao lol = this.buscarLocal(of.getLocal().getCodigo());
				ArrayList<Professor> professores = this.buscarProfessore(of.getCodigo());
				of.setDisciplina(aux);
				of.setHorarios(horarios);
				of.setProfessores(professores);
				of.setLocal(lol);
				of.setCurso(auxC);
				System.out.println("ID OFERTA NO LISTAR: "+of.getCodigo()+"\n\n");
				if(!retorno.contains(of)){
					retorno.add(of);
				}
			}
		}
		return retorno;


	}



}
