/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.negocios.beans.Curso;

/**
 *
 * @author Thiago Gomes
 */
public class ListarCursos {
    private CursoDAO curso;
    
    public ListarCursos(){
        curso = new CursoDAO();
    }
    
    public String[] listarPorNome(){
        ArrayList<Curso> c = curso.consulta();
        String tudo[] = new String[c.size()];
        int i = 0;
        for(Curso aux : c ){
        	tudo[i] = aux.getNome();
        	i++;
        }        
        return tudo;
    }
    
    public ArrayList<String> listarPorNomeList(){
        ArrayList<Curso> c = curso.consulta();
        System.out.println(c.toString());
        ArrayList<String> nomes = new ArrayList<String>();
        for(Curso aux : c ){
        	nomes.add(aux.getNome());
        }        
        return nomes;
    }
    
}
