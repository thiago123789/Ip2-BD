package poo.dados.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IHorarioOfertaDAO;
import poo.negocios.beans.HorarioOferta;

public class HorarioOfertaDAO implements IHorarioOfertaDAO{
	private static HorarioOfertaDAO instance;
	private ConnectionBanco bancoConnect;

	public static HorarioOfertaDAO getInstancce(){
		if(instance == null){
			instance = new HorarioOfertaDAO();
		}
		return instance;
	}

	private HorarioOfertaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	//ID_OFERTA, ID_HORARIO
	public boolean inserir(int oferta, int horario) throws SQLException{
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.horarios_ofertas(ID_OFERTA, ID_HORARIO) values(?,?)";
		PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
		smt.setInt(1, oferta);
		smt.setInt(2, horario);
		smt.executeUpdate();
		return inseriu;
	}

	public ArrayList<HorarioOferta> listar(){
		ArrayList<HorarioOferta> retorno = new ArrayList<HorarioOferta>();
		Connection conexao = bancoConnect.getConexao();
		String query = "SELECT * FROM deinfo.horarios_ofertas";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				int oferta = rs.getInt("ID_OFERTA");
				int horario = rs.getInt("ID_HORARIO");
				HorarioOferta aux = new HorarioOferta(oferta, horario);
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
		}
		return retorno;
	}


}
