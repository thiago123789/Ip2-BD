/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.util.ArrayList;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.negocios.beans.Curso;

public class ListarCursos {
	private static ListarCursos instance;
    private ICursoDAO curso;

    public static ListarCursos getInstance(){
    	if(instance == null){
    		instance = new ListarCursos();
    	}
    	return instance;
    }

    private ListarCursos(){
        curso = CursoDAO.getInstance();
    }

    public String[] listarCursosPorNome(){
        ArrayList<Curso> c = curso.listar();
        String tudo[] = new String[c.size()];
        int i = 0;
        for(Curso aux : c ){
        	tudo[i] = aux.getNome();
        	i++;
        }
        return tudo;
    }

    public ArrayList<String> listarCursosPorNomeList(){
        ArrayList<Curso> c = curso.listar();
        ArrayList<String> nomes = new ArrayList<String>();
        for(Curso aux : c ){
        	nomes.add(aux.getNome());
        	System.out.println(aux);
        }
        return nomes;
    }

    public int anoInicioCurso(String nomeCurso){
    	int ano = 0;
    	ArrayList<Curso> listando = curso.listar();
        for(Curso aux : listando ){
        	if(aux.getNome().equals(nomeCurso)){
        		ano = aux.getAno_inicio();
        	}
        }
        return ano;
    }

}
