package poo.negocios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DisciplinaDAO;
//import poo.dados.RepositorioDisciplina;
import poo.dados.iRepositorioDisciplina;
import poo.negocios.beans.Disciplina;

public class ListarDisciplinas {
	DisciplinaDAO repositorio;
	
	public ListarDisciplinas(){
		repositorio = new DisciplinaDAO();
	}
	
	public String[] listar(){
		
		ArrayList<Disciplina> list = repositorio.consulta();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] codigos = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
//			System.out.println(a.getCodigo());
			aux[i] = a;
			codigos[i] = a.getCodigo();
			i++;
		}		
		return codigos;
	}
	
	public ArrayList<String> listarArray(){
		
		ArrayList<Disciplina> list = repositorio.consulta();
		ArrayList<String> listS = new ArrayList<String>();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] codigos = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
			listS.add(a.getCodigo());
			
		}		
		return listS;
	}
	
	
	
	
}
