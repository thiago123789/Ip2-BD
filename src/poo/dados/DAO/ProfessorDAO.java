package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Departamento;
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
		String query = "INSERT INTO deinfo.professor(CPF_PROF, EXTERNO, IES, TITULACAO, DEPAT_PROF) values(?,?,?,?,?)";
		try{
			PreparedStatement smt = bancoConnect.retornoStatement(query);
			smt.setString(1, p.getCpf());
			smt.setString(2, p.getIes());
			smt.setString(3, p.getTitulo());
			smt.setInt(4, p.getDepartamento().getId());
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
				String ies = rs.getString(2);
				String titulo = rs.getString(3);
				int depat = rs.getInt(4);
				Professor aux = new Professor(cpf);
				aux.setIes(ies);
				aux.setTitulo(titulo);
				aux.setDepartamento(new Departamento(depat));
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
