/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

//import com.sun.istack.internal.FinalArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import poo.dados.DAO.CursoDAO;
import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.interfaces.ICursoDAO;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;

public class ListarCursos {
	private static ListarCursos instance;
    private ICursoDAO curso;
    private IDepartamentoDAO depat;

    public static ListarCursos getInstance(){
    	if(instance == null){
    		instance = new ListarCursos();
    	}
    	return instance;
    }

    private ListarCursos(){
        curso = CursoDAO.getInstance();
        depat = DepartamentoDAO.getInstance();
    }
    
    public int idDepartamento(String nome){
        int id = -1;
        if((nome != null) && (!nome.equals(""))){
            try {
                ArrayList<Departamento> aux = depat.listar();
                System.out.println(aux.toString());
                for(Departamento a : aux){
                    if(a.getNome().equals(nome)){
                        id = a.getId();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListarCursos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    public ArrayList<String> listarCursosPorDepartamentoList(String depat){
        ArrayList<Curso> listarCursos = curso.listar();
        ArrayList<String> retorno = new ArrayList<>();
        if((depat != null) && (depat != "")){
        int id = this.idDepartamento(depat);
        for(Curso a: listarCursos){
            if(a.getDepat().getId() == id){
                retorno.add(a.getNome());
            }
        }
        }
        return retorno;
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
