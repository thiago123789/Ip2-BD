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
import java.util.Date;

import javax.swing.JOptionPane;

import poo.negocios.beans.Disciplina;
import poo.dados.IDisciplinaDAO;

/**
 *
 * @author Thiago Gomes
 */
public class HistoricoLoginDAO {
	private static HistoricoLoginDAO instance;
	private ConnectionBanco bancoConnect;
	
	public static HistoricoLoginDAO getInstance(){
		if(instance == null){
			instance = new HistoricoLoginDAO();
		}
		return instance;
	}
	
	private HistoricoLoginDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}
	
	public void inserir(String cpf) throws SQLException{
		String sql = "INSERT INTO deinfo.historico_login(id, cpf_log, data_login) values(?,?,?)";
		try{
			Date date = new Date();
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setInt(1, 0);
			smt.setString(2, cpf);
			smt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			smt.execute();
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
	}

	public String buscaCN(String cpf){
		String a = "";
		String query = "SELECT * FROM deinfo.historico_login WHERE cpf_log = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				a = resultSet.getTimestamp("data_login").toString();
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}


}
