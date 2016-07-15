 package poo.dados.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.ILocalizacaoDAO;
import poo.negocios.beans.Localizacao;

public class LocalizacaoDAO implements ILocalizacaoDAO{
	private static LocalizacaoDAO instance;
	private ConnectionBanco bancoConnect;

	public static LocalizacaoDAO getInstance(){
		if(instance == null){
			instance = new LocalizacaoDAO();
		}
		return instance;
	}

	private LocalizacaoDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	public boolean inserir(Localizacao l) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.localizacao(SALA, PREDIO) "
                                + "values(?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setInt(1, l.getSala());
			smt.setString(2, l.getPredio());
			smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}

	public boolean atualizar(Localizacao l) throws SQLException{
		boolean atualizou = false;
		String query = "UPDATE deinfo.localizacao SET SALA = ?, PREDIO = ? WHERE ID = ?";
		try{
			PreparedStatement smt = bancoConnect.retornoStatement(query);
			smt.setInt(1, l.getSala());
			smt.setString(2, l.getPredio());
			smt.setInt(3, l.getCodigo());
			smt.execute();
			atualizou = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atualizou;
	}


	public ArrayList<Localizacao> listar(){
		ArrayList<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
		Connection conexao = bancoConnect.getConexao();
		String query = "SELECT * FROM deinfo.localizacao";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				int id = rs.getInt(1);
				int sala = rs.getInt(2);
				String predio = rs.getString(3);
				Localizacao aux = new Localizacao(predio, sala);
				aux.setCodigo(id);
				listaLocalizacoes.add(aux);
			}
//			conexao.commit();
		}catch(SQLException e){
//			try {
//				conexao.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}
		return listaLocalizacoes;
	}


}
