package poo.dados.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import poo.dados.DAO.interfaces.IBancoConnection;

public class ConnectionBanco implements IBancoConnection{
	private static ConnectionBanco instance;
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet resultSet;

	private final static String user_aluno = "alunosistema";
	private final static String pass_aluno = "ufrpe@2016";
	private final static String user_profe = "professorsistema";
	private final static String pass_profe = "ufrpe@2016";
	private final static String user_admin = "projetoipbd";
	private final static String pass_admin = "ufrpe@2016";
	private static int usuario;
	private static int novo_login;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
	}

	public static ConnectionBanco setInstance(int i){
		novo_login = i;
		if(novo_login != usuario){
			usuario = i;
			instance = new ConnectionBanco(i);
		}else{
			if(instance == null){
				instance = new ConnectionBanco();
			}
		}
		System.out.println(usuario);
		return instance;
	}

	public static ConnectionBanco getInstance(){
		usuario = 2;
		if(instance == null){
			instance = new ConnectionBanco();
		}
		return instance;
	}

	private ConnectionBanco(){
		try {
			conexao = setConexao(usuario);
			conexao.setAutoCommit(false);
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionBanco.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private ConnectionBanco(int user){
		try {
			conexao = setConexao(user);
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionBanco.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static Connection setConexao(int i) throws SQLException {
		Connection retorno = null;
		switch(i){
		case 1:
			retorno = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", user_profe, pass_profe);
			retorno.setAutoCommit(false);
			System.out.println("Logou com Professor");
			break;
		case 2:
			retorno = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", user_admin, pass_admin);
			retorno.setAutoCommit(false);
			System.out.println("Logoou com Administrador");
			break;
		case 3:
			retorno = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", user_aluno, pass_aluno);
			retorno.setAutoCommit(false);
			System.out.println("Logou com Aluno");
			break;
		default:
			System.out.println("Tipo de usuario invalido");
		}
		return retorno;

	}

	public PreparedStatement retornoStatement(String query){
		try {
			this.statement = (com.mysql.jdbc.PreparedStatement) this.conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.statement;
	}

	public ResultSet comandoSQL(String query){
		try {
			this.statement = (com.mysql.jdbc.PreparedStatement) this.getConexaoCommit().prepareStatement(query);
			this.resultSet = this.statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.resultSet;
	}

	public Connection getConexaoCommit(){
		try{
			this.conexao.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return this.conexao;
	}


	public Connection getConexao(){
		try {
			this.conexao.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.conexao;
	}

	public void setConnectionNull(){
		this.conexao = null;
		instance = null;
	}

	public boolean commit() throws SQLException{
		boolean commitou = false;
                try{
			this.conexao.commit();
                        commitou = true;
			System.out.println("Commitou");
		}catch(SQLException e){
			System.out.println("Deu Erro");
			this.conexao.rollback();
		}
                return commitou;

	}

	private static void setUsuario(int user){
		usuario = user;
	}

	public void closeConnection(){
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
