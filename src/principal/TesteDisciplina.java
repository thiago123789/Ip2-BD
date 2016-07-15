package principal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import poo.dados.DAO.AlunoDAO;
import poo.dados.DAO.AvaliacaoOfertaDAO;
import poo.dados.DAO.OfertaDisciplinaDAO;
import poo.dados.DAO.interfaces.IAlunoDAO;
import poo.dados.DAO.interfaces.IAvaliacaoOfertaDAO;
import poo.dados.DAO.interfaces.IOfertaDisciplinaDAO;
import poo.excecoes.CPFInvalidoException;
import poo.excecoes.DisciplinaJaExisteException;
import poo.negocios.FachadaSistema;
import poo.negocios.FachadaUsuario;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.AvaliacaoOferta;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Endereco;
import poo.negocios.beans.Matricula;
import poo.negocios.beans.OfertaDisciplina;

public class TesteDisciplina {
	public static void main(String[] args) throws SQLException, CPFInvalidoException, DisciplinaJaExisteException {
		FachadaUsuario rep1 = FachadaUsuario.getInstance();
		FachadaSistema rep = FachadaSistema.getInstance();

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
		Endereco endereco = new Endereco("Rua da Guia", 100, "san martin", "Recife", "50761030", "PE");
		//	int mes = Integer.parseInt((new SimpleDateFormat("01")).format(new Date())); //Formato MM-yyyy
		//        int ano = Integer.parseInt((new SimpleDateFormat("1994")).format(new Date()));
		//        int dia = Integer.parseInt((new SimpleDateFormat("12")).format(new Date()));
		//
		//        Date aux = new Date();
		Calendar aux = Calendar.getInstance();

		aux.set(1994, Calendar.DECEMBER, 12);
		aux.setFirstDayOfWeek(0);
		//		System.out.println("Dia: "+aux.get(Calendar.DATE));
		//		System.out.println("Mes: "+aux.get(Calendar.MONTH));
		//		System.out.println("Ano: "+aux.get(Calendar.YEAR));
		//		System.out.println("teste "+aux.getTimeInMillis());

		Date data1 = new Date();
		//            Calendar nas = new Calendar();
		//		//public Aluno(Curso curso, String pNome,
		//		String uNome, String cpf, String turno, int anoEntrada,
		//		int semestreEntrada, boolean prioridade, boolean sexo, String senha, String email,
		//		Endereco endereco) throws CPFInvalidoException {
		//	Aluno teste = new Aluno(bcc, "Thiago", "Gomes", "67666811799", "Tarde", 2014, 2, false,
		//				true, "teste", "thiagohfg@hotmail.com", endereco,aux );

		//	System.out.println(teste.getTurno());
		//	rep.cadastraAluno(teste);


		// Pessoa admin = new Pessoa("Thiago", "Gomes", "09198875469", false, "teste", "thiago123789@gmail.com", endereco, 0);
		//        Pessoa root = new Pessoa("root", "root", "34232646086", false, "root", "thiago123789@gmail.com", endereco, 2);
		//	rep1.inserir(root);
		//        rep1.inserir(admin);
		Curso bcc = new Curso();
		bcc.setCodigo(1);
		//        Aluno aluno1 = new Aluno(bcc, "Aluno40", "Bcc", "57111573706", "Tarde", 2016, 1, true, true, null, "aluno40@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno2 = new Aluno(bcc, "Aluno41", "Bcc", "59267859870", "Tarde", 2015, 1, true, true, null, "Aluno41@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno3 = new Aluno(bcc, "Aluno42", "Bcc", "18372655693", "Tarde", 2015, 2, true, true, null, "Aluno42@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno4 = new Aluno(bcc, "Aluno43", "Bcc", "28944996474", "Tarde", 2015, 1, true, true, null, "Aluno43@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno5 = new Aluno(bcc, "Aluno44", "Bcc", "74681273600", "Tarde", 2014, 2, true, true, null, "Aluno44@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno6 = new Aluno(bcc, "Aluno45", "Bcc", "59349959526", "Tarde", 2015, 1, true, true, null, "Aluno45@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno7 = new Aluno(bcc, "Aluno46", "Bcc", "80408894210", "Tarde", 2014, 2, true, true, null, "Aluno46@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno8 = new Aluno(bcc, "Aluno47", "Bcc", "97758103618", "Tarde", 2016, 1, true, true, null, "Aluno47@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno9 = new Aluno(bcc, "Aluno48", "Bcc", "21518502342", "Tarde", 2014, 1, true, true, null, "Aluno48@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno10 = new Aluno(bcc, "Aluno49", "Bcc", "33544859653", "Tarde", 2014, 1, true, true, null, "Aluno49@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno11 = new Aluno(bcc, "Aluno50", "Bcc", "27029541979", "Tarde", 2012, 2, true, true, null, "Aluno50@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno12 = new Aluno(bcc, "Aluno51", "Bcc", "77602686535", "Tarde", 2011, 2, true, true, null, "Aluno51@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno13 = new Aluno(bcc, "Aluno52", "Bcc", "64591565220", "Tarde", 2013, 1, true, true, null, "Aluno52@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno14 = new Aluno(bcc, "Aluno53", "Bcc", "72451426454", "Tarde", 2015, 1, true, true, null, "Aluno53@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno15 = new Aluno(bcc, "Aluno54", "Bcc", "45249181406", "Tarde", 2016, 1, true, true, null, "Aluno54@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno16 = new Aluno(bcc, "Aluno55", "Bcc", "50381346960", "Tarde", 2016, 1, true, true, null, "Aluno55@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno17 = new Aluno(bcc, "Aluno56", "Bcc", "63912157820", "Tarde", 2016, 1, true, true, null, "Aluno56@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno18 = new Aluno(bcc, "Aluno57", "Bcc", "83386086705", "Tarde", 2016, 1, true, true, null, "Aluno57@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno19 = new Aluno(bcc, "Aluno58", "Bcc", "21342924827", "Tarde", 2016, 1, true, true, null, "Aluno58@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno20 = new Aluno(bcc, "Aluno59", "Bcc", "62213239401", "Tarde", 2016, 1, true, true, null, "Aluno59@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno21 = new Aluno(bcc, "Aluno60", "Bcc", "19294669513", "Tarde", 2013, 1, true, true, null, "Aluno60@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno22 = new Aluno(bcc, "Aluno61", "Bcc", "93331969273", "Tarde", 2016, 1, true, true, null, "Aluno61@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno23 = new Aluno(bcc, "Aluno62", "Bcc", "70221521100", "Tarde", 2016, 1, true, true, null, "Aluno62@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno24 = new Aluno(bcc, "Aluno63", "Bcc", "90183604814", "Tarde", 2012, 1, true, true, null, "Aluno63@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno25 = new Aluno(bcc, "Aluno64", "Bcc", "72504119267", "Tarde", 2016, 1, true, true, null, "Aluno64@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno26 = new Aluno(bcc, "Aluno65", "Bcc", "45887735422", "Tarde", 2016, 1, true, true, null, "Aluno65@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno27 = new Aluno(bcc, "Aluno66", "Bcc", "70119626110", "Tarde", 2011, 1, true, true, null, "Aluno66@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno28 = new Aluno(bcc, "Aluno67", "Bcc", "12928843124", "Tarde", 2016, 1, true, true, null, "Aluno67@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno29 = new Aluno(bcc, "Aluno68", "Bcc", "38344769868", "Tarde", 2010, 2, true, true, null, "Aluno68@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno30 = new Aluno(bcc, "Aluno69", "Bcc", "56287389303", "Tarde", 2016, 1, true, true, null, "Aluno69@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno31 = new Aluno(bcc, "Aluno70", "Bcc", "22148341170", "Tarde", 2016, 1, true, true, null, "Aluno70@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno32 = new Aluno(bcc, "Aluno71", "Bcc", "97129537850", "Tarde", 2015, 2, true, true, null, "Aluno71@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno33 = new Aluno(bcc, "Aluno72", "Bcc", "26070064909", "Tarde", 2016, 1, true, true, null, "Aluno72@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno34 = new Aluno(bcc, "Aluno73", "Bcc", "77349045565", "Tarde", 2016, 1, true, true, null, "Aluno73@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno35 = new Aluno(bcc, "Aluno74", "Bcc", "14275136195", "Tarde", 2016, 1, true, true, null, "Aluno74@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno36 = new Aluno(bcc, "Aluno75", "Bcc", "88469976206", "Tarde", 2013, 2, true, true, null, "Aluno75@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno37 = new Aluno(bcc, "Aluno76", "Bcc", "30776339060", "Tarde", 2016, 1, true, true, null, "Aluno76@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno38 = new Aluno(bcc, "Aluno77", "Bcc", "55282519828", "Tarde", 2012, 2, true, true, null, "Aluno77@gmail.com", endereco, false, false, false, false, aux, null);
		//        Aluno aluno39 = new Aluno(bcc, "Aluno78", "Bcc", "95354763355", "Tarde", 2014, 2, true, true, null, "Aluno78@gmail.com", endereco, false, false, false, false, aux, null);
		Scanner scan = new Scanner(System.in);

		IOfertaDisciplinaDAO off = OfertaDisciplinaDAO.getInstance();
		IAvaliacaoOfertaDAO ava = AvaliacaoOfertaDAO.getInstance();
		IAlunoDAO alunos = AlunoDAO.getInstance();
		ArrayList<OfertaDisciplina> ofertas = off.listar();
		ArrayList<Aluno> alunosl = alunos.listar();
		ArrayList<AvaliacaoOferta> avalist = ava.listar();

		int max = ofertas.size();
		System.out.println("Deseja cadastrar Alunos ? 1/0");
		int op = scan.nextInt();
		if(op == 1){
			GerarCPF cpf = new GerarCPF();
			int quantidade;
			System.out.println("Quantos alunos deseja cadastrar? ");
			quantidade = scan.nextInt();
			for(int k = 0;k <= quantidade; k++){
				int o = aleatoriar(1, 1000000);
				Aluno aluno = new Aluno(bcc, "Aluno"+o, "Bcc", cpf.geradorDeCPF(), "Tarde", aleatoriar(2010, 2016), aleatoriar(1, 2), true, true, null, "Aluno"+o+"@gmail.com", endereco, false, false, false, false, aux, null);
				rep.cadastraAluno(aluno);
			}
		}
//		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
//		int inseriu = 0;
//		while(inseriu <= 1000){
//
//			for(Aluno a1 : alunosl){
//				OfertaDisciplina offaux = ofertas.get(aleatoriar(1, max-1));
//				if(offaux.getAno() >= a1.getAnoEntrada()){
//					if(offaux.getAno() == a1.getAnoEntrada()){
//						if(offaux.getSemestre() >= a1.getSemestreEntrada()){
//							Matricula m = new Matricula(offaux, a1, offaux.getAno(), offaux.getSemestre());
//							matriculas.add(m);
//							inseriu++;
//							System.out.println("Inseriu "+inseriu);
//						}
//					}
//				}
//			}
//
//		}
//		rep.Matricular(matriculas);


		for(AvaliacaoOferta av : avalist){
			AvaliacaoOferta avAux = new AvaliacaoOferta();
			avAux.setID_AVALIACAO(av.getID_AVALIACAO());
			avAux.setVA1(aletorio(0,10));
			avAux.setVA2(aletorio(0,10));
			avAux.setVA3(aletorio(0,10));
			avAux.setFINAL(aletorio(0,10));
			avAux.setFALTAS(aleatoriar(0, 40));
			rep.avaliar(avAux);
		}
		//        rep.cadastraAluno(aluno1);
		//        rep.cadastraAluno(aluno2);
		//        rep.cadastraAluno(aluno3);
		//        rep.cadastraAluno(aluno4);
		//        rep.cadastraAluno(aluno5);
		//        rep.cadastraAluno(aluno6);
		//        rep.cadastraAluno(aluno7);
		//        rep.cadastraAluno(aluno8);
		//        rep.cadastraAluno(aluno9);
		//        rep.cadastraAluno(aluno10);
		//        rep.cadastraAluno(aluno11);
		//        rep.cadastraAluno(aluno12);
		//        rep.cadastraAluno(aluno13);
		//        rep.cadastraAluno(aluno14);
		//        rep.cadastraAluno(aluno15);
		//        rep.cadastraAluno(aluno16);
		//        rep.cadastraAluno(aluno17);
		//        rep.cadastraAluno(aluno18);
		//        rep.cadastraAluno(aluno19);
		//        rep.cadastraAluno(aluno20);
		//        rep.cadastraAluno(aluno21);
		//        rep.cadastraAluno(aluno22);
		//        rep.cadastraAluno(aluno23);
		//        rep.cadastraAluno(aluno24);
		//        rep.cadastraAluno(aluno25);
		//        rep.cadastraAluno(aluno26);
		//        rep.cadastraAluno(aluno27);
		//        rep.cadastraAluno(aluno28);
		//        rep.cadastraAluno(aluno29);
		//        rep.cadastraAluno(aluno30);
		//        rep.cadastraAluno(aluno31);
		//        rep.cadastraAluno(aluno32);
		//        rep.cadastraAluno(aluno33);
		//        rep.cadastraAluno(aluno34);
		//        rep.cadastraAluno(aluno35);
		//        rep.cadastraAluno(aluno36);
		//        rep.cadastraAluno(aluno37);
		//        rep.cadastraAluno(aluno38);
		//        rep.cadastraAluno(aluno39);
	}

	public static float aletorio(int minimo, int max){
		Random random = new Random();
		float aux = ((float) random.nextInt((max - minimo) + 1)) + minimo;
		return aux;
	}


	public static int aleatoriar(int minimo, int maximo) {

		Random random = new Random();
		return random.nextInt((maximo - minimo) + 1) + minimo;
	}
}
