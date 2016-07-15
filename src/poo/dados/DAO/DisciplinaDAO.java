package poo.dados.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import poo.dados.DAO.interfaces.IDisciplinaDAO;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Trilha;

public class DisciplinaDAO implements IDisciplinaDAO{


	private static DisciplinaDAO instance;
	private ConnectionBanco bancoConect;

	public static DisciplinaDAO getInstance(){
		if(instance == null){
			instance = new DisciplinaDAO();
		}
		return instance;
	}

	private DisciplinaDAO(){
		bancoConect = ConnectionBanco.getInstance();
	}

	//CODIGO_DIS, NOME, CURSO, CARGA_HORARIA, TRILHA, TIPO_DISCIPLINA, PERIODO_DISCIPLINA, EMENTA
	public boolean inserir(Disciplina disciplina) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.disciplina(CODIGO_DIS, NOME, CARGA_HORARIA,"
				+ "TIPO_DISCIPLINA, PERIODO_DISCIPLINA, EMENTA) values(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
			smt.setString(1, disciplina.getCodigo());
			smt.setString(2, disciplina.getNome());
			smt.setInt(3, disciplina.getCargaHoraria());
                        smt.setString(4, disciplina.getTipo_disciplina());
			smt.setInt(5, disciplina.getPeriodoDisciplina());
			smt.setBytes(6, this.converteArquivoEmBytes(disciplina.getEmenta()));
			smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Disciplina", -1);
		}
		return inseriu;
	}

	//CODIGO_DIS, NOME, CURSO, CARGA_HORARIA, TRILHA, TIPO_DISCIPLINA, PERIODO_DISCIPLINA, EMENTA
	public boolean atualizar(Disciplina disciplina) throws SQLException{

		boolean atualizou = false;
		String sql = "UPDATE deinfo.disciplina SET nome = ?, carga_horaria = ?,"
				+ "TIPO_DISCIPLINA = ?, PERIODO_DISCIPLINA = ?, EMENTA = ?"
				+ "WHERE CODIGO_DIS = \""+disciplina.getCodigo()+"\"";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
			smt.setString(1, disciplina.getNome());
			smt.setInt(2, disciplina.getCargaHoraria());
			smt.setString(3, disciplina.getTipo_disciplina());
			smt.setInt(4, disciplina.getPeriodoDisciplina());
			smt.setBytes(5, this.converteArquivoEmBytes(disciplina.getEmenta()));
			smt.execute();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Disciplia", -1);
		}
		return atualizou;
	}


    enum tiposD{OBG, OPT}
	//CODIGO_DIS, NOME, CURSO, CARGA_HORARIA, TRILHA, TIPO_DISCIPLINA, PERIODO_DISCIPLINA, EMENTA
	public ArrayList<Disciplina> listar(){
		ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		String query = "SELECT * FROM deinfo.disciplina";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
			while(resultSet.next()){
				String codigo = resultSet.getString("CODIGO_DIS");
				String nome = resultSet.getString("NOME");
				int carga_horaria = resultSet.getInt("CARGA_HORARIA");
				String tipo = resultSet.getString("TIPO_DISCIPLINA");
				int periodo = resultSet.getInt("PERIODO_DISCIPLINA");
				byte[] arquivo = resultSet.getBytes("EMENTA");
				Disciplina b = new Disciplina(codigo, nome);
				b.setCargaHoraria(carga_horaria);
				b.setTipo_disciplina(tipo);
				b.setPeriodoDisciplina(periodo);
				if(arquivo != null){
					b.setEmenta(this.converterBytesParaArquivo(arquivo, codigo));
				}
				listaDisciplinas.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
			//JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			e.printStackTrace();
			//JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return listaDisciplinas;
	}

	private byte[] converteArquivoEmBytes(File f) throws IOException{
		FileInputStream is = new FileInputStream(f);
		byte[] bytes = new byte[(int)f.length() ];
		try{
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
				offset += numRead;
			}
		}catch(IOException e){
			e.printStackTrace();
		}

		return bytes;
	}

	private File converterBytesParaArquivo(byte[] b, String nomeArquivo){
		File f = new File("EMENTAS\\" + nomeArquivo+".pdf");
		try{
			FileOutputStream fos = new FileOutputStream( f);
			fos.write(b);
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return f;
	}

}
	//================================= INTERFACE ACABA AQUI ================================================
