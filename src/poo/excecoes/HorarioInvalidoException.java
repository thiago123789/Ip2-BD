package poo.excecoes;

public class HorarioInvalidoException extends Exception{
	public HorarioInvalidoException(){
		super("Hora invalida, digite um valor entre 00 e 23");
	}
}
