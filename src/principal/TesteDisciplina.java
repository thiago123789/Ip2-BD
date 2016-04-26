package principal;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DisciplinaDAO;
import poo.negocios.ListarDisciplinas;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;

public class TesteDisciplina {
	public static void main(String[] args) throws SQLException {
		DisciplinaDAO rep = new DisciplinaDAO();
		Curso bcc = new Curso(1, "Bacharelado em Ciencia da Computação");
		Disciplina a, b, c, d, e, f, g, h, i;
		ListarDisciplinas listar = new ListarDisciplinas();
		
		a = new Disciplina("Introducao a programacao 1", 0, null, null, null, null, 0, null, null, bcc, 0, 0);
//		test.add(a);
		b = new Disciplina("Calculo 1", 0, null, null, null, null, 0, null, null, bcc, 0, 0);
		c = new Disciplina("Algoritmo e estrutura de dados", 1, a, null, null ,null, 0, null, null, bcc, 0, 0);
//		test.add(c);
		d = new Disciplina("Introducao a programacao 2", 1, a, c, null, null, 0, null, null, bcc, 0, 0);
		e = new Disciplina("Algebra Linear", 0, null,null, null ,null, 0, null, null, bcc, 0, 0);
		f = new Disciplina("Introdução a ciencia da computação", 0, null, null, null ,null, 0, null, null, bcc, 0, 0);
		g = new Disciplina("Matematica Discreta", 0, null,null, null ,null, 0, null, null, bcc, 0, 0);
		h = new Disciplina("Banco de dados", 1, a, c, null, null, 0, null, null, bcc, 0, 0);
		
		rep.inserir(a);
		a = new Disciplina("Introducao a programacao 1", 0, null, null, null, null, 0, null, null, bcc, 1, 0);
		rep.atualiza(a);
		rep.inserir(b);
		rep.inserir(c);
		rep.inserir(d);
		rep.inserir(e);
		rep.inserir(f);
		rep.inserir(g);
		rep.inserir(h);
		
		System.out.println(a.toString());
		System.out.println();
		System.out.println(b.toString());
		System.out.println();
		System.out.println(c.toString());
		System.out.println();
		System.out.println(d.toString());
		System.out.println();
		System.out.println(e.toString());
		System.out.println();
		System.out.println(f.toString());
		System.out.println();
		System.out.println(g.toString());
		System.out.println();
		System.out.println(h.toString());
		
		String[] todas = listar.listar();
		for(int k = 0; k < todas.length; k++){
			System.out.println(todas[k]);
		}
		
//		ArrayList<Disciplina> test = rep.consulta();
//		for(Disciplina w: test){
//			System.out.println(w.toString());
//		}
		
	}
}
