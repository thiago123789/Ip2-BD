package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.excecoes.CPFInvalidoException;
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

	public ArrayList<Professor> listar(){
		ArrayList<Professor> retorno = new ArrayList<Professor>();
		String query = "SELECT * FROM deinfo.professor";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				String cpf = rs.getString(1);
				boolean externo = rs.getBoolean(2);
				String ies = rs.getString(3);
				String titulo = rs.getString(4);
				Professor aux = new Professor(cpf);
				aux.setIes(ies);
				aux.setTitulo(titulo);
				retorno.add(aux);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(CPFInvalidoException e){
			e.printStackTrace();
		}
		return retorno;
	}

}
