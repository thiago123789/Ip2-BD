package poo.dados.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Horario;
import poo.negocios.beans.Professor;

import com.mysql.jdbc.PreparedStatement;
import poo.dados.IDisciplinaDAO;

public class DisciplinaDAO implements IDisciplinaDAO{
	private static DisciplinaDAO instance;
	private ConnectionBanco bancoConect;
	
	public static DisciplinaDAO getInstance(){
		if(instance == null){
			instance = new DisciplinaDAO();
		}
		return instance;
	}
	
	private DisciplinaDAO(){
		bancoConect = ConnectionBanco.getInstance();
	}
	
	public boolean inserir(Disciplina disciplina) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.disciplina(codigo_dis, nome, curso, carga_horaria, trilha, "
				+ "optativa, OBRIGATORIOA, graduacao, posgraduacao) values(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
			smt.setString(1, disciplina.getCodigo());
			smt.setString(2, disciplina.getNome());
			smt.setInt(3, disciplina.getCurso().getCodigo());
			smt.setInt(4, disciplina.getCargaHoraria());
			if (disciplina.getTrilha() == null) {
				smt.setNull(5, Types.INTEGER);
			} else {
				smt.setInt(5, disciplina.getTrilha().getCodigo());
			}
			smt.setInt(6, (disciplina.getOptativa())? 1 : 0);
			smt.setInt(7, (disciplina.getObrigatoria())? 1 : 0);
			smt.setInt(8, (disciplina.getGraducao())? 1 : 0);
			smt.setInt(9, (disciplina.getPosGraduacao())? 1 : 0);
			smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}


	public boolean atualiza(Disciplina disciplina) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.disciplina SET codigo_dis = ?, nome = ?, curso = ?, carga_horaria = ?, trilha = ?, "
				+ "optativa = ?, OBRIGATORIOA = ?, graduacao = ?, posgraduacao = ?"
				+ "WHERE CODIGO_DIS = ?";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
			smt.setString(1, disciplina.getCodigo());
			smt.setString(2, disciplina.getNome());
			smt.setInt(3, disciplina.getCurso().getCodigo());
			smt.setInt(4, disciplina.getCargaHoraria());
			if (disciplina.getTrilha() == null) {
				smt.setNull(5, Types.INTEGER);
			} else {
				smt.setInt(5, disciplina.getTrilha().getCodigo());
			}
			smt.setInt(6, (disciplina.getOptativa())? 1 : 0);
			smt.setInt(7, (disciplina.getObrigatoria())? 1 : 0);
			smt.setInt(8, (disciplina.getGraducao())? 1 : 0);
			smt.setInt(9, (disciplina.getPosGraduacao())? 1 : 0);
			smt.execute();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	public ArrayList<Disciplina> consulta(){
		ArrayList<Disciplina> a = new ArrayList<Disciplina>();
		String query = "SELECT * FROM deinfo.disciplina";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				int carga = resultSet.getInt("CARGA_HORARIA");
				Disciplina b = new Disciplina(codigo, nome);
				b.setCargaHoraria(carga);
				a.add(b);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}
	
	public ArrayList<Disciplina> listarDisciplinasPorCurso(int curso){
		ArrayList<Disciplina> a = new ArrayList<Disciplina>();
		String query = "SELECT * FROM deinfo.disciplina WHERE curso = \""+curso+"\"";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				Disciplina b = new Disciplina(codigo, nome);
				a.add(b);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

	public Disciplina buscaCN(String codigoDis){
		Disciplina a = null;
		String query = "SELECT * FROM deinfo.disciplina WHERE codigo_dis = \""+codigoDis+"\"";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				int carga = resultSet.getInt("CARGA_HORARIA");
				int optativa = resultSet.getInt("OPTATIVA");
				int obrigatoria = resultSet.getInt("OBRIGATORIA");
				int curso = resultSet.getInt("CURSO");
				boolean value = false;
				boolean value2 = false;
				if(optativa == 1){
					value = true;
				}
				if(obrigatoria == 1){
					value = true;
				}
                Curso temp = new Curso(curso, "nada", 0);
				a = new Disciplina(codigo, nome, carga, value, value2);
				a.setCurso(temp);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}


	/*
	 * BUSCA QUE IRÁ RETORNAR AS DISCIPLINAS QUE POSSUAM DETERMINADA PALAVRA NO SEU NOME     * 
	 */
	public ArrayList<Disciplina> searchAdvanced(String nomeD){
		ArrayList<Disciplina> a = new ArrayList<Disciplina>();
		String query = "SELECT * FROM deinfo.disciplina WHERE codigo_dis = \"%"+nomeD+"\"%";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				int carga = resultSet.getInt("CARGA_HORARIA");
				int optativa = resultSet.getInt("OPTATIVA");
				int obrigatoria = resultSet.getInt("OBRIGATORIA");
				boolean value = false;
				boolean value2 = false;
				if(optativa == 1){
					value = true;
				}
				if(obrigatoria == 1){
					value = true;
				}
				Disciplina b = new Disciplina(codigo, nome, carga, value, value2);
				a.add(b);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

	public boolean existeDis(String codigoDis){
		boolean a = false;
		String query = "SELECT * FROM deinfo.disciplina WHERE codigo_dis = \""+codigoDis+"\"";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				a = true;
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

}
