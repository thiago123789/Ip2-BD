package poo.negocios;

import java.sql.SQLException;

import poo.dados.DisciplinaDAO;
import poo.dados.PreRequisitoDAO;
import poo.negocios.beans.Disciplina;

public class CadastroDisciplina {
	DisciplinaDAO comand;
	PreRequisitoDAO comandA;
        
	public CadastroDisciplina(){
            this.comand = new DisciplinaDAO();
            this.comandA = new PreRequisitoDAO();
//		this.inserirDisciplina(a);
	}
	
	public void inserirDisciplina(Disciplina a){
		
                try {
                    if(!comand.buscaDis(a.getCodigo())){
                        comand.inserir(a);
                        if(a.getPreRequisito() != null){
                            comandA.inserir(a);
                        }
                    }
		} catch (SQLException e) {
                    e.printStackTrace();
		}
	}
	
	
	
}
