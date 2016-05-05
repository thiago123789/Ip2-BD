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

import javax.swing.JOptionPane;

import static poo.dados.DAO.PessoaDAO.resultSet;
import poo.dados.iRepositorioDisciplina;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Disciplina;

/**
 *
 * @author Thiago Gomes
 */
public class DepartamentoDAO {
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

	public DepartamentoDAO(){
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
				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "projetoipbd", "ufrpe@2016"); // nome do esquema, usu�rio e senha
		return retorno;
	}

	public boolean inserir(Departamento depat) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.departamento(nome, sigla, diretor, vice) values(?,?,?,?)";
		this.conexao = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) conexao.prepareStatement(sql);
			smt.setString(1, depat.getNome());
			smt.setString(2, depat.getSigla());
                        if(depat.getDiretor() == null){
                            smt.setNull(3, Types.VARCHAR);
                        }else{
                            smt.setString(3, depat.getDiretor().getCpf());
                        }
                        
                        if(depat.getVice() == null){
                            smt.setNull(4, Types.VARCHAR);
                        }else{
                            smt.setString(4, depat.getVice().getCpf());	
                        }
			smt.execute();
			smt.close();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}


	public boolean atualiza(Departamento depat) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.departamento SET nome =?, sigla = ?, diretor =?, vice=?";
		Connection con = getConexao();
		Statement simplaStatement;
		try{
			PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
			smt.setString(1, depat.getNome());
			smt.setString(2, depat.getSigla());
			smt.setString(3, depat.getDiretor().getCpf());
			smt.setString(4, depat.getVice().getCpf());
			smt.execute();
			smt.close();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	public ArrayList<Departamento> consulta(){
		ArrayList<Departamento> a = new ArrayList<Departamento>();
		String query = "SELECT * FROM deinfo.departamento";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int codigo = resultSet.getInt("ID_DEP");
				String nome = resultSet.getString("NOME");
                String sigla = resultSet.getString("SIGLA");
				Departamento b = new Departamento();
				b.setId(codigo);
                b.setNome(nome);
                b.setSigla(sigla);
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
        
        
        public Departamento buscaCN(String nomeBusca){
		Departamento a = null;
		String query = "SELECT * FROM deinfo.disciplina WHERE nome = \""+nomeBusca+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int codigo = resultSet.getInt("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
                                String sigla = resultSet.getString("SIGLA");
                                a = new Departamento();
                                a.setId(codigo);
                                a.setNome(nome);
                                a.setSigla(sigla);
                                   
				
			}			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return a;

	}
        
        
        public boolean buscaDept(String sigla){
		boolean ok = false;
		String query = "SELECT * FROM deinfo.disciplina WHERE sigla = \""+sigla+"\"";
		try{
			Connection con = getConexao();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
			if(resultSet.isBeforeFirst()){
                            ok = true;
            } 			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return ok;

	}
        
        public int depatID(String nome){
    		int ok = -1;
    		String query = "SELECT * FROM deinfo.departamento WHERE nome = \""+nome+"\"";
    		try{
    			Connection con = getConexao();
    			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
    			resultSet = statement.executeQuery();
    			if(resultSet.next()){
    				ok = resultSet.getInt("ID_DEP");
                } 			
    			statement.close();
    		}catch(SQLException e){
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}catch(Exception e){
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}

    		return ok;

    	}

}
