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
    private CursoDAO comand;
    private DepartamentoDAO comandA;
    
    public CadastroCurso(){
        comand = new CursoDAO();
        comandA = new DepartamentoDAO();
    }
    
    public void cadastroCurso(Curso curso, Departamento depat){
        
    	try {
			comand.inserir(curso.getNome(), null, null, curso.getGraducao(), depat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    	
    }
    
}
