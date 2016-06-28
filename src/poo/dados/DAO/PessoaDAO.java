/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.dados.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.IPessoaDAO;
import poo.excecoes.SenhaIncorretaException;
import poo.negocios.beans.Endereco;
import poo.negocios.beans.Pessoa;

/**
 *
 * @author Thiago Gomes
 */
public class PessoaDAO implements IPessoaDAO{
	private static PessoaDAO instance;
	private ConnectionBanco bancoConnect;

	public static PessoaDAO getInstance(){
		if(instance == null){
			instance = new PessoaDAO();
		}
		return instance;
	}

	private PessoaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	public boolean inserir(Pessoa p) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.pessoa(cpf_p, P_NOME, U_NOME, SEXO, SENHA, EMAIL, "
				+ "logradouro, cep, tipo_pessoa, cidade, bairro, numero, estado, data_nasc) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, p.getCpf());
			System.out.println(p.getCpf());
			smt.setString(2, p.getPnome());
			smt.setString(3, p.getUnome());
			smt.setInt(4, (p.getSexo())? 1 : 2);
                        if(p.getSenha().equals(null)){
                            smt.setNull(5, Types.VARCHAR);
                        }else{
                            smt.setString(5, p.getSenha());
                        }			
			smt.setString(6, p.getEmail());
			smt.setString(7, p.getEndereco().getLogradouro());
			smt.setString(8, p.getEndereco().getCep());
			smt.setInt(9, p.getTipo());
			smt.setString(10, p.getEndereco().getCidade());
			smt.setString(11, p.getEndereco().getBairro());
			smt.setInt(12, p.getEndereco().getNumero());
			smt.setString(13, p.getEndereco().getEstado());
			smt.setDate(14, new java.sql.Date(p.getDataNascimento().getTime().getTime()));
			smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}

	public boolean atualiza(Pessoa a) throws SQLException{
		boolean atualizou = false;
		String sql = "UPDATE deinfo.pessoa SET cpf_p = ?, P_NOME = ?, U_NOME = ?, SEXO = ?, SENHA = ?, "
				+ "EMAIL = ?, logradouro = ?, cep = ?, tipo_pessoa = ?, cidade = ?, bairro = ?, numero = ?, estado = ?"
				+ "WHERE cpf_p = ?";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConnect.retornoStatement(sql);
			smt.setString(1, a.getCpf());
			smt.setString(2, a.getPnome());
			smt.setString(3, a.getUnome());
			smt.setInt(4, (a.getSexo())? 0 : 1);
			smt.setString(5, a.getSenha());
			smt.setString(6, a.getEmail());
			smt.setString(7, a.getEndereco().getLogradouro());
			smt.setString(8, a.getEndereco().getCep());
			smt.setInt(9, a.getTipo());
			smt.setString(10, a.getEndereco().getCidade());
			smt.setString(11, a.getEndereco().getBairro());
			smt.setInt(12, a.getEndereco().getNumero());
			smt.setString(13, a.getEndereco().getEstado());
			smt.setString(14, a.getCpf());
			smt.execute();
			atualizou = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, "Erro ao atualizar uma pessoa", "Erro", -1);
		}
		return atualizou;
	}
	enum MyEnum{P(1),R(2),A(3);
	int valorLetra;
	MyEnum(int valor){
		this.valorLetra = valor;
	}
	int getValor(){
		return this.valorLetra;
	}
	};
	public ArrayList<Pessoa> listar() throws SQLException{
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		String query = "SELECT * FROM deinfo.pessoa";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				//DADOS DA PESSOA
				String cpf_p = resultSet.getString("CPF_P"); //CPF
				String p_nome = resultSet.getString("P_NOME"); // PRIMEIRO NOME
				String u_nome = resultSet.getString("U_NOME"); // ULTIMO NOME
				boolean sexo = resultSet.getBoolean("SEXO"); // SEXO
				String senha = resultSet.getString("SENHA"); // SENHA
				String email = resultSet.getString("EMAIL"); // EMAIL
				MyEnum tipo_pessoa1 = (MyEnum.valueOf(resultSet.getString("tipo_pessoa")));//TIPO DA PESSOA
				int tipo_pessoa = tipo_pessoa1.getValor();
				Date data_nasc = resultSet.getDate("DATA_NASC"); //data nasc;
				@SuppressWarnings("deprecation")
				Calendar data2 = new GregorianCalendar(data_nasc.getYear(), data_nasc.getMonth(), data_nasc.getDay());

				//DADOS DO ENDERECO
				String logradouro = resultSet.getString("logradouro"); //LOGRADOURO
				String cep = resultSet.getString("cep"); //CEP
				String cidade = resultSet.getString("cidade"); //CIDADE
				String bairro = resultSet.getString("bairro"); //BAIRRO
				int numero = resultSet.getInt("numero"); //NUMERO DA RESIDENCIA
				String estado = resultSet.getString("estado"); // ESTADO
				Endereco b = new Endereco(logradouro, numero, bairro, cidade, cep, estado);
				Pessoa a = new Pessoa(cpf_p);
				a.setSenha(senha);
				a.setPnome(p_nome);
				a.setUnome(u_nome);
				a.setEndereco(b);
				a.setEmail(email);
				a.setSexo(sexo);
				a.setDataNascimento(data2);
				a.setTipo(tipo_pessoa);
				listaPessoas.add(a);

			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return listaPessoas;
	}



	/*
	 * =========================== INTERFACE ACABA AQUI ========================================== 
	 *
	 */







	public int tipoDeUsuario(String cpf){
		int tipo = -1;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				tipo = resultSet.getInt("TIPO_PESSOA");
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return tipo;
	}


	public String verificaSenha(String cpf){
		String aux = null;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String senha_p = resultSet.getString("SENHA");
				aux = senha_p;
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return aux;
	}

	public boolean autenticar(String cpf, String senha){
		boolean ok = false;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String senha_p = resultSet.getString("SENHA");
				if(senha_p.equals(senha)){
					ok = true;
					break;
				}
				else{
					throw new SenhaIncorretaException();
				}
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return ok;
	}

	public String nomeUsuario(String cpf){
		String completo = "";
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String nome1= resultSet.getString("p_nome");
				String nome2= resultSet.getString("u_nome");
				completo = nome1+" "+nome2;
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return completo;
	}

	public int cursoUsuario(String cpf){
		int completo = -1;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				int curso= resultSet.getInt("CURSO");
				completo = curso;
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return completo;
	}

	public boolean existeUsuario(String cpf){
		boolean ok = false;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			if(resultSet.isBeforeFirst()){
				ok = true;
				System.out.println(ok);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return ok;
	}



	public Pessoa buscaPessoa(String cpf){
		Pessoa a = null;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConnect.comandoSQL(query);
			while(resultSet.next()){
				String cpf_p = resultSet.getString("CPF_P");
				String p_nome = resultSet.getString("P_NOME");
				String u_nome = resultSet.getString("U_NOME");
				boolean sexo = resultSet.getBoolean("SEXO");
				String senha = resultSet.getString("SENHA");
				String email = resultSet.getString("EMAIL");
				String logradouro = resultSet.getString("logradouro");
				String cep = resultSet.getString("cep");
				int tipo_pessoa = resultSet.getInt("tipo_pessoa");
				String cidade = resultSet.getString("cidade");
				String bairro = resultSet.getString("bairro");
				int numero = resultSet.getInt("numero");
				String estado = resultSet.getString("estado");
				a = new Pessoa(cpf_p);
				a.setSenha(senha);
				a.setPnome(p_nome);
				a.setUnome(u_nome);
				Endereco b = new Endereco(logradouro, numero, bairro, cidade, cep, estado);
			}
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}

}
