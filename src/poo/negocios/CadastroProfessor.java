package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;
import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.PessoaDAO;
import poo.dados.DAO.ProfessorDAO;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.dados.DAO.interfaces.IProfessorDAO;
import poo.negocios.beans.Departamento;
import poo.negocios.beans.Pessoa;
import poo.negocios.beans.Professor;

public class CadastroProfessor {
	private static CadastroProfessor instance;
	private IPessoaDAO command;
	private IProfessorDAO commandA;
        private IDepartamentoDAO depat;

	public static CadastroProfessor getInstance(){
		if(instance == null){
			instance = new CadastroProfessor();
		}
		return instance;
	}

	private CadastroProfessor(){
		command = PessoaDAO.getInstance();
		commandA = ProfessorDAO.getInstance();
                depat = DepartamentoDAO.getInstance();
	}
        
        public void cadastraProfessor(Professor p){
		try {
                    
                    	System.out.println("Departamento" + p.toString());
                        int id = this.retornaIdDepartamento(p.getDepartamento().getNome());
                        p.getDepartamento().setId(id);
                        command.inserir((Pessoa)p);    
                        commandA.inserir(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}

}
        private int retornaIdDepartamento(String nome){
            int retorno = -1;
            try {
                ArrayList<Departamento> departamentoList = depat.listar();
                for(Departamento d: departamentoList){
                    if(d.getNome().equals(nome)){
                        retorno = d.getId();
                        break;
                    }
                }
                
            } catch(SQLException e) {
			e.printStackTrace();
		}
            return retorno;
        }
}
