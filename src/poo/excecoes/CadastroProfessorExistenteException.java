package poo.excecoes;

public class CadastroProfessorExistenteException extends Exception
{
	public CadastroProfessorExistenteException()
	{
		super("Professor ja cadastrado!!");
	}
}
