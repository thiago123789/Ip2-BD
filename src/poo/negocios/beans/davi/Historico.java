package poo.negocios.beans.davi;

import java.util.ArrayList;

import poo.negocios.beans.veneranda.OfertaDisciplina;

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
