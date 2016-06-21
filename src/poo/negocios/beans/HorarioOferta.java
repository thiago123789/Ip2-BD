package poo.negocios.beans;

public class HorarioOferta {
	private int codigoOferta, codigoHorario;

	public HorarioOferta(int codigoOfert, int codigoHora){
		this.setCodigoHorario(codigoOfert);
		this.setCodigoOferta(codigoHora);
	}

	public int getCodigoOferta() {
		return codigoOferta;
	}

	public void setCodigoOferta(int codigoOferta) {
		this.codigoOferta = codigoOferta;
	}

	public int getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}




}
