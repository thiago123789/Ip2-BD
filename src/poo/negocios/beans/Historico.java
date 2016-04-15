package poo.negocios.beans;

import java.util.ArrayList;

public class Historico {
	private ArrayList<OfertaDisciplina> ofertasDisciplinas;
	
	public Historico(ArrayList<OfertaDisciplina> ofertaDisciplinas){
		this.setOfertaDisciplinas(ofertaDisciplinas);
	}
	
	public void setOfertaDisciplinas(ArrayList<OfertaDisciplina> array){
		this.ofertasDisciplinas = array;
	}
	
	public ArrayList<OfertaDisciplina> getOfertaDisciplinas(){
		return this.ofertasDisciplinas;
	}
	
}
