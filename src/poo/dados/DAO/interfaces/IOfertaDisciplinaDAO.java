package poo.dados.DAO.interfaces;

import java.util.ArrayList;

import poo.negocios.beans.OfertaDisciplina;

public interface IOfertaDisciplinaDAO {
	public int inserir(OfertaDisciplina offer);
	public ArrayList<OfertaDisciplina> listar();
}
