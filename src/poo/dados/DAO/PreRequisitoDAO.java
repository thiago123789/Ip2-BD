/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.PreRequisito;

/**
 *
 * @author Thiago Gomes
 */
public class PreRequisitoDAO implements IPreRequisitoDAO{
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

	public boolean inserir(PreRequisito pre) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.pre_requisito(disciplina, prerequisito) values(?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, pre.getDisciplina().getCodigo());
			smt.setString(2, pre.getPreRequisito().getCodigo());
			smt.execute();
			inseriu = true;
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro PreRequisito", -1);
		}
		return inseriu;
	}


	public ArrayList<PreRequisito> listar() throws SQLException{
		ArrayList<PreRequisito> a = new ArrayList<PreRequisito>();
		String query = "SELECT * FROM deinfo.pre_requisito";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String codigoD = resultSet.getString("disciplina");
				String codigoP = resultSet.getString("prerequisito");
				PreRequisito pre = new PreRequisito(new Disciplina(codigoD), new Disciplina(codigoP));
				a.add(pre);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro PreRequisito", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro PreRequisito", -1);
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
