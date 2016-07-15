package poo.negocios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import poo.dados.DAO.ConnectionBanco;
import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.HorarioOfertaDAO;
import poo.dados.DAO.LocalizacaoDAO;
import poo.dados.DAO.OfertaDisciplinaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.ProfessorOfertaDAO;
import poo.dados.DAO.interfaces.IBancoConnection;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IHorarioOfertaDAO;
import poo.dados.DAO.interfaces.ILocalizacaoDAO;
import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.dados.DAO.interfaces.IProfessorOfertaDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Horario;
import poo.negocios.beans.OfertaDisciplina;
import poo.negocios.beans.Professor;
import poo.negocios.beans.ProfessorOferta;

public class CadastroOferta {
	private static CadastroOferta instance;
	private IOfertaDisciplinaDAO command;
	private ICursoDAO curso;
	private IDisciplinaDAO disciplina;
	private ILocalizacaoDAO local;
	private IProfessorDAO professor;
	private IProfessorOfertaDAO profOff;
	private IHorarioOfertaDAO offH;
	private IBancoConnection banco;

	public static CadastroOferta getInstance(){
		if(instance == null){
			instance = new CadastroOferta();
		}
		return instance;
	}

	private CadastroOferta(){
		command = OfertaDisciplinaDAO.getInstance();
		curso = CursoDAO.getInstance();
		disciplina = DisciplinaDAO.getInstance();
		local = LocalizacaoDAO.getInstance();
		professor = ProfessorDAO.getInstance();
		profOff = ProfessorOfertaDAO.getInstance();
		offH = HorarioOfertaDAO.getInstancce();
		banco = ConnectionBanco.getInstance();
	}

	private int idCurso(String nome){
		int retorno = -1;
		ArrayList<Curso> listaCursos = curso.listar();
		for(Curso c : listaCursos ){
			if(c.getNome().equals(nome)){
				retorno = c.getCodigo();
				break;
			}
		}
		return retorno;
	}

	public boolean inserirOferta(OfertaDisciplina of) throws SQLException{
		boolean inseriu = false;
		Connection conexao = banco.getConexao();
		try{
			System.out.println(banco.getConexao());
			int idCurso = this.idCurso(of.getCurso().getNome());
			of.getCurso().setCodigo(idCurso);
			int id = command.inserir(of);
			of.setCodigo(id);
			for(Horario h: of.getHorarios()){
				offH.inserir(of.getCodigo(), h.getId());
			}
			for(Professor p: of.getProfessores()){
				ProfessorOferta po = new ProfessorOferta(p, of);
				System.out.println(po.toString());
				profOff.inserir(p.getCpf(), of.getCodigo());
			}
			System.out.println("Antes do commit");
			conexao.commit();
			System.out.println("passou do commit");
		} catch(SQLException e){
			inseriu = false;
			if(e.getErrorCode() == 1062){
				JOptionPane.showConfirmDialog(null, "Ja existe uma oferta dessa disciplina cadastrada", "Erro 1062", -1);
			}else if(e.getErrorCode() == 45000){
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro 45000", -1);
			}else{
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
			}
			conexao.rollback();
			//e.printStackTrace();
			//System.out.println("voltou tudo");
		}
		return inseriu;
	}





}
