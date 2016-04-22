package poo.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
//import java.sql.PreparedStatement;



import javax.swing.JOptionPane;

import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Horario;
import poo.negocios.beans.Professor;

import com.mysql.jdbc.PreparedStatement;

public class RepositorioDisciplina {
	public static Connection conexao;
	public static ResultSet resultSet;
	public static ResultSetMetaData metaData;
	public static Statement statement;

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("carregou");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
	}

	public RepositorioDisciplina() throws SQLException{
		Connection con = getConexao();
		String comando = "CREATE TABLE IF NOT EXISTS DEINFO.disciplina("
				+ "CODIGO_DIS VARCHAR(20) NOT NULL PRIMARY KEY,"
				+ "NOME VARCHAR(50) NOT NULL,"
				+ "CURSO INT(5) NOT NULL,"
				+ "CARGA_HORARIA INT(3) NOT NULL,"
				+ "TRILHA INT(5),"
				+ "PRE_REQUISITO VARCHAR(20),"
				+ "OPTATIVA BOOLEAN,"
				+ "OBRIGATORIOA BOOLEAN,"
				+ "GRADUACAO BOOLEAN,"
				+ "POSGRADUACAO BOOLEAN"
				+ ") ENGINE = InnoDB;";
		Statement smt = con.createStatement();
		smt.execute(comando);
		smt.close();
	}
	/**
	 * M�todo para retornar uma nova conex�o com o banco de dados
	 * 
	 * @return Uma nova Conex�o com banco de dados Postgres, base de dados
	 *         HospitalDB
	 * @throws SQLException
	 *           Alguma poss�vel exce��o levantada durante o estabelecimento da
	 *           conex�o
	 */
	public static Connection getConexao() throws SQLException {

		Connection retorno = null;
		/*
		 * Formato: 
		 * - Par�metro 1: URLConex�o:@endere�o:porta 
		 * - Par�metro 2: usu�rio
		 * - Par�metro 3: senha
		 */
		retorno = DriverManager.getConnection(

				"jdbc:mysql://127.0.0.1:3306/deinfo?autoReconnect=true&useSSL=false", "root", "MAradona.58b"); // nome do esquema, usu�rio e senha
		System.out.println("conectou");
		return retorno;
	}
	/*Disciplina(String nome, int codigo, 
			ArrayList<Disciplina> preRequisito, 
			ArrayList<Disciplina> coRequisito, ArrayList<Professor> professores, 
			String trilha, String area, Curso curso, int tipoDisciplina, 
			int tipoDisciplinaCurso, Horario horario){*/

	//	Disciplina a = new Disciplina(nome, requisito, preRequisito, 
	//			corequisito, coRequisito, trilha, curso, tipoDisciplina, 
	//			tipoDisciplinaCurso)

	public boolean inserir(Disciplina disciplina) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.disciplina(codigo_dis, nome, curso, carga_horaria, trilha, "
				+ "pre_requisito, optativa, OBRIGATORIOA, graduacao, posgraduacao) values(?,?,?,?,?,?,?,?,?,?)";
		Connection con = getConexao();
		Statement simplaStatement;
		//		System.out.println("incio");
		try{

			PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
			//System.out.println("checkpoint");
			smt.setString(1, disciplina.getCodigo());
			//			System.out.println("checkpoint1");
			smt.setString(2, disciplina.getNome());
			//			System.out.println("checkpoint2");
			smt.setInt(3, disciplina.getCurso().getCodigo());
			//			System.out.println("checkpoint3");
			smt.setInt(4, disciplina.getCargaHoraria());
			//			System.out.println("checkpoint4");


			if (disciplina.getTrilha() == null) {
				smt.setNull(5, Types.INTEGER);
			} else {
				smt.setInt(5, disciplina.getTrilha().getCodigo());
			}

			//smt.setInt(5, disciplina.getTrilha().getCodigo());
			//			System.out.println("checkpoint5");

			if (disciplina.getPreReq() == null) {
				smt.setNull(6, Types.VARCHAR);
			} else {
				smt.setString(6, disciplina.getPreReq()[0].getCodigo());
			}


			//smt.setString(6, disciplina.getPreReq()[0].getCodigo());
			//			System.out.println("checkpoint6");
			smt.setInt(7, (disciplina.getOptativa())? 1 : 0);
			//			System.out.println("checkpoint7");
			smt.setInt(8, (disciplina.getObrigatoria())? 1 : 0);
			//			System.out.println("checkpoint8");
			smt.setInt(9, (disciplina.getGraducao())? 1 : 0);
			smt.setInt(10, (disciplina.getPosGraduacao())? 1 : 0);
			//			System.out.println("fim2");
			System.out.println(disciplina.toString());
			//smt.setDate(6, new Date(disciplina.getData_nasc().getTime()));
			smt.execute();
			//			System.out.println("fim3");
			smt.close();

		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}

}
