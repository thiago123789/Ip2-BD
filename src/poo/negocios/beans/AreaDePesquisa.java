//CLASSE PARA DAVI;
package poo.negocios.beans;

import java.util.ArrayList;

public class AreaDePesquisa {
	private String nomePesquisa;
	private String codigoPesquisa;
	private ArrayList<SubArea> subAreas;
	
public AreaDePesquisa(String nomePesquisa, String codigoPesquisa, ArrayList<SubArea> subAreas){
	this.setNomePesquisa(nomePesquisa);
	this.setCodigoPesquisa(codigoPesquisa);
	this.subAreas = new ArrayList<SubArea>();
}
public String getNomePesquisa(){
	return this.nomePesquisa;
}
public String getCodigoPesquisa(){
	return this.codigoPesquisa;
}
public ArrayList<SubArea> getSubAreas(){
	return this.subAreas;
}
public void setSubAreas(ArrayList<SubArea> subAreas){
	if(subAreas != null){
		this.subAreas = subAreas;
	}
}
public void setNomePesquisa(String nomePesquisa){
	if(nomePesquisa != null){
		this.nomePesquisa = nomePesquisa;
	}
}
public void setCodigoPesquisa(String codigoPesquisa){
	if(codigoPesquisa != null){
		this.codigoPesquisa = codigoPesquisa;
	}
}
}
