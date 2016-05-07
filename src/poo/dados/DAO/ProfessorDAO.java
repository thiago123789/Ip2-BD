package poo.dados.DAO;

public class ProfessorDAO {
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
	
}
