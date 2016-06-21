package poo.negocios;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Pessoa;

public class BuscaAvancada {
	private static BuscaAvancada instance;
	private IDisciplinaDAO command;

	public static BuscaAvancada getInstance(){
		if(instance == null){
			instance = new BuscaAvancada();
		}
		return instance;
	}

	private BuscaAvancada(){
		command = DisciplinaDAO.getInstance();
	}

	public ArrayList<Disciplina> searchAdvanced(String nom){
		ArrayList<Disciplina> listando = command.listar();
		ArrayList<Disciplina> retorno = null;
		retorno = new ArrayList<Disciplina>();
		for(Disciplina aux : listando){
			if(unAccent(aux.getNome()).contains(nom.toUpperCase())){
				if(!retorno.contains(aux)){
					retorno.add(aux);
				}
			}
		}
		return retorno;
	}

	public ArrayList<Disciplina> searchAdvancedVariasChaves(ArrayList<String> chaves){
		ArrayList<Disciplina> retorno = null;
		retorno = new ArrayList<Disciplina>();
		for(String a : chaves){
			if(a != null){
				ArrayList<Disciplina> listando = this.searchAdvanced(a);
				for(Disciplina aux : listando){
					if(unAccent(aux.getNome()).contains(a.toUpperCase())){
						if(!retorno.contains(aux)){
							retorno.add(aux);
						}
					}
				}
			}
		}
		return retorno;
	}

	public static String unAccent(String s) {
	    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(temp).replaceAll("");
	}




}
