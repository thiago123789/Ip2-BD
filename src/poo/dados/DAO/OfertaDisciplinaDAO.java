package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Localizacao;
import poo.negocios.beans.OfertaDisciplina;

public class OfertaDisciplinaDAO implements IOfertaDisciplinaDAO{
	private static OfertaDisciplinaDAO instance;
	private ConnectionBanco bancoConnect;

	public static OfertaDisciplinaDAO getInstance(){
		if(instance == null){
			instance = new OfertaDisciplinaDAO();
		}
		return instance;
	}

	private OfertaDisciplinaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

//	ID_OFERTA, ANO, SEMESTRE, DISCIPLINA_OFERTA, ID_CURSO_DISPONIVEL, LOCALIZACAO, MONITOR_OFERTA
	public int inserir(OfertaDisciplina offer){
		int id = 0;
		String sql = "INSERT INTO deinfo.oferta_disciplina(ano, semetrstre, disciplina_oferta, localizalicao, ID_CURSO_DISPONIVEL) "
				+ "values(?,?,?,?)";
		try{

			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setInt(1, offer.getAno());
			smt.setInt(2, offer.getSemestre());
			smt.setString(3, offer.getDisciplina().getCodigo());
			smt.setInt(4, offer.getLocal().getCodigo());
			smt.setInt(5, offer.getCurso().getCodigo());
			smt.execute();

			ResultSet st = smt.getGeneratedKeys();
			st.next();

			id = st.getInt(1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return id;
	}

	//ID_OFERTA, ANO, SEMESTRE, DISCIPLINA_OFERTA, LOCALIZACAO, MONITOR_OFERTA
	public ArrayList<OfertaDisciplina> listar(){
		ArrayList<OfertaDisciplina> lista = new ArrayList<OfertaDisciplina>();
		String sql = "SELECT * FROM deinfo.oferta_disciplina";
		try{
			ResultSet rs = bancoConnect.comandoSQL(sql);
			while(rs.next()){
				int codigo = rs.getInt("ID_OFERTA");
				int ano = rs.getInt("ANO");
				int semestre = rs.getInt("SEMESTRE");
				String cod_disciplina = rs.getString("DISCIPLINA_OFERTA");
				int localizacao = rs.getInt("LOCALIZACAO");
				String monitor = rs.getString("MONITOR_OFERTA");
				int curso = rs.getInt("ID_CURSO_DISPONIVEL");
				OfertaDisciplina off = new OfertaDisciplina(codigo, new Disciplina(cod_disciplina),
						ano, semestre, new Localizacao(localizacao), new Aluno(monitor));
				off.setCurso(new Curso(curso));
				lista.add(off);
			}
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return lista;
	}



}
