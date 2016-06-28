package poo.dados.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IProfessorOfertaDAO;
import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.OfertaDisciplina;
import poo.negocios.beans.Professor;
import poo.negocios.beans.ProfessorOferta;

public class ProfessorOfertaDAO implements IProfessorOfertaDAO{
	private static ProfessorOfertaDAO instance;
	private ConnectionBanco bancoConnect;

	public static ProfessorOfertaDAO getInstance(){
		if(instance == null){
			instance = new ProfessorOfertaDAO();
		}
		return instance;
	}

	private ProfessorOfertaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}


	//PROF_OFERTA, OFERTA_COD
	public boolean inserir(ProfessorOferta po){
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.professor_oferta_disciplina(PROF_OFERTA, OFERTA_COD) values(?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
			smt.setString(1, po.getProfessor().getCpf());
			smt.setInt(2, po.getOffer().getCodigo());
			smt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return inseriu;
	}

	public ArrayList<ProfessorOferta> listar(){
		ArrayList<ProfessorOferta> retorno = new ArrayList<ProfessorOferta>();
		String query = "SELECT * FROM deinfo.professor_oferta_disciplina";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				String cpf = rs.getString("PROF_OFERTA");
				int codigo = rs.getInt("OFERTA_COD");
				ProfessorOferta aux = new ProfessorOferta(new Professor(cpf), new OfertaDisciplina(codigo));
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
