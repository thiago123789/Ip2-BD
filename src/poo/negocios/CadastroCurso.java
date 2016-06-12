/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;

public class CadastroCurso {
	private static CadastroCurso instance;
    private ICursoDAO comand;
    private IDepartamentoDAO comandA;

    public static CadastroCurso getInstance(){
    	if(instance == null){
    		instance = new CadastroCurso();
    	}
    	return instance;
    }

    private CadastroCurso(){
        comand = CursoDAO.getInstance();
        comandA = DepartamentoDAO.getInstance();
    }

    public int idDepartamento(String nome){
    	int id = 0;
    	try{
    		ArrayList<Departamento> listando = comandA.listar();
    		for(Departamento aux : listando){
    			if(aux.getNome().equals(nome)){
    				id = aux.getId();
    				break;
    			}
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return id;
    }


    public void cadastroCurso(Curso curso){
        int no = this.idDepartamento(curso.getDepat().getNome());
        curso.getDepat().setId(no);
    	try {
			comand.inserir(curso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
