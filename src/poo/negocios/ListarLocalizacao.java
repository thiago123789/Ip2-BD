package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.LocalizacaoDAO;
import poo.dados.DAO.interfaces.ILocalizacaoDAO;
import poo.negocios.beans.Localizacao;

public class ListarLocalizacao {
	private ILocalizacaoDAO local;
	private static ListarLocalizacao instance;

	public static ListarLocalizacao getInstance(){
		if(instance == null){
			instance = new ListarLocalizacao();
		}
		return instance;
	}

	private ListarLocalizacao(){
		local = LocalizacaoDAO.getInstance();
	}

	public ArrayList<String> listaPredios(){
		ArrayList<String> retorno = new ArrayList<String>();
		ArrayList<Localizacao> listaLocal = local.listar();
		for(Localizacao a: listaLocal){
			if(!retorno.contains(a.getPredio())){
				retorno.add(a.getPredio());
			}
		}
		return retorno;
	}

	public ArrayList<Integer> listaSalasPorPredio(String predio){
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		ArrayList<Localizacao> listaLocal;

		listaLocal = local.listar();
		for(Localizacao a: listaLocal){
			if(a.getPredio().equals(predio)){
				retorno.add(a.getSala());
			}
		}

		return retorno;
	}

	public int buscarIdLocalizacao(String predio, int sala){
		int id = -1;
		ArrayList<Localizacao> listaLocal;

		listaLocal = local.listar();
		for(Localizacao a: listaLocal){
			if(a.getPredio().equals(predio) && a.getSala() == sala){
				id = a.getCodigo();
				break;
			}
		}

		return id;
	}




}
