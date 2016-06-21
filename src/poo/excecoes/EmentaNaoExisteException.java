package poo.excecoes;

public class EmentaNaoExisteException extends Exception{
	public EmentaNaoExisteException(){
		super("Arquivo da ementa não existe");
	}
}
