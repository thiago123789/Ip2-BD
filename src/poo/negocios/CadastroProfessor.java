package poo.negocios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.ConnectionBanco;
import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IBancoConnection;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Pessoa;
import poo.negocios.beans.Professor;

public class CadastroProfessor {
	private static CadastroProfessor instance;
	private IPessoaDAO command;
	private IProfessorDAO commandA;
	private IDepartamentoDAO depat;
	private IBancoConnection banco;

	public static CadastroProfessor getInstance(){
		if(instance == null){
			instance = new CadastroProfessor();
		}
		return instance;
	}

	private CadastroProfessor(){
		command = PessoaDAO.getInstance();
		commandA = ProfessorDAO.getInstance();
		depat = DepartamentoDAO.getInstance();
		banco = ConnectionBanco.getInstance();
	}

	public void cadastraProfessor(Professor p){
		Connection conexao = banco.getConexao();
		try {
			int id = this.retornaIdDepartamento(p.getDepartamento().getNome());
			p.getDepartamento().setId(id);
			command.inserir((Pessoa)p);
			commandA.inserir(p);
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conexao != null){
				banco.setConnectionNull();
			}
		}

	}

	private int retornaIdDepartamento(String nome){
		int retorno = -1;
		try {
			ArrayList<Departamento> departamentoList = depat.listar();
			for(Departamento d: departamentoList){
				if(d.getNome().equals(nome)){
					retorno = d.getId();
					break;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public ArrayList<String> listarTitulacoes(){
		ArrayList<String> retorno = new ArrayList<String>();
		ArrayList<Professor> lista = commandA.listar();
		for(Professor a : lista){
			if(!retorno.contains(a.getTitulo())){
				retorno.add(a.getTitulo());
			}
		}
		return retorno;
	}


}
