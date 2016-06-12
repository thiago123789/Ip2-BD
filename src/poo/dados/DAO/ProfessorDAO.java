package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.negocios.beans.Professor;

public class ProfessorDAO implements IProfessorDAO{
	private static ProfessorDAO instance;
	private ConnectionBanco bancoConnect;

	public static ProfessorDAO getInstance(){
		if(instance == null){
			instance = new ProfessorDAO();
		}
		return instance;
	}

	public ProfessorDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	//CPF_PROF, EXTERNO, IES, TITULACAO
	public boolean inserir(Professor p) throws SQLException{
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.professor(CPF_PROF, EXTERNO, IES, TITULACAO) values(?,?,?,?)";
		try{
			PreparedStatement smt = bancoConnect.retornoStatement(query);
			smt.setString(1, p.getCpf());
			smt.setString(2, p.getExterno());
			smt.setString(3, p.getIes());
			smt.setString(4, p.getTitulo());
			smt.execute();
			inseriu = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return inseriu;
	}


}
