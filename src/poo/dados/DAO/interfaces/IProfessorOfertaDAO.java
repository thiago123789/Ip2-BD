package poo.dados.DAO.interfaces;

import java.util.ArrayList;

import poo.negocios.beans.ProfessorOferta;

public interface IProfessorOfertaDAO {
	public boolean inserir(ProfessorOferta po);
	public ArrayList<ProfessorOferta> listar();
}
