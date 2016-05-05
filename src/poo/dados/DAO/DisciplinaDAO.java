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

import poo.dados.iRepositorioDisciplina;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Horario;
import poo.negocios.beans.Professor;

import com.mysql.jdbc.PreparedStatement;

public class DisciplinaDAO implements iRepositorioDisciplina{
	private Connection conexao;
	public static ResultSet resultSet;
	public static ResultSetMetaData metaData;
	public static Statement statement;

	public static DisciplinaDAO instance;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}		
	}


	public static iRepositorioDisciplina getInstance() throws IOException, SQLException{

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
		return instance;
	}

	public DisciplinaDAO(){
		try{
			this.conexao = getConexao();
			Connection con = getConexao();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * M�todo para retornar uma nova conex�o com o banco de dados
	 * 
	 * @return Uma nova Conex�o com banco de dados Postgres, base de dados
	 *         HospitalDB
	 * @throws SQLException
	 *           Alguma poss�vel exce��o levantada durante o estabelecimento da
	 *           conex�o
	 */
	public static Connection getConexao() throws SQLException {


		Connection retorno = null;
		/*
		 * Formato: 
		 * - Par�metro 1: URLConex�o:@endere�o:porta 
		 * - Par�metro 2: usu�rio
		 * - Par�metro 3: senha
		 */
		retorno = DriverManager.getConnection(

				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016");
		return retorno;
	}

	public boolean inserir(Disciplina disciplina) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.disciplina(codigo_dis, nome, curso, carga_horaria, trilha, "
				+ "optativa, OBRIGATORIOA, graduacao, posgraduacao) values(?,?,?,?,?,?,?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
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
			smt.close();
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
		Connection con = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
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
			smt.close();
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
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				Disciplina b = new Disciplina(codigo, nome);
				a.add(b);
			}			
			statement.close();
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
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
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
			statement.close();
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
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
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
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

	public boolean buscaDis(String codigoDis){
		boolean a = false;
		String query = "SELECT * FROM deinfo.disciplina WHERE codigo_dis = \""+codigoDis+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				a = true;
			}			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

}
