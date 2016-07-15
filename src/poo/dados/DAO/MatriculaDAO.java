package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.IMatriculaDAO;
import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Matricula;
import poo.negocios.beans.OfertaDisciplina;

public class MatriculaDAO implements IMatriculaDAO{
	private static MatriculaDAO instance;
	private ConnectionBanco bancoConnect;

	public static MatriculaDAO getInstance(){
		if(instance == null){
			instance = new MatriculaDAO();
		}
		return instance;
	}

	private MatriculaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	//COD_MATRICULA, CPF_ALUNO, ID_OFERTA, ANO, SEMESTRE, ONUS, DATA_MATRICULA
	public int inserir(Matricula a) throws SQLException{
		int id = 0;
		String query = "INSERT INTO deinfo.matricula(CPF_ALUNO, ID_OFERTA, "
				+ "ANO, SEMESTRE, ONUS) values(?,?,?,?,?)";
		PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
		smt.setString(1, a.getA().getCpf());
		smt.setInt(2, a.getOferta().getCodigo());
		smt.setInt(3, a.getAno());
		smt.setInt(4, a.getSemestre());
		smt.setInt(5, a.haveOnus()?1:0);
		smt.executeUpdate();

                id =1;
		return id;
	}

	//COD_MATRICULA, CPF_ALUNO, ID_OFERTA, ANO, SEMESTRE, ONUS, DATA_MATRICULA
	public ArrayList<Matricula> listar() throws SQLException, CPFInvalidoException{
		ArrayList<Matricula> listaMatriculas = new ArrayList<Matricula>();
		String query = "SELECT * FROM deinfo.matricula";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				int cod = rs.getInt("COD_MATRICULA");
				String cpf = rs.getString("CPF_ALUNO");
				int id_oferta = rs.getInt("ID_OFERTA");
				int ano = rs.getInt("ANO");
				int semestre = rs.getInt("SEMESTRE");
				boolean onus = rs.getBoolean("ONUS");
				Calendar data = null;
				rs.getTimestamp("DATA_MATRICULA", data);
				Matricula mat = new Matricula(new OfertaDisciplina(id_oferta), new Aluno(cpf),ano,semestre);
				mat.setCodigo(cod);
				mat.setOnus(onus);
				mat.setData_matricula(data);
				listaMatriculas.add(mat);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listaMatriculas;
	}





}
