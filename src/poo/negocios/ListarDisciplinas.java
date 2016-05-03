package poo.negocios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import poo.dados.RepositorioDisciplina;
import poo.dados.iRepositorioDisciplina;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.negocios.beans.Disciplina;

public class ListarDisciplinas {
	private DisciplinaDAO repositorio;
        private PreRequisitoDAO req;
	
	public ListarDisciplinas(){
		repositorio = new DisciplinaDAO();
	}
	
	public String[] listarCodigo(){
		
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
	
	public ArrayList<String> listarArrayCodigos(){
		
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
	
        public String[] listarNomes(){
                ArrayList<Disciplina> list = repositorio.consulta();
		Disciplina[] aux = new Disciplina[list.size()];
		String[] nomes = new String[aux.length];
		int i = 0;
		for(Disciplina a : list){
//			System.out.println(a.getCodigo());
			aux[i] = a;
			nomes[i] = a.getNome();
			i++;
		}		
		return nomes;
        }
	
        public String mostrarDetalhes(Disciplina a){
            String detalhes = "";
            detalhes += "Codigo: "+a.getCodigo();
            detalhes += "\nNome: "+a.getNome();
            detalhes += "\nCarga Horaria: "+a.getCargaHoraria();
            if(a.getObrigatoria()){
                detalhes += "\nTipo: Obrigatoria";
            }else if(a.getOptativa()){
                detalhes += "\nTipo: Optativa";
            }
            
            return detalhes;
        } 
        
        public String[] listarCodigosPreRequisitos(String cod){
            ArrayList<Disciplina> a = req.consulta();
            String[] aux = new String[a.size()];
            
            
            return aux;
        }
	
        public String[] listarNomesPreRequisitos(String cod){
            String[] aux = new String[10];
            
            
            return aux;
        }
	
}
