/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.DepartamentoDAO;
import poo.negocios.beans.Departamento;

/**
 *
 * @author Thiago Gomes
 */
public class ListarDepartamentos {
	private static ListarDepartamentos instance;
    private DepartamentoDAO comand;
    
    public static ListarDepartamentos getInstance(){
    	if(instance == null){
    		instance = new ListarDepartamentos();
    	}
    	return instance;
    }
    
    private ListarDepartamentos(){
        comand = DepartamentoDAO.getInstance();
    }
    
    public String[] listaDepartamentosPorNome(){
    	ArrayList<Departamento> aux = comand.consulta();
    	String[] total = new String[aux.size()];
    	int i = 0;
    	for(Departamento a : aux){
    		total[i] = a.getNome();
    		i++;
    	}    	
    	return total;
    }
    
    public ArrayList<String> listaDepartamentosPorNomeList(){
    	ArrayList<Departamento> aux = comand.consulta();
    	ArrayList<String> total = new ArrayList<String>();
    	int i = 0;
    	for(Departamento a : aux){
    		total.add(a.getNome());
    	}    	
    	return total;
    }
    
}
