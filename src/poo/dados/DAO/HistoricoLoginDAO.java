/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import poo.negocios.beans.Disciplina;

/**
 *
 * @author Thiago Gomes
 */
public class HistoricoLoginDAO {
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

	public HistoricoLoginDAO(){
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

        /*
         * Formato:
         * - Par�metro 1: URLConex�o:@endere�o:porta
         * - Par�metro 2: usu�rio
         * - Par�metro 3: senha
         */
                Connection retorno = DriverManager.getConnection(                
                "jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); // nome do esquema, usu�rio e senha
//		System.out.println("conectou");
		return retorno;
	}

	public void inserir(String cpf) throws SQLException{
//		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.historico_login(id, cpf_log, data_login) values(?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
                    Date date = new Date();
                    PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
                    smt.setInt(1, 0);
                    smt.setString(2, cpf);
                    smt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
                        
//			smt.setString(1, cpf);
//			smt.setDate(2, d);
			smt.execute();
			smt.close();
//			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
//		return inseriu;
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
        
        
        public String buscaCN(String cpf){
		String a = "";
		String query = "SELECT * FROM deinfo.historico_login WHERE cpf_log = \""+cpf+"\"";
		try{
			Connection con = getConexao();
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				a = resultSet.getTimestamp("data_login").toString();
//				System.out.println(codigo);				
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
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
//                        System.out.println(resultSet.g);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
//				System.out.println(codigo);
				String nome = resultSet.getString("NOME");
//				System.out.println(nome);
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
