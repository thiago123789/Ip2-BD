//CLASSE PARA DAVI;
package poo.negocios.beans.davi;

public class SubArea {
	private String nomeSubPesquisa;
	private String codigoSubPesquisa;
	
public SubArea(String nomeSubPesquisa, String codigoSubPesquisa){
	this.setNomeSubPesquisa(nomeSubPesquisa);
	this.setCodigoSubPesquisa(codigoSubPesquisa);
}
public String getNomeSubPesquisa(){
	return this.nomeSubPesquisa;
}
public String getCodigoSubPesquisa(){
	return this.codigoSubPesquisa;
}
public void setNomeSubPesquisa(String nomeSubPesquisa){
	if(nomeSubPesquisa != null){
		this.nomeSubPesquisa = nomeSubPesquisa;
	}
}
public void setCodigoSubPesquisa(String codigoSubPesquisa){
	if(codigoSubPesquisa != null){
		this.codigoSubPesquisa = codigoSubPesquisa;
	}
}
}
