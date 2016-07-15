package poo.dados.DAO.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.negocios.beans.HorarioOferta;

public interface IHorarioOfertaDAO {
	public boolean inserir(int oferta, int horario) throws SQLException;
	public ArrayList<HorarioOferta> listar();
}
