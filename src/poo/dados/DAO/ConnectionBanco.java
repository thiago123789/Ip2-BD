package poo.dados.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;


public class ConnectionBanco {
    private static ConnectionBanco instance;
    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet resultSet;

    static{
		try {
	            Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
	            System.out.println("Problemas carregando o Driver do MySQL");
		}		
    }
    
    public static ConnectionBanco getInstance(){
        if(instance == null){
            instance = new ConnectionBanco();
        }
        return instance;
    }
    
    private ConnectionBanco(){
        try {
            conexao = setConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Connection setConexao() throws SQLException {
		Connection retorno = null;
		retorno = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); 
		retorno.setAutoCommit(true);
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
			this.statement = (com.mysql.jdbc.PreparedStatement) this.conexao.prepareStatement(query);
			this.resultSet = this.statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return this.resultSet;
    }
    
    public Connection getConexao(){
    	return this.conexao;
    }
    
    public void closeConnection(){
    	try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    
}
