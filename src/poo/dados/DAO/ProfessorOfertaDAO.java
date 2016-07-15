package poo.dados.DAO;

import java.sql.Connection;
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
	public boolean inserir(String cpf, int id) throws SQLException{
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.professor_oferta_disciplina(PROF_OFERTA, OFERTA_COD) values(?,?)";

		PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
		smt.setString(1, cpf);
		smt.setInt(2, id);
		smt.executeUpdate();

		return inseriu;
	}



	public ArrayList<ProfessorOferta> listar(){
		ArrayList<ProfessorOferta> retorno = new ArrayList<ProfessorOferta>();
		Connection conexao = bancoConnect.getConexao();
		String query = "SELECT * FROM deinfo.professor_oferta_disciplina";
		try{

			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				String cpf = rs.getString("PROF_OFERTA");
				int codigo = rs.getInt("OFERTA_COD");
				ProfessorOferta aux = new ProfessorOferta(new Professor(cpf), new OfertaDisciplina(codigo));
				retorno.add(aux);
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
		}catch(CPFInvalidoException e){
			e.printStackTrace();
		}
		return retorno;
	}


}
