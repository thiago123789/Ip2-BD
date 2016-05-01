/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import com.mysql.jdbc.PreparedStatement;

import poo.negocios.beans.Curso;
import poo.negocios.beans.Graduacao;
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
		 *           Alguma possïvel exceïcao levantada durante o estabelecimento da
		 *           conexïcao
		 */
		public static Connection getConexao() throws SQLException {
	     
	                Connection retorno = null;
			/*
			 * Formato: 
			 * - Parametro 1: URLConexïcao:@endereco:porta 
			 * - Parametro 2: usuario
			 * - Parametro 3: senha
			 */
			retorno = DriverManager.getConnection(

					"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); // nome do esquema, usuario e senha
//			System.out.println("conectou");
			return retorno;
		}

		public boolean inserir(Curso curso,Graduacao graduacao) throws SQLException{
			boolean inseriu = false;
			String sql = "INSERT INTO deinfo.curso(nome, coordenador, vice_coordenador) values(?,?,?)";
			this.conexao = getConexao();
			Statement simplaStatement;
			try{
				PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
				
				if(!curso.equals(null) && !graduacao.equals(null)){
					
					if (!curso.getNome().equals("") &&
					!graduacao.getCoordenador().getTitulo().equals("") &&
					!graduacao.getVice().getTitulo().equals("") ){
					
						smt.setString(1, curso.getNome());
						smt.setString(2, graduacao.getCoordenador().getTitulo());
						smt.setString(3, graduacao.getVice().getTitulo());
						
						smt.execute();
						smt.close();
						inseriu = true;
					}
				
				}

				
			}catch(Exception e){
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
			}
			return inseriu;
		}


		public boolean atualiza(Curso curso,Graduacao graduacao) throws SQLException{
			boolean atualizou = false;
			String sql = "UPDATE deinfo.curso SET nome=?, coordenador=?, vice_coordenador=?, posgraduacao = ?"
					+ "WHERE CODIGO_DIS = ?";
			Connection con = getConexao();
			Statement simplaStatement;
			try{
				PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);

               if(!curso.equals(null) && !graduacao.equals(null)){
					
					if (!curso.getNome().equals("") &&
					!graduacao.getCoordenador().getTitulo().equals("") &&
					!graduacao.getVice().getTitulo().equals("") ){
					
						smt.setString(1, curso.getNome());
						smt.setString(2, graduacao.getCoordenador().getTitulo());
						smt.setString(3, graduacao.getVice().getTitulo());
						
						smt.execute();
						smt.close();
						atualizou = true;
					}
				
				}
				
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
//				System.out.println("teste1");
				PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
				resultSet = statement.executeQuery();
//				System.out.println("teste2");
//				metaData = resultSet.getMetaData();
				while(resultSet.next()){
					
					int cod = resultSet.getInt("id");
					
					String nome = resultSet.getString("nome");

					Curso curso = new Curso(cod, nome);
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
		
}
	        
	        
	      
	        
	       
