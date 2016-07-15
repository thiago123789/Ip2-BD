package poo.negocios;

import java.sql.Connection;
import java.sql.SQLException;

import poo.dados.DAO.AvaliacaoOfertaDAO;
import poo.dados.DAO.ConnectionBanco;
import poo.dados.DAO.interfaces.IAvaliacaoOfertaDAO;
import poo.dados.DAO.interfaces.IBancoConnection;
import poo.negocios.beans.AvaliacaoOferta;

public class AvaliarAluno {
	private static AvaliarAluno instance;
	private IAvaliacaoOfertaDAO ava;
	private IBancoConnection banco;

	public static AvaliarAluno getInstance(){
		if(instance == null){
			instance = new AvaliarAluno();
		}
		return instance;
	}

	private AvaliarAluno(){
		ava = AvaliacaoOfertaDAO.getInstance();
		banco = ConnectionBanco.getInstance();
	}

	public void avaliar(AvaliacaoOferta av){
		Connection conexao = banco.getConexao();
		try{
			ava.atualizar(av);
			conexao.commit();
			System.out.println("Sucesso");
		}catch(SQLException e){
			try {
				conexao.rollback();
				System.out.println("Falha "+e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}


	}



}
