package poo.dados.DAO;

public class OfertaDisciplinaDAO {
	private static OfertaDisciplinaDAO instance;
	private ConnectionBanco bancoConnect;
	
	public static OfertaDisciplinaDAO getInstance(){
		if(instance == null){
			instance = new OfertaDisciplinaDAO();
		}
		return instance;
	}
	
	private OfertaDisciplinaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}
	
	public boolean inserir(){
		boolean inseriu = false;
		
		
		
		return inseriu;
	}
	
	
}
