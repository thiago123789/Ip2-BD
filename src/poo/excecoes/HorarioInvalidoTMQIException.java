package poo.excecoes;

public class HorarioInvalidoTMQIException extends Exception{
	public HorarioInvalidoTMQIException(){
		super("Hora final menor que inicial, verifique o valor inserido");
	}
}
