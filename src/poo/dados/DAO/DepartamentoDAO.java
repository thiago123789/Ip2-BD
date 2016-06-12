/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Professor;

/**
 *
 * @author Thiago Gomes
 */
public class DepartamentoDAO implements IDepartamentoDAO{
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

	//ID_DEP, NOME, SIGLA, DIRETOR, VICE
	public boolean atualizar(Departamento depat) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.departamento SET nome =?, sigla = ?, diretor =?, vice=? WHERE ID = \""+depat.getId()+"\"";
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
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	public ArrayList<Departamento> listar() throws SQLException{
		ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		String query = "SELECT * FROM deinfo.departamento";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				int codigo = resultSet.getInt("ID_DEP");
				String nome = resultSet.getString("NOME");
				String sigla = resultSet.getString("SIGLA");
				String diretor = resultSet.getString("DIRETOR");
				String vice = resultSet.getString("VICE");
				Departamento b = new Departamento();
				b.setId(codigo);
				b.setNome(nome);
				b.setSigla(sigla);
				b.setDiretor(new Professor(diretor));
				b.setVice(new Professor(vice));
				listaDepartamentos.add(b);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return listaDepartamentos;
	}



	/// EXCLUIR DO CRUD
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


	//EXCLUIR DO CRUD
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