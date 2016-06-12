package poo.dados.DAO;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import poo.negocios.beans.OfertaDisciplina;

public class OfertaDisciplinaDAO {
	private static OfertaDisciplinaDAO instance;
	private ConnectionBanco bancoConnect;

	public static OfertaDisciplinaDAO getInstance(){
		if(instance == null){
			instance = new OfertaDisciplinaDAO();
		}
		return instance;
	}

	private OfertaDisciplinaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	public boolean inserir(OfertaDisciplina offer){
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.oferta_disciplina(ano, semetrstre, disciplina_oferta, localizalicao) "
				+ "values(?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setInt(1, offer.getAno());
			smt.setInt(2, offer.getSemestre());
			smt.setString(3, offer.getDisciplina().getCodigo());
			smt.setInt(4, offer.getLocal().getCodigo());
			smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}


}
