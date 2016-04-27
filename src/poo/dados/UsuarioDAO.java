/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import poo.excecoes.SenhaIncorretaException;
import poo.negocios.beans.Pessoa;

/**
 *
 * @author Thiago Gomes
 */
public class UsuarioDAO {
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

	public UsuarioDAO(){
            try {		
                this.conexao = getConexao();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        
        public boolean inserir(Pessoa p) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.pessoa(cpf_p, P_NOME, U_NOME, SEXO, SENHA, EMAIL, "
				+ "logradouro, cep, tipo_pessoa, cidade, bairro, numero, estado) "
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                        System.out.println("terminou de adicionar");
//                      if (disciplina.getTrilha() == null) {;
//				smt.setNull(5, Types.INTEGER);
//			} else {
//				smt.setInt(5, disciplina.getTrilha().getCodigo());
//			}
//			if (disciplina.getPreRequisito() == null) {
//				smt.setNull(6, Types.VARCHAR);
//			} else {
//				smt.setString(6, disciplina.getPreRequisito().getCodigo());
//			}
//
//			if (disciplina.getPreRequisito2() == null) {
//				smt.setNull(7, Types.VARCHAR);
//			} else {
//				smt.setString(7, disciplina.getPreRequisito2().getCodigo());
//			}
//			if (disciplina.getPreRequisito3() == null) {
//				smt.setNull(8, Types.VARCHAR);
//			} else {
//				smt.setString(8, disciplina.getPreRequisito3().getCodigo());
//			}
//			if (disciplina.getPreRequisito4() == null) {
//				smt.setNull(9, Types.VARCHAR);
//			} else {
//				smt.setString(9, disciplina.getPreRequisito4().getCodigo());
//			}
//			if (disciplina.getCoRequisito() == null) {
//				smt.setNull(10, Types.VARCHAR);
//			} else {
//				smt.setString(10, disciplina.getCoRequisito().getCodigo());
//			}
//			smt.setInt(11, (disciplina.getOptativa())? 1 : 0);
//			smt.setInt(12, (disciplina.getObrigatoria())? 1 : 0);
//			smt.setInt(13, (disciplina.getGraducao())? 1 : 0);
//			smt.setInt(14, (disciplina.getPosGraduacao())? 1 : 0);
			smt.execute();
			smt.close();
			inseriu = true;
		}catch(Exception e){
                    System.out.println(e.getMessage());
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
                                                

                   
		}
		return inseriu;
	}
        
        public int tipoDeUsuario(String cpf){
                int tipo = -1;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				tipo = resultSet.getInt("TIPO_PESSOA");
//				System.out.println(codigo);
//				String senha = resultSet.getString("SENHA");
//				System.out.println(senha);
                                
			}			
			statement.close();
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}

		return tipo;

        }
        
        
        public boolean autenticar(String cpf, String senha){
                boolean ok = false;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			Connection con = getConexao();
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				String senha_p = resultSet.getString("SENHA");
//				System.out.println(nome);
                                System.out.println(senha_p);
                                System.out.println(senha);
                                if(senha_p.equals(senha)){
                                                               
                                    ok = true;
                                    System.out.println(ok);
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
//			System.out.println("teste1");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			resultSet = statement.executeQuery();
//			System.out.println("teste2");
//			metaData = resultSet.getMetaData();
			while(resultSet.next()){
				String nome1= resultSet.getString("p_nome");
//				System.out.println(nome);
                                String nome2= resultSet.getString("u_nome");
//				System.out.println(nome);
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
        

}
