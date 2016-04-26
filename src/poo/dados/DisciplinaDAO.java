package poo.dados;

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

public class DisciplinaDAO implements iRepositorioDisciplina{
	private Connection conexao;
	public static ResultSet resultSet;
	public static ResultSetMetaData metaData;
	public static Statement statement;

	public static DisciplinaDAO instance;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//				System.out.println("carregou");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}		
	}


	public static iRepositorioDisciplina getInstance() throws IOException, SQLException{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//				System.out.println("carregou");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
		return instance;
	}

	public DisciplinaDAO(){
		try{
			this.conexao = getConexao();
			Connection con = getConexao();
			String comando = "CREATE TABLE IF NOT EXISTS DEINFO.disciplina("
					+ "CODIGO_DIS VARCHAR(20) NOT NULL PRIMARY KEY,"
					+ "NOME VARCHAR(50) NOT NULL,"
					+ "CURSO INT(5) NOT NULL,"
					+ "CARGA_HORARIA INT(3) NOT NULL,"
					+ "TRILHA INT(5),"
					+ "OPTATIVA BOOLEAN,"
					+ "OBRIGATORIOA BOOLEAN,"
					+ "GRADUACAO BOOLEAN,"
					+ "POSGRADUACAO BOOLEAN"
					+ ") ENGINE = InnoDB;";
			Statement smt = con.createStatement();
			smt.execute(comando);
			smt.close();
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

				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "root", "MAradona.58b"); // nome do esquema, usu�rio e senha
		System.out.println("conectou");
		return retorno;
	}

	public boolean inserir(Disciplina disciplina) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.disciplina(codigo_dis, nome, curso, carga_horaria, trilha, "
				+ "pre_requisito1, pre_requisito2, pre_requisito3, pre_requisito4, co_requisito, optativa, OBRIGATORIOA, graduacao, posgraduacao) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			if (disciplina.getPreRequisito() == null) {
				smt.setNull(6, Types.VARCHAR);
			} else {
				smt.setString(6, disciplina.getPreRequisito().getCodigo());
			}

			if (disciplina.getPreRequisito2() == null) {
				smt.setNull(7, Types.VARCHAR);
			} else {
				smt.setString(7, disciplina.getPreRequisito2().getCodigo());
			}
			if (disciplina.getPreRequisito3() == null) {
				smt.setNull(8, Types.VARCHAR);
			} else {
				smt.setString(8, disciplina.getPreRequisito3().getCodigo());
			}
			if (disciplina.getPreRequisito4() == null) {
				smt.setNull(9, Types.VARCHAR);
			} else {
				smt.setString(9, disciplina.getPreRequisito4().getCodigo());
			}
			if (disciplina.getCoRequisito() == null) {
				smt.setNull(10, Types.VARCHAR);
			} else {
				smt.setString(10, disciplina.getCoRequisito().getCodigo());
			}
			smt.setInt(11, (disciplina.getOptativa())? 1 : 0);
			smt.setInt(12, (disciplina.getObrigatoria())? 1 : 0);
			smt.setInt(13, (disciplina.getGraducao())? 1 : 0);
			smt.setInt(14, (disciplina.getPosGraduacao())? 1 : 0);
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
				+ "pre_requisito = ?, optativa = ?, OBRIGATORIOA = ?, graduacao = ?, posgraduacao = ?"
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
			if (disciplina.getPreRequisito() == null) {
				smt.setNull(6, Types.VARCHAR);
			} else {
				smt.setString(6, disciplina.getPreRequisito().getCodigo());
			}

			if (disciplina.getPreRequisito2() == null) {
				smt.setNull(7, Types.VARCHAR);
			} else {
				smt.setString(7, disciplina.getPreRequisito2().getCodigo());
			}
			if (disciplina.getPreRequisito3() == null) {
				smt.setNull(8, Types.VARCHAR);
			} else {
				smt.setString(8, disciplina.getPreRequisito3().getCodigo());
			}
			if (disciplina.getPreRequisito4() == null) {
				smt.setNull(9, Types.VARCHAR);
			} else {
				smt.setString(9, disciplina.getPreRequisito4().getCodigo());
			}
			if (disciplina.getCoRequisito() == null) {
				smt.setNull(10, Types.VARCHAR);
			} else {
				smt.setString(10, disciplina.getCoRequisito().getCodigo());
			}
			smt.setInt(11, (disciplina.getOptativa())? 1 : 0);
			smt.setInt(12, (disciplina.getObrigatoria())? 1 : 0);
			smt.setInt(13, (disciplina.getGraducao())? 1 : 0);
			smt.setInt(14, (disciplina.getPosGraduacao())? 1 : 0);
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
		String query = "SELECT * FROM disciplina";
		try{
			Connection con = getConexao();
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
//				System.out.println(codigo);
				String nome = resultSet.getString("NOME");
//				System.out.println(nome);
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
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
//				System.out.println(codigo);
				String nome = resultSet.getString("NOME");
//				System.out.println(nome);
                                a = new Disciplina(codigo, nome);
				
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
