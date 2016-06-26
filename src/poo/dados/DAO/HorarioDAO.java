package poo.dados.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IHorarioDAO;
import poo.negocios.beans.Horario;

public class HorarioDAO implements IHorarioDAO{
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

	public boolean inserir(Horario a) throws SQLException{
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.horario(DIA, HORA_INICIO, HORA_FIM) values(?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
			smt.setString(1, a.getDia());
			smt.setTime(2, a.getHoraInicio());
			smt.setTime(3, a.getHoraTermino());
			smt.execute();
			inseriu = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return inseriu;
	}

	public boolean atualizar(Horario a) throws SQLException{
		boolean atualizou = false;
		String query = "UPDATE deinfo.horario SET DIA = ?, HORA_INICIO = ?, HORA_FIM = ? WHERE ID = ?";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
			smt.setString(1, a.getDia());
			smt.setTime(2, a.getHoraInicio());
			smt.setTime(3, a.getHoraTermino());
			smt.setInt(4, a.getId());
			smt.execute();
			atualizou = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atualizou;
	}
	
	
	enum MyEnum{
		DOM(1), SEG(2), TER(3), QUA(4), QUI(5), SEX(6), SAB(7);
		int valorDia;
		MyEnum(int valor){
			this.valorDia =valor;
		}
		public int getValorDia() {
			return valorDia;
		}
	}
	
	public ArrayList<Horario> listar() throws SQLException{
		ArrayList<Horario> listaHorarios = new ArrayList<Horario>();
		String query = "SELECT * FROM deinfo.horario";
		try{
			ResultSet rs = bancoConnect.comandoSQL(query);
			while(rs.next()){
				int id = rs.getInt("ID");
				MyEnum dia1 = MyEnum.valueOf(rs.getString("DIA"));
				int dia = dia1.getValorDia();
				Time hora_inicio = rs.getTime("HORA_INICIO");
				Time hora_termino = rs.getTime("HORA_FIM");
			
				Horario h = new Horario();
				h.setId(id);
				h.setDia(dia1.toString());
				h.setHoraInicio(hora_inicio);
				h.setHoraTermino(hora_termino);
				listaHorarios.add(h);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listaHorarios;
	}

	public boolean remover(Horario h) throws SQLException{
		boolean removeu = false;
		String query = "DELETE FROM deinfo.horario WHERE ID = "+h.getId();
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(query);
			smt.execute();
			removeu = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return removeu;
	}



}
