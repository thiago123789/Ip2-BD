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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import poo.negocios.beans.Disciplina;
import poo.dados.IDisciplinaDAO;

/**
 *
 * @author Thiago Gomes
 */
public class PreRequisitoDAO {
	private static PreRequisitoDAO instance;
	private ConnectionBanco bancoConnect;
	
	public static PreRequisitoDAO getInstance(){
		if(instance == null){
			instance = new PreRequisitoDAO();
		}
		return instance;
	}

	private PreRequisitoDAO(){
		bancoConnect = ConnectionBanco.getInstance();
    }
	
	public boolean inserir(Disciplina disciplina) throws SQLException{
                ArrayList<Disciplina> temp = disciplina.getPreRequisito();
                boolean inseriu = false;
                for(Disciplina a: temp){
                    String sql = "INSERT INTO deinfo.pre_requisito(disciplina, prerequisito) values(?,?)";
                    try{
                            PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
                            smt.setString(1, disciplina.getCodigo());
                            smt.setString(2, a.getCodigo());
                            smt.execute();
                            inseriu = true;
                    }catch(Exception e){
                            JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
                    }
                }
		return inseriu;
	}


	public boolean atualiza(Disciplina disciplina) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.disciplina SET codigo_dis = ?, nome = ?, curso = ?, carga_horaria = ?, trilha = ?, "
				+ "pre_requisito = ?, optativa = ?, OBRIGATORIOA = ?, graduacao = ?, posgraduacao = ?"
				+ "WHERE CODIGO_DIS = ?";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, disciplina.getCodigo());
			smt.setString(2, disciplina.getNome());
			smt.setInt(3, disciplina.getCurso().getCodigo());
			smt.setInt(4, disciplina.getCargaHoraria());
			if (disciplina.getTrilha() == null) {
				smt.setNull(5, Types.INTEGER);
			} else {
				smt.setInt(5, disciplina.getTrilha().getCodigo());
			}
			smt.execute();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	public ArrayList<Disciplina> consulta(){
		ArrayList<Disciplina> a = new ArrayList<Disciplina>();
		String query = "SELECT * FROM deinfo.disciplina";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				Disciplina b = new Disciplina(codigo, nome);
				a.add(b);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}
        
        
	public Disciplina buscaCN(String codigoDis){
		Disciplina a = null;
		String query = "SELECT * FROM deinfo.disciplina WHERE codigo_dis = \""+codigoDis+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
                a = new Disciplina(codigo, nome);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}
        
	public ArrayList<String> buscaPre(String codigoDis){
		ArrayList<String> a = new ArrayList<String>() ;
		String query = "SELECT * FROM deinfo.pre_requisito WHERE DISCIPLINA = \""+codigoDis+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("PREREQUISITO");
                a.add(codigo);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}
        
        
        
}
