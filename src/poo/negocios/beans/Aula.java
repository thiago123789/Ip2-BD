package poo.negocios.beans;

import poo.excecoes.DiaNaoSelecionadoException;
import poo.excecoes.HorarioInvalidoException;
import poo.excecoes.HorarioInvalidoTMQIException;
import poo.excecoes.MinutosInvalidosException;

public class Aula {
	private int dia, horaInicio, minutosInicio, horaTermino, minutosTermino;
	
	public Aula(int dia, int horaInicio,int minutosInicio,
                int horaTermino, int minutosTermino) 
					throws HorarioInvalidoException, MinutosInvalidosException,
					HorarioInvalidoTMQIException, DiaNaoSelecionadoException
	{
		this.setDia(dia);
		this.setHorarioInicioCompleto(horaInicio, minutosInicio);
        this.setHorarioTerminoCompleto(horaTermino, minutosTermino);
	}

	public void setHorarioTerminoCompleto(int horas, int minutos) 
			throws HorarioInvalidoException, MinutosInvalidosException, 
			HorarioInvalidoTMQIException{
		if(horas >= 00 && horas <= 23){
			if(horas < this.horaInicio){
				throw new HorarioInvalidoTMQIException();
			}else if(horas == this.horaInicio){
				if(minutos < this.minutosInicio){
					throw new HorarioInvalidoTMQIException();
				}
			}else{
				this.setHoraTermino(horas);
			}
		}else{
			throw new HorarioInvalidoException();
		}

		if(minutos>= 00 && minutos <= 59){
			this.setMinutosTermino(minutos);
		}else{
			throw new MinutosInvalidosException();
		}
	}

	public void setHorarioInicioCompleto(int horas, int minutos) 
			throws HorarioInvalidoException, MinutosInvalidosException{
		if(horas >= 00 && horas <= 23){
			this.setHoraInicio(horas);
		}else{
			throw new HorarioInvalidoException();
		}
		
		if(minutos>= 00 && minutos <= 59){
			this.setMinutosInicio(minutos);
		}else{
			throw new MinutosInvalidosException();
		}
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws DiaNaoSelecionadoException{
            if(dia != -1){
            	this.dia = dia;
            }else{
                throw new DiaNaoSelecionadoException();
            }
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	private void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraTermino() {
		return horaTermino;
	}

	private void setHoraTermino(int horaTermino) {
		this.horaTermino = horaTermino;
	}

	public int getMinutosInicio() {
		return minutosInicio;
	}

	private void setMinutosInicio(int minutosInicio) {
		this.minutosInicio = minutosInicio;
	}

	public int getMinutosTermino() {
		return minutosTermino;
	}

	private void setMinutosTermino(int minutosTermino) {
		this.minutosTermino = minutosTermino;
	}
	
	private String returnDia(){
		String dia = null;
		switch (this.dia) {
		case 2:
			dia = "Segunda";
			break;
		case 3:
			dia = "Terca";
			break;
		case 4:
			dia = "Quarta";
			break;
		case 5:
			dia = "Quinta";
			break;
		case 6:
			dia = "Sexta";
			break;
		default:
			break;
		}
		return dia;
		
	}
	
	public String toString(){
		return this.returnDia()+" "+this.horaInicio+":"+
	this.minutosInicio+"/"+this.horaTermino+":"+this.minutosTermino;
	}
	
	
	
}
