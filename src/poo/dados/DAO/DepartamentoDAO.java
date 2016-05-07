/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.negocios.beans.Departamento;

/**
 *
 * @author Thiago Gomes
 */
public class DepartamentoDAO {
	private static DepartamentoDAO instance;
    private ConnectionBanco bancoConnect;
	
    public static DepartamentoDAO getInstance(){
    	if(instance == null){
    		instance = new DepartamentoDAO();
    	}
    	return instance;
    }
    
	private DepartamentoDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	public boolean inserir(Departamento depat) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.departamento(nome, sigla, diretor, vice) values(?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
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
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}


	public boolean atualiza(Departamento depat) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.departamento SET nome =?, sigla = ?, diretor =?, vice=?";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, depat.getNome());
			smt.setString(2, depat.getSigla());
			smt.setString(3, depat.getDiretor().getCpf());
			smt.setString(4, depat.getVice().getCpf());
			smt.execute();
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
			ResultSet resultSet = bancoConnect.comandoSQL(query);
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
			PreparedStatement statement = (PreparedStatement) bancoConnect.retornoStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				int codigo = resultSet.getInt("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
                String sigla = resultSet.getString("SIGLA");
                a = new Departamento();
                a.setId(codigo);
                a.setNome(nome);
                a.setSigla(sigla);
			}			
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
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			if(resultSet.isBeforeFirst()){
                            ok = true;
            } 			
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
    			ResultSet resultSet = bancoConnect.comandoSQL(query);
    			if(resultSet.next()){
    				ok = resultSet.getInt("ID_DEP");
                } 			
    		}catch(SQLException e){
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}catch(Exception e){
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}
    		return ok;
	}
}