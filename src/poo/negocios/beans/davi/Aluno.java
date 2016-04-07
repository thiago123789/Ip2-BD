//CLASSE P/ DAVI
package poo.negocios.beans.davi;

import poo.excecoes.CPFInvalidoException;

public class Aluno extends Pessoa{
    private String nome;
    
    public Aluno(String nome, String cpf) throws CPFInvalidoException {
	super(nome, cpf);
	// TODO Auto-generated constructor stub
    }
	
}
