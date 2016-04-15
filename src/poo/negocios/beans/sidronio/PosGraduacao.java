package poo.negocios.beans.sidronio;

import poo.negocios.beans.davi.AreaDePesquisa;
import poo.negocios.beans.davi.SubArea;

public class PosGraduacao extends Curso{

	private int codigo;
	private boolean mestrado,doutorado;
	private String especialidade;
	private AreaDePesquisa area;
	private SubArea sub_area;
	
	public PosGraduacao(int codigo, String especialidade, AreaDePesquisa area, SubArea sub_area){
		this.setCodigo(codigo);
		this.setArea(area);
		this.setSub_area(sub_area);

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTipo(int op){
		if(op == 0){
			this.setMestrado(true);
			this.setDoutorado(false);
		}else{
			this.setMestrado(false);
			this.setDoutorado(true);
		}
	}
		
	///QUE PORRA É ISSO ?????????
	public boolean isMestrado() {
		return mestrado;
	}

	///SET ALTERADO PARA PRIVADO
	private void setMestrado(boolean mestrado) {
		this.mestrado = mestrado;
	}

	///QUE KRALHO É ESSE ????????
	public boolean isDoutorado() {
		return doutorado;
	}

	///SET ALTERADO PARA PRIVADO
	private void setDoutorado(boolean doutorado) {
		this.doutorado = doutorado;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public AreaDePesquisa getArea() {
		return area;
	}

	public void setArea(AreaDePesquisa area) {
		this.area = area;
	}

	public SubArea getSub_area() {
		return sub_area;
	}

	public void setSub_area(SubArea sub_area) {
		this.sub_area = sub_area;
	}

	@Override
	public String toString() {
		return "PosGraduacao [codigo=" + codigo + ", mestrado=" + mestrado + ", doutorado=" + doutorado
				+ ", especialidade=" + especialidade + ", area=" + area + ", sub_area=" + sub_area + "]";
	}
	
	
	
}
	