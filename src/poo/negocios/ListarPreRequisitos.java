/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.negocios.beans.Disciplina;

/**
 *
 * @author Thiago Gomes
 */
public class ListarPreRequisitos {
    private DisciplinaDAO command;
    private PreRequisitoDAO commandA;
    
    public ListarPreRequisitos(){
    	command = new DisciplinaDAO();
    	commandA = new PreRequisitoDAO();
    }
    
    private ArrayList<Disciplina> listarPreRequisitos(String cod){
    		ArrayList<Disciplina> aux = new ArrayList<Disciplina>();
    		ArrayList<String> nomePre = commandA.buscaPre(cod);
    		for(String a : nomePre){
    			Disciplina temp = command.buscaCN(a);
    			aux.add(temp);
    		}
    		return aux;
    }
    
    public ArrayList<String> listarCodigosPreRequisitos(String cod){
    	ArrayList<Disciplina> aux = this.listarPreRequisitos(cod);
    	ArrayList<String> retorno = new ArrayList<String>();
    	for(Disciplina a : aux){
    		retorno.add(a.getCodigo());
    	}    	
    	return retorno;
    }
    
    public ArrayList<String> listarNomesPreRequisitos(String cod){
    	ArrayList<Disciplina> aux = this.listarPreRequisitos(cod);
    	ArrayList<String> retorno = new ArrayList<String>();
    	for(Disciplina a : aux){
    		retorno.add(a.getNome());
    	}    	
    	return retorno;
    }
    
    
    
}
