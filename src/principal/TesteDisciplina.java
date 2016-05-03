package principal;

import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.DisciplinaDAO;
import poo.dados.DAO.PessoaDAO;
import poo.excecoes.CPFInvalidoException;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.*;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Endereco;
import poo.negocios.beans.Pessoa;

public class TesteDisciplina {
	public static void main(String[] args) throws SQLException, CPFInvalidoException, DisciplinaJaExisteException {
        FachadaUsuario rep1 = new FachadaUsuario();
		FachadaSistema rep = new FachadaSistema();
        CadastroDisciplina cad = new CadastroDisciplina();
		Curso bcc = new Curso(1, "Bacharelado em Ciencia da Computação");
		Disciplina a, b, c, d, e, f, g, h, i;
                ArrayList<Disciplina> test = new ArrayList<Disciplina>();
		ListarDisciplinas listar = new ListarDisciplinas();
                Autenticar auto = new Autenticar();
		
		a = new Disciplina("Introducao a programacao 1", 0, null, 0, null, null, bcc, 0, 0);
		cad.inserirDisciplina(a);
        test.add(a);
		b = new Disciplina("Calculo 1", 0, null, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(b);
        d = new Disciplina("Introducao a programacao 2", 1, test, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(d);
		c = new Disciplina("Algoritmo e estrutura de dados", 1, test, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(c);
		test.add(c);
		e = new Disciplina("Algebra Linear", 0, null, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(e);
		f = new Disciplina("Introdução a ciencia da computação", 0, null, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(f);
		g = new Disciplina("Matematica Discreta", 0, null, 0, null, null, bcc, 0, 0);
        cad.inserirDisciplina(g);
        h = new Disciplina("Banco de dados", 1, test, 0, null, null, bcc, 0, 0);
		cad.inserirDisciplina(h);
		
		
//        Endereco endereco = new Endereco("Rua da Guia", 58, "san martin", "Recife", "50761-030", "PE");
//        Pessoa admin = new Pessoa("Thiago", "Gomes", "09198875469", false, "teste", "thiago123789@gmail.com", endereco, 0);
//        Pessoa root = new Pessoa("root", "root", "34232646086", false, "root", "thiago123789@gmail.com", endereco, 2);
//	rep1.inserir(root);
//        rep1.inserir(admin);
		
	}
}
