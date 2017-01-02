package poo.negocios;

import java.sql.SQLException;

import poo.dados.IDisciplinaDAO;
import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.beans.Disciplina;

public class CadastroDisciplina {
	private IDisciplinaDAO comand;
	private PreRequisitoDAO comandA;
	public static CadastroDisciplina instance;
	
	public static CadastroDisciplina getInstance(){
		if(instance == null){
			instance = new CadastroDisciplina();
		}
		return instance;
	}
        
	private CadastroDisciplina(){
            this.comand = DisciplinaDAO.getInstance();
            this.comandA = PreRequisitoDAO.getInstance();
	}
	
	public void inserirDisciplina(Disciplina a) throws DisciplinaJaExisteException{
		
                try {
                    if(!comand.existeDis(a.getCodigo())){
                        comand.inserir(a);
                        if(a.getPreRequisito() != null){
                            comandA.inserir(a);
                        }
                    }else{
                        throw new DisciplinaJaExisteException();
                    }
		} catch (SQLException e) {
                    e.printStackTrace();
		}
	}
	
	
	
}
