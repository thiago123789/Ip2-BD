package poo.dados.DAO;

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
	
	public boolean inserir(){
		boolean inseriu = false;
		
		
		
		return inseriu;
	}
	
	
	
}
