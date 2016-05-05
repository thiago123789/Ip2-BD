/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

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

import poo.dados.iRepositorioDisciplina;
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
		return retorno;
	}

	public void inserir(String cpf) throws SQLException{
		String sql = "INSERT INTO deinfo.historico_login(id, cpf_log, data_login) values(?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
			Date date = new Date();
			PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
			smt.setInt(1, 0);
			smt.setString(2, cpf);
			smt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			smt.execute();
			smt.close();
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
	}


	
	public String buscaCN(String cpf){
		String a = "";
		String query = "SELECT * FROM deinfo.historico_login WHERE cpf_log = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				a = resultSet.getTimestamp("data_login").toString();
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
