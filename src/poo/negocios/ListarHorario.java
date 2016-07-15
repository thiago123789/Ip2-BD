package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.HorarioDAO;
import poo.dados.DAO.interfaces.IHorarioDAO;
import poo.negocios.beans.Horario;

public class ListarHorario {
	private IHorarioDAO hora;
	private static ListarHorario instance;

	public static ListarHorario getInstance(){
		if(instance == null){
			instance = new ListarHorario();
		}
		return instance;
	}

	private ListarHorario(){
		hora = HorarioDAO.getInstance();
	}

	public ArrayList<Horario> listarHorarios(){
		ArrayList<Horario> retorno = null;
		retorno = hora.listar();
		return retorno;
	}


}
