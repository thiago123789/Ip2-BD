package poo.dados.DAO;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import poo.negocios.beans.Localizacao;

public class LocalizacaoDAO {
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
	
	public boolean inserir(Localizacao l){
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
	
	public int idLocalizacao(){
		int id = -1;
		
		
		return id;
	}
	
	
	
	
}
