package poo.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PreRequisitoDAO;
import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.dados.DAO.interfaces.IPreRequisitoDAO;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.beans.Disciplina;

public class CadastroDisciplina {
	private IDisciplinaDAO comand;
	private IPreRequisitoDAO comandA;
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

	public boolean existeDisciplina(String codigo){
		boolean existe = false;
		ArrayList<Disciplina> listando = comand.listar();
		for(Disciplina aux : listando){
			if(aux.getCodigo().equals(codigo)){
				existe = true;
				break;
			}
		}
		return existe;
	}

	public void inserirDisciplina(Disciplina a) throws DisciplinaJaExisteException{
		try {
			if(!this.existeDisciplina(a.getCodigo())){
				comand.inserir(a);
			}else{
				throw new DisciplinaJaExisteException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
