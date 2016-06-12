/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

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


import poo.dados.DAO.interfaces.ICursoDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Professor;

import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author Marcos Eduardo
 */
public class CursoDAO implements ICursoDAO{
	private static CursoDAO instance;
	private ConnectionBanco bancoConnect;

	public static CursoDAO getInstance(){
		if(instance == null){
			instance = new CursoDAO();
		}
		return instance;
	}

	private CursoDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	/*
	 * INICIO DO CRUD
	 */

	public boolean inserir(Curso c) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.curso(id, nome, coordenador, vice_coordenador, "
				+ "graduacao, posgraduacao, DEPARTAMENTO_ID, ANO_INICIO) "
				+ "values(?,?,?,?,?,?,?,?)";
			try{
				PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
				smt.setInt(1, 0);
				smt.setString(2, c.getNome());
				if(c.getCoordenador() == null){
					smt.setNull(3, Types.VARCHAR);
				}else{
					smt.setString(3, c.getCoordenador().getCpf());
				}
				if(c.getVice() == null){
					smt.setNull(4, Types.VARCHAR);
				}else{
					smt.setString(4, c.getVice().getCpf());
				}
				smt.setInt(5, (c.getGraducao())? 1 : 0);
				smt.setInt(6, (c.getGraducao())? 0 : 1);
				smt.setInt(7, c.getDepat().getId());
				smt.setInt(8, c.getAno_inicio());
				smt.execute();
				inseriu = true;
			}catch(Exception e){
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
			}
		return inseriu;
	}


	//ID, NOME, COORDENADOR, VICE_COORDENADOR, GRADUACAO, POSGRADUACAO, DEPARTAMENTO_ID, ANO_INICIO
	public boolean atualizar(Curso c) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.curso SET nome=?, coordenador=?, vice_coordenador=?, graduacao = ?, posgraduacao= ?"
				+ "WHERE id = \""+c.getCodigo()+"\"";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, c.getNome());

			if(c.getCoordenador() == null){
				smt.setNull(2, Types.VARCHAR);
			}else{
				smt.setString(2, c.getCoordenador().getCpf());
			}

			if(c.getVice() == null){
				smt.setNull(3, Types.VARCHAR);
			}else{
				smt.setString(3, c.getVice().getCpf());
			}

			smt.execute();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return atualizou;
	}

	//ID, NOME, COORDENADOR, VICE_COORDENADOR, GRADUACAO, POSGRADUACAO, DEPARTAMENTO_ID, ANO_INICIO
	public ArrayList<Curso> listar(){
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		String query = "SELECT * FROM deinfo.curso";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				int cod = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String coordenador = resultSet.getString("COORDENADOR");
				String vice = resultSet.getString("VICE_COORDENADOR");
				boolean graducao = resultSet.getBoolean("GRADUACAO");
				boolean posgraduacao = resultSet.getBoolean("POSGRADUACAO");
				int departamento = resultSet.getInt("DEPARTAMENTO_ID");
				int ano = resultSet.getInt("ANO_INICIO");
				Departamento aux = new Departamento();
				aux.setId(departamento);
				Curso curso = new Curso(cod, nome, ano);
				curso.setCoordenador(new Professor(coordenador));
				curso.setVice(new Professor(vice));
				curso.setDepat(aux);
				curso.setGraduacao(graducao);
				curso.setPosGraducao(posgraduacao);
				listaCursos.add(curso);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return listaCursos;
	}



	//EXCLUIR DO CRUD
	public Curso buscaCursoPorID(int id){
		Curso a = null;
		String query = "SELECT * FROM deinfo.curso WHERE ID = "+id+"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				int carga = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				int ano = resultSet.getInt("ANO_INICIO");
				a = new Curso(carga, nome, ano);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}



	//EXCLUIR DO CRUD
	public int buscaAnoCurso(String nome){
		int a = -1;
		String query = "SELECT * FROM deinfo.curso WHERE nome = \""+nome+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				int ano = resultSet.getInt("ANO_INICIO");
				a = ano;
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

}
