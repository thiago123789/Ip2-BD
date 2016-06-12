/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.SQLException;

import poo.dados.DAO.DepartamentoDAO;
import poo.dados.DAO.interfaces.IDepartamentoDAO;
import poo.negocios.beans.Departamento;

public class CadastroDepartamento {
	private static CadastroDepartamento instance;
	private IDepartamentoDAO comand;

	public static CadastroDepartamento getInstance(){
		if(instance == null){
			instance = new CadastroDepartamento();
		}
		return instance;
	}

	private CadastroDepartamento(){
		this.comand = DepartamentoDAO.getInstance();
	}

	public void cadastraDepat(Departamento depat){

		try{
			if(depat != null){
				comand.inserir(depat);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
