package poo.negocios;

import java.sql.SQLException;

import poo.dados.DisciplinaDAO;
import poo.negocios.beans.Disciplina;

public class CadastroDisciplina {
	DisciplinaDAO comand = new DisciplinaDAO();
	
	public CadastroDisciplina(){
//		this.inserirDisciplina(a);
	}
	
	public void inserirDisciplina(Disciplina a){
		try {
			comand.inserir(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
