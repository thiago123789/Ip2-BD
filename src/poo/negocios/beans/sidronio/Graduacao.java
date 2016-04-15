package poo.negocios.beans.sidronio;
import poo.negocios.beans.davi.*;
import poo.negocios.beans.veneranda.*;
public class Graduacao extends {

	private Professor coordenador,vice;
	private Funcionario secretario;
	private int codigo;
	
	public Graduacao(Professor coordenador, Professor vice, Funcionario secretario, int codigo){
		this.coordenador=coordenador;
		this.vice=vice;
		this.secretario=secretario;
		this.codigo=codigo;
	}
	
	public Graduacao(){
		
	}

	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}

	public Professor getVice() {
		return vice;
	}

	public void setVice(Professor vice) {
		this.vice = vice;
	}

	public Funcionario getSecretario() {
		return secretario;
	}

	public void setSecretario(Funcionario secretario) {
		this.secretario = secretario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Graduacao [codigo=" + codigo + "]";
	}

	
	
	
}
