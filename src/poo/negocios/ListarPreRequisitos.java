/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.PreRequisito;

public class ListarPreRequisitos {
	private static ListarPreRequisitos instance;
	private IDisciplinaDAO command;
	private IPreRequisitoDAO commandA;

	public static ListarPreRequisitos getInstance(){
		if(instance == null){
			instance = new ListarPreRequisitos();
		}
		return instance;
	}

	public ListarPreRequisitos(){
		command = DisciplinaDAO.getInstance();
		commandA = PreRequisitoDAO.getInstance();
	}

	public Disciplina buscarDisciplina(String codigo){
		Disciplina retorno = null;
		ArrayList<Disciplina> listando = command.listar();
		for(Disciplina aux : listando){
			if(aux.getCodigo().equals(codigo)){
				retorno = aux;
			}
		}
		return retorno;
	}

	private ArrayList<Disciplina> listarPreRequisitos(String cod) throws SQLException{
		ArrayList<Disciplina> retorno = new ArrayList<Disciplina>();
		ArrayList<PreRequisito> nomePre = commandA.listar();
		for(PreRequisito a : nomePre){
			if(a.getDisciplina().getCodigo().equals(cod)){
				retorno.add(this.buscarDisciplina(a.getPreRequisito().getCodigo()));
			}
		}
		return retorno;
	}

	public ArrayList<String> listarCodigosPreRequisitos(String cod) throws SQLException{
		ArrayList<Disciplina> aux = this.listarPreRequisitos(cod);
		ArrayList<String> retorno = new ArrayList<String>();
		for(Disciplina a : aux){
			retorno.add(a.getCodigo());
		}
		return retorno;
	}

	public ArrayList<String> listarNomesPreRequisitos(String cod) throws SQLException{
		ArrayList<Disciplina> aux = this.listarPreRequisitos(cod);
		ArrayList<String> retorno = new ArrayList<String>();
		for(Disciplina a : aux){
			retorno.add(a.getNome());
		}
		return retorno;
	}



}
