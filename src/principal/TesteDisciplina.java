package principal;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import poo.excecoes.CPFInvalidoException;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.*;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Endereco;

public class TesteDisciplina {
	public static void main(String[] args) throws SQLException, CPFInvalidoException, DisciplinaJaExisteException {
        FachadaUsuario rep1 = FachadaUsuario.getInstance();
        FachadaSistema rep = FachadaSistema.getInstance();
        Curso bcc = new Curso(1, "Bacharelado em Ciencia da Computação", 2000);
	Disciplina a, b, c, d, e, f, g, h, i;
//        ArrayList<Disciplina> test = new ArrayList<Disciplina>();
//	ListarDisciplinas listar = new ListarDisciplinas();
//        Autenticar auto = new Autenticar();
		
//	a = new Disciplina("Introducao a programacao 1", 0, null, 0, null, null, bcc, 0, 0);
//	cad.inserirDisciplina(a);
//        test.add(a);
//	b = new Disciplina("Calculo 1", 0, null, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(b);
//        d = new Disciplina("Introducao a programacao 2", 1, test, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(d);
//	c = new Disciplina("Algoritmo e estrutura de dados", 1, test, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(c);
//	test.add(c);
//	e = new Disciplina("Algebra Linear", 0, null, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(e);
//	f = new Disciplina("Introdução a ciencia da computação", 0, null, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(f);
//	g = new Disciplina("Matematica Discreta", 0, null, 0, null, null, bcc, 0, 0);
//        cad.inserirDisciplina(g);
//        h = new Disciplina("Banco de dados", 1, test, 0, null, null, bcc, 0, 0);
//	cad.inserirDisciplina(h);
	Endereco endereco = new Endereco("Rua da Guia", 58, "san martin", "Recife", "50761-030", "PE");
//	int mes = Integer.parseInt((new SimpleDateFormat("01")).format(new Date())); //Formato MM-yyyy
//        int ano = Integer.parseInt((new SimpleDateFormat("1994")).format(new Date()));
//        int dia = Integer.parseInt((new SimpleDateFormat("12")).format(new Date()));
//        
//        Date aux = new Date();
        Calendar aux = Calendar.getInstance();
           
        aux.set(1994, Calendar.DECEMBER, 12);
        aux.setFirstDayOfWeek(0);
        System.out.println("Dia: "+aux.get(Calendar.DATE));
        System.out.println("Mes: "+aux.get(Calendar.MONTH));
        System.out.println("Ano: "+aux.get(Calendar.YEAR));
        System.out.println("teste "+aux.getTimeInMillis());
             
        Date data1 = new Date();
//            Calendar nas = new Calendar();
//		//public Aluno(Curso curso, String pNome, 
//		String uNome, String cpf, String turno, int anoEntrada, 
//		int semestreEntrada, boolean prioridade, boolean sexo, String senha, String email, 
//		Endereco endereco) throws CPFInvalidoException {
	Aluno teste = new Aluno(bcc, "Thiago", "Gomes", "67666811799", "Tarde", 2014, 2, false, 
				true, "teste", "thiagohfg@hotmail.com", endereco,aux );
		
	System.out.println(teste.getTurno());
	rep.cadastraAluno(teste);
		
       
       // Pessoa admin = new Pessoa("Thiago", "Gomes", "09198875469", false, "teste", "thiago123789@gmail.com", endereco, 0);
//        Pessoa root = new Pessoa("root", "root", "34232646086", false, "root", "thiago123789@gmail.com", endereco, 2);
//	rep1.inserir(root);
//        rep1.inserir(admin);
		
	}
}
