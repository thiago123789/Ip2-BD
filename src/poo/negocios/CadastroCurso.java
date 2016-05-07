/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DepartamentoDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;

/**
 *
 * @author Thiago Gomes
 */
public class CadastroCurso {
	private static CadastroCurso instance;
    private CursoDAO comand;
    private DepartamentoDAO comandA;
    
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
    
    public void cadastroCurso(Curso curso){
        int no = this.comandA.depatID(curso.getDepat().getNome());
        curso.getDepat().setId(no);
    	try {
			comand.inserir(curso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    	
    }
    
}
