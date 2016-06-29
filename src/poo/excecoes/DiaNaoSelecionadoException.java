package poo.excecoes;

public class DiaNaoSelecionadoException extends Exception{
	public DiaNaoSelecionadoException(){
		super("Selecione um dia");
	}
}
