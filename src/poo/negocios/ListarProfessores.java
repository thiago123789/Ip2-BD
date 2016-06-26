package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Pessoa;
import poo.negocios.beans.Professor;

public class ListarProfessores {
	private IProfessorDAO prof;
	private IPessoaDAO pessoa;
	private IDepartamentoDAO depat;
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
		depat = DepartamentoDAO.getInstance();
	}
	
	private Pessoa buscarPessoa(String cpf){
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
	
	public Professor buscarProfessorPorCPF(String cpf){
		Professor retorno = null;
		try {
			retorno = new Professor(cpf);
		} catch (CPFInvalidoException e) {
			System.out.println("\n\nInvalido >>>> "+ cpf);
			e.printStackTrace();
		}
		Pessoa temp = this.buscarPessoa(cpf);
		ArrayList<Professor> professores = prof.listar();
		for(Professor aux : professores){
			if(aux != null && temp != null){
				if(aux.getCpf().equals(temp.getCpf())){
					retorno = aux;
					break;
				}
			}
		}
		
		retorno.setPnome(temp.getPnome());
		retorno.setUnome(temp.getUnome());
		retorno.setEmail(temp.getEmail());
		retorno.setSexo(temp.getSexo());
		retorno.setDataNascimento(temp.getDataNascimento());
		System.out.println("Professor na busca" + retorno);
		return retorno;
	}
	
	
	
	public ArrayList<Professor> listarProfessores(){
		ArrayList<Professor> listProf = prof.listar();
		ArrayList<Professor> retorno = new ArrayList<Professor>();
		for(Professor p : listProf){
			Professor aux = this.buscarProfessorPorCPF(p.getCpf());
			retorno.add(aux);		
		}
		return retorno;
	}	
	
	public int buscarIdDepartamento(String nomeDepartamento){
		int id = -1;
		try {
			ArrayList<Departamento> listaDepat = depat.listar();
			for(Departamento aux : listaDepat){
				if(aux.getNome().equals(nomeDepartamento)){
					id = aux.getId();
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	public ArrayList<Professor> listarProfessoresPorDepartamento(String departamento){
		ArrayList<Professor> retorno = new ArrayList<Professor>();
		ArrayList<Professor> listaProfessor = prof.listar();
		int idDepartamento = this.buscarIdDepartamento(departamento);
		for(Professor aux : listaProfessor){
			if(aux.getDepartamento().getId() == idDepartamento){
				if(!retorno.contains(aux)){
					Professor temp = this.buscarProfessorPorCPF(aux.getCpf());
					retorno.add(temp);
				}
			}
		}
		return retorno;
	}
	

}
