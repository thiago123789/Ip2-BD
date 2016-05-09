package poo.dados.DAO;

public class HorarioDAO {
	private static HorarioDAO instance;
	private ConnectionBanco bancoConnect;
	
	public static HorarioDAO getInstance(){
		if(instance == null){
			instance = new HorarioDAO();
		}
		return instance;
	}
	
	private HorarioDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}
	
	public boolean inserir(){
		boolean inseriu = false;
		
		
		
		
		return inseriu;
	}
	
	
	
	
	
}
