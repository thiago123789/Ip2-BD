package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MatriculaDAO {
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

	public boolean inserir(String cpf, int oferta){
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.matricula(CPF_ALUNO, ID_OFERTA) values(?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
			smt.setString(1, cpf);
            smt.setInt(2, oferta);
			smt.execute();
			inseriu = true;
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}

	



}
