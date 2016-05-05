/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Disciplina;

import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author Marcos Eduardo
 */
public class CursoDAO {
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

	public CursoDAO(){
		try{
			this.conexao = getConexao();
			Connection con = getConexao();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para retornar uma nova conexcao com o banco de dados
	 * 
	 * @return Uma nova Conexcao com banco de dados Postgres, base de dados
	 *         HospitalDB
	 * @throws SQLException
	 *           Alguma poss�vel exce�cao levantada durante o estabelecimento da
	 *           conex�cao
	 */
	public static Connection getConexao() throws SQLException {
		Connection retorno = null;
		/*
		 * Formato: 
		 * - Parametro 1: URLConex�cao:@endereco:porta 
		 * - Parametro 2: usuario
		 * - Parametro 3: senha
		 */
		retorno = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); // nome do esquema, usuario e senha
		return retorno;
	}

	public boolean inserir(String nome, String cpf_coo, String cpf_vice, boolean graduacao, Departamento depat, int ano) throws SQLException{
		DepartamentoDAO aux = new DepartamentoDAO();

		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.curso(id, nome, coordenador, vice_coordenador, graduacao, posgraduacao, DEPARTAMENTO_ID, ANO_INICIO) "
				+ "values(?,?,?,?,?,?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
			smt.setInt(1, 0);
			smt.setString(2, nome);
			if(cpf_coo == null){
				smt.setNull(3, Types.VARCHAR);
			}else{
				smt.setString(3, cpf_coo);
			}
			if(cpf_vice == null){
				smt.setNull(4, Types.VARCHAR);
			}else{
				smt.setString(4, cpf_vice);
			}
			System.out.println((graduacao)? 1 : 0);
			smt.setInt(5, (graduacao)? 1 : 0);
			smt.setInt(6, (graduacao)? 0 : 1);
			System.out.println(aux.depatID(depat.getNome()));
			smt.setInt(7, aux.depatID(depat.getNome()));
			smt.setInt(8, ano);
			smt.execute();
			smt.close();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}


	public boolean atualiza(String nome, String cpf_coo, String cpf_vice, boolean graduacao) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.curso SET id = ?, nome=?, coordenador=?, vice_coordenador=?, graduacao = ?, posgraduacao= ?"
				+ "WHERE id = ?";
		Connection con = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);

			smt.setString(2, nome);
			smt.setString(2, cpf_coo);
			smt.setString(3, cpf_vice);

			smt.execute();
			smt.close();
			atualizou = true;


		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	public ArrayList<Curso> consulta(){
		ArrayList<Curso> c = new ArrayList<Curso>();
		String query = "SELECT * FROM deinfo.curso";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int cod = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				int ano = resultSet.getInt("ano_inicio");
				Curso curso = new Curso(cod, nome, ano);
				c.add(curso);
			}			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return c;

	}


	public Curso buscaCursoPorID(int id){
		Curso a = null;
		String query = "SELECT * FROM deinfo.curso WHERE ID = "+id+"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int carga = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				int ano = resultSet.getInt("ANO_INICIO");
				a = new Curso(carga, nome, ano);
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





