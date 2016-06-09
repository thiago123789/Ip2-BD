package poo.excecoes;

public class MinutosInvalidosException extends Exception{
	public MinutosInvalidosException(){
		super("Valor para minutos invalido, digite um valor entre 00 e 59");
	}
}
