package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.negocios.beans.Pessoa;
import poo.negocios.beans.Professor;

public class ListarProfessores {
	private IProfessorDAO prof;
	private IPessoaDAO pessoa;
	private static ListarProfessores instance;
	
	public static ListarProfessores getInstance(){
		if(instance == null){
			instance = new ListarProfessores();
		}
		return instance;
	}
	
	private ListarProfessores(){
		prof = ProfessorDAO.getInstance();
		pessoa = PessoaDAO.getInstance();
	}
	
	public Pessoa buscarPessoa(String cpf){
		Pessoa p = null;
		ArrayList<Pessoa> listaPessoas;
		try {
			listaPessoas = pessoa.listar();
			for(Pessoa aux: listaPessoas){
				if(aux.getCpf().equals(cpf)){
					p = aux;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public ArrayList<Professor> listarProfessores(){
		ArrayList<Professor> listProf = prof.listar();
		ArrayList<Professor> retorno = new ArrayList<Professor>();
		for(Professor p : listProf){
			Pessoa aux = this.buscarPessoa(p.getCpf());
			if(aux != null){
				p.setPnome(aux.getPnome());
				p.setUnome(aux.getUnome());
				retorno.add(p);
			}			
		}
		return retorno;
	}	
	

}
