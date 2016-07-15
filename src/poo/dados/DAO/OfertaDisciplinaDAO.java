package poo.dados.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.excecoes.CPFInvalidoException;
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
	public int inserir(OfertaDisciplina offer) throws SQLException {
		int id = 0;
		String sql = "INSERT INTO deinfo.oferta_disciplina(ano, SEMESTRE, DISCIPLINA_OFERTA, LOCALIZACAO, ID_CURSO_DISPONIVEL) "
				+ "values(?,?,?,?,?)";

		Connection con = bancoConnect.getConexao();
		PreparedStatement smt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		smt.setInt(1, offer.getAno());
		smt.setInt(2, offer.getSemestre());
		smt.setString(3, offer.getDisciplina().getCodigo());
		smt.setInt(4, offer.getLocal().getCodigo());
		smt.setInt(5, offer.getCurso().getCodigo());
		smt.executeUpdate();

		ResultSet st = smt.getGeneratedKeys();
		st.next();

		id = st.getInt(1);

		return id;
	}

	//ID_OFERTA, ANO, SEMESTRE, DISCIPLINA_OFERTA, LOCALIZACAO, MONITOR_OFERTA
	public ArrayList<OfertaDisciplina> listar(){
		ArrayList<OfertaDisciplina> lista = new ArrayList<OfertaDisciplina>();
		Connection conexao = bancoConnect.getConexao();
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
				Disciplina aux = new Disciplina(cod_disciplina);
				Localizacao local = new Localizacao(localizacao);
				Aluno aluno = null;
				if(monitor != null){
					aluno = new Aluno(monitor);
				}
                                
				OfertaDisciplina off = new OfertaDisciplina(codigo, aux, ano, semestre, local, aluno);
				off.setCurso(new Curso(curso));
				lista.add(off);
			}
		}catch(CPFInvalidoException e2){
			JOptionPane.showConfirmDialog(null, e2.getMessage(), "Erro Listar Oferta Disciplina", -1);
		}catch(SQLException e1){
			JOptionPane.showConfirmDialog(null, e1.getMessage(), "Erro Listar Oferta Disciplina", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Listar Oferta Disciplina", -1);
		}
		return lista;
	}



}
