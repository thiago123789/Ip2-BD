package poo.excecoes;

public class CadastroAlunoExistenteException extends Exception{
	public CadastroAlunoExistenteException()
	{
		super("Aluno ja cadastrado!!");
	}
}
