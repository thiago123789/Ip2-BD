/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poo.dados.DAO.ConnectionBanco;
import poo.dados.DAO.MatriculaDAO;
import poo.dados.DAO.OfertaDisciplinaDAO;
import poo.dados.DAO.interfaces.IBancoConnection;
import poo.dados.DAO.interfaces.IMatriculaDAO;
import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.negocios.beans.Matricula;

/**
 *
 * @author Thiago Gomes
 */
public class Matricula_Aluno {
    private static Matricula_Aluno instance;
    private IOfertaDisciplinaDAO off;
    private IMatriculaDAO matricula;
    private IBancoConnection banco;

    public static Matricula_Aluno getInstance(){
        if(instance == null){
            instance = new Matricula_Aluno();
        }
        return instance;
    }

    private Matricula_Aluno(){
        off = OfertaDisciplinaDAO.getInstance();
        matricula = MatriculaDAO.getInstance();
        banco = ConnectionBanco.getInstance();
    }

    public boolean Matricular(ArrayList<Matricula> list){
        boolean sucesso = false;
        Connection conexao = banco.getConexao();
        try{
        	for(Matricula m : list){
        		System.out.println(m.getOferta().getCodigo());
        		matricula.inserir(m);
        	}
        	conexao.commit();
        	sucesso = true;
        }catch(SQLException e){
        	JOptionPane.showConfirmDialog(null, "Não foi possivel efetuar matricula\n"+e.getMessage(), "Erro Matricula", -1);
        	try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }



        return sucesso;
    }



}
