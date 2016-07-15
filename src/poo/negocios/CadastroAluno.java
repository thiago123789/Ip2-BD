package poo.negocios;

import java.sql.Connection;
import java.sql.SQLException;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.ConnectionBanco;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.interfaces.IAlunoDAO;
import poo.dados.DAO.interfaces.IBancoConnection;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.negocios.beans.Aluno;

public class CadastroAluno {
	private static CadastroAluno instance;
	private IAlunoDAO command;
	private IPessoaDAO commandA;
	private IBancoConnection banco;

	public static CadastroAluno getInstance(){
		if(instance == null){
			instance = new CadastroAluno();
		}
		return instance;
	}

	private CadastroAluno(){
		command = AlunoDAO.getInstance();
		commandA = PessoaDAO.getInstance();
		banco = ConnectionBanco.getInstance();
	}

	public void cadastraAluno(Aluno a){
		Connection conexao = banco.getConexao();
		try {
			commandA.inserir(a);
			command.inserir(a);
			conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}


	}





}
