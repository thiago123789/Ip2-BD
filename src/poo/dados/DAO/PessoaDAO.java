/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

import poo.excecoes.SenhaIncorretaException;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Endereco;
import poo.negocios.beans.Pessoa;

/**
 *
 * @author Thiago Gomes
 */
public class PessoaDAO {
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

	public PessoaDAO(){
            try {		
                this.conexao = getConexao();
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); // nome do esquema, usu�rio e senha
		return retorno;
	}
        
	public boolean inserir(Pessoa p) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.pessoa(cpf_p, P_NOME, U_NOME, SEXO, SENHA, EMAIL, "
				+ "logradouro, cep, tipo_pessoa, cidade, bairro, numero, estado, data_nasc) "
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
			smt.setString(1, p.getCpf());
            System.out.println(p.getCpf());
            smt.setString(2, p.getPnome());
			smt.setString(3, p.getUnome());
            smt.setInt(4, (p.getSexo())? 0 : 1);
			smt.setString(5, p.getSenha());
            smt.setString(6, p.getEmail());
            smt.setString(7, p.getEndereco().getLogradouro());
            smt.setString(8, p.getEndereco().getCep());
            smt.setInt(9, p.getTipo());
            smt.setString(10, p.getEndereco().getCidade());
            smt.setString(11, p.getEndereco().getBairro());
            smt.setInt(12, p.getEndereco().getNumero());
            smt.setString(13, p.getEndereco().getEstado());
            smt.setDate(14, new java.sql.Date(p.getDataNascimento().getTime().getTime()));
			smt.execute();
			smt.close();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}
        
	public int tipoDeUsuario(String cpf){
        int tipo = -1;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				tipo = resultSet.getInt("TIPO_PESSOA");
                                
			}			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return tipo;
	}
    
	
	public String verificaSenha(String cpf){
        String aux = null;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String senha_p = resultSet.getString("SENHA");
                aux = senha_p;
            }
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return aux;

        }
        
	public boolean autenticar(String cpf, String senha){
        boolean ok = false;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String senha_p = resultSet.getString("SENHA");
                if(senha_p.equals(senha)){
                	ok = true;
                    break;
                }
                else{
                	throw new SenhaIncorretaException();
                }
            }
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return ok;

        }
        
    public String nomeUsuario(String cpf){
                String completo = "";
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String nome1= resultSet.getString("p_nome");
                String nome2= resultSet.getString("u_nome");
                completo = nome1+" "+nome2;
            }
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return completo;
    }
    
    public int cursoUsuario(String cpf){
        int completo = -1;
        String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
        	try{
        		Connection con = getConexao();
        		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
        		resultSet = statement.executeQuery();
        		while(resultSet.next()){
        			int curso= resultSet.getInt("CURSO");
        			completo = curso;
        		}
        		statement.close();
        	}catch(SQLException e){
        		JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
        	}catch(Exception e){
        		JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
        	}
        return completo;
    }
    
    public boolean existeUsuario(String cpf){
        boolean ok = false;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			if(resultSet.isBeforeFirst()){
				ok = true;
				System.out.println(ok);
            }                        
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return ok;
    }
        
    public boolean atualiza(Pessoa a) throws SQLException{
    		boolean atualizou = false;
    		String sql = "UPDATE deinfo.pessoa SET cpf_p = ?, P_NOME = ?,  U_NOME = ?, SEXO = ?, SENHA = ?, "
    				+ "EMAIL = ?, logradouro = ?, cep = ?, tipo_pessoa = ?, cidade = ?, bairro = ?, numero = ?, estado = ?"
    				+ "WHERE cpf_p = ?";
    		Connection con = getConexao();
    		Statement simplaStatement;
    		try{
    			PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
    			smt.setString(1, a.getCpf());
                smt.setString(2, a.getPnome());
    			smt.setString(3, a.getUnome());
                smt.setInt(4, (a.getSexo())? 0 : 1);
    			smt.setString(5, a.getSenha());
                smt.setString(6, a.getEmail());
                smt.setString(7, a.getEndereco().getLogradouro());
                smt.setString(8, a.getEndereco().getCep());
                smt.setInt(9, a.getTipo());
                smt.setString(10, a.getEndereco().getCidade());
                smt.setString(11, a.getEndereco().getBairro());
                smt.setInt(12, a.getEndereco().getNumero());
                smt.setString(13, a.getEndereco().getEstado());
    			smt.setString(14, a.getCpf());
    			smt.execute();
    			smt.close();
    			atualizou = true;
    		}catch(Exception e){
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}
    		return atualizou;
    	}
    
    public Pessoa buscaPessoa(String cpf){
		Pessoa a = null;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				String cpf_p = resultSet.getString("CPF_P");
				String p_nome = resultSet.getString("P_NOME");
				String u_nome = resultSet.getString("U_NOME");
				boolean sexo = resultSet.getBoolean("SEXO");
				String senha = resultSet.getString("SENHA");
				String email = resultSet.getString("EMAIL");
				String logradouro = resultSet.getString("logradouro");
				String cep = resultSet.getString("cep");
				int tipo_pessoa = resultSet.getInt("tipo_pessoa");
				String cidade = resultSet.getString("cidade");
				String bairro = resultSet.getString("bairro");
				int numero = resultSet.getInt("numero");
				String estado = resultSet.getString("estado");
				Endereco b = new Endereco(logradouro, numero, bairro, cidade, cep, estado);
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
