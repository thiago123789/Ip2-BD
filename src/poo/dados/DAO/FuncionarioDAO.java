package poo.dados.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import poo.negocios.beans.Funcionario;

public class FuncionarioDAO implements IFuncionarioDAO{
	private static FuncionarioDAO instance;
	private ConnectionBanco connection;

	public static FuncionarioDAO getInstance(){
		if(instance == null){
			instance = new FuncionarioDAO();
		}
		return instance;
	}

	private FuncionarioDAO(){
		connection = ConnectionBanco.getInstance();
	}

	public void inserir(Funcionario func) throws SQLException{
		String query = "INSERT INTO deinfo.funcionario(CPF_FUNCIONARIO, CARGO, TIPO_FUNCIONARIO) values(?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) connection.comandoSQL(query);
			smt.setString(1, func.getCpf());
			smt.setInt(2, func.getCargo().getCodigo());
			smt.setInt(3, func.isProfessor()?1:0);
			smt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean atualizar(Funcionario atua){
		
	}


}
