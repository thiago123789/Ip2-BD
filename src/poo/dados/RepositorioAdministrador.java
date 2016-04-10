/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados;
import java.io.Serializable;
import java.sql.Date;

//BIBLIOTECAS PARA BANCO DE DADOS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

import poo.negocios.beans.*;
/**
 *
 * @author Thiago Gomes
 */
public class RepositorioAdministrador implements Serializable{
    
        public static Connection conexao;
        public static ResultSet resultSet;
        public static ResultSetMetaData metaData;
        public static Statement statement;
    
        static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
	}

        public RepositorioAdministrador() throws SQLException{
            Connection con = getConexao();
            String comando = "CREATE TABLE IF NOT EXISTS DEINFO.ADMINISTRADOR("
				+ "CPF BIGINT(12) auto_increment PRIMARY KEY NOT NULL,"
				+ "PNOME VARCHAR(50) NOT NULL,"
				+ "UNOME VARCHAR(50) NOT NULL,"
				+ "ENDERECO VARCHAR(100) NOT NULL,"
				+ "SENHA VARCHAR(15) NOT NULL,"
                                + "DATA_NASC DATE NOT NULL"
				+ ");";
            Statement smt = con.createStatement();
            smt.execute(comando);
            smt.close();
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
		
		return retorno;
	}
	
	public boolean inserir(Administrador administrador){
		boolean inseriu = false;
		try{
			String comando = "INSERT INTO administrador(cpf, pnome, unome,  usuario, senha, data) values(?,?,?,?,?,?)";
			Connection con = getConexao();
//			Statement simplaStatement = con.createStatement();
			PreparedStatement smt = (PreparedStatement) con.prepareStatement(comando);
			smt.setString(1, administrador.getCpf());
			smt.setString(2, administrador.getPnome());
			smt.setString(3, administrador.getUnome());
			smt.setString(4, administrador.getUsuario());
			smt.setString(5, administrador.getSenha());
			smt.setDate(6, new Date(administrador.getData_nasc().getTime()));
			smt.execute();
			smt.close();
		}catch(Exception e){
			
		}
		return inseriu;
	}
	
	
	
	public static void main(String[] args) {
//
//		try {
//			
//			Connection connection = getConexao();
//
//			Statement simpleStatement = connection.createStatement();
//
//			simpleStatement.execute(
//					"insert into aluno values " +
//							"('091', 'Thiago', 'Gomes', 'Rua dr telesphoro', '545911')"
//					);
//
//			System.out.println("Comando de inser��o realizado com sucesso.");
//
//			Statement s = connection.createStatement();
//
//			ResultSet rs = s.executeQuery("select * from alunos;");
//
//			System.out.println("Listando todos os hospital do BD");
//			
//			
//			System.out.printf("%12d %50s %50s %30s %15s %date\n", "Cpf", "Hospital", "Telefone", "Endere�o");
//
//			while (rs.next()) {
//				String cnpj = rs.getString("cnpj");
//				String nome = rs.getString("nome");
//				String telefone = rs.getString("telefone");
//				String endereco = rs.getString("endereco");
//				System.out.printf("%15s %25s %15s %40s\n", cnpj, nome, telefone,
//						endereco);
//			}
////
//			simpleStatement.close();  // fechando os comandos SQL
////			s.close();
//			
//			connection.close();  // fechando a conex�o
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
            try{
		RepositorioAdministrador aux = new RepositorioAdministrador();
            }catch(SQLException e){
                e.printStackTrace();
            }
            Administrador aux = new Administrador();
            
	}



	
	
	
}
