package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import poo.dados.IAlunoDAO;
import poo.excecoes.SenhaIncorretaException;
import poo.negocios.beans.Aluno;
import poo.negocios.beans.Endereco;
import poo.negocios.beans.Pessoa;

public class AlunoDAO implements IAlunoDAO{
    private static AlunoDAO instance;
	private ConnectionBanco bancoConect;
    
	public static AlunoDAO getInstance(){
		if(instance == null){
			instance = new AlunoDAO();
		}
		return instance;
	}
	
	private AlunoDAO(){
		bancoConect = ConnectionBanco.getInstance();
	}
	        
	public boolean inserir(Aluno a) throws SQLException{
		boolean inseriu = false;
		String sql = "INSERT INTO deinfo.aluno(CPF_ALU, PRIORIDADE, CURSO, ANO_ENTRADA, SEMESTRE_ENTRADA, TURNO)"
				   + "values(?,?,?,?,?,?)";
		try{
			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
			smt.setString(1, a.getCpf());
            smt.setInt(2, a.getPrioridade()? 1: 0);
			smt.setInt(3, a.getCurso().getCodigo());
            smt.setInt(4, a.getAnoEntrada());
			smt.setInt(5, a.getSemestreEntrada());
			System.out.println(a.getTurno());
            smt.setString(6, a.getTurno());
            smt.execute();
			inseriu = true;
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return inseriu;
	}
        
	public int tipoDeUsuario(String cpf){
        int tipo = -1;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
        		ResultSet resultSet = bancoConect.comandoSQL(query);
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
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
        
    public boolean atualiza(Pessoa a) throws SQLException{
    		boolean atualizou = false;
    		String sql = "UPDATE deinfo.pessoa SET cpf_p = ?, P_NOME = ?,  U_NOME = ?, SEXO = ?, SENHA = ?, "
    				+ "EMAIL = ?, logradouro = ?, cep = ?, tipo_pessoa = ?, cidade = ?, bairro = ?, numero = ?, estado = ?"
    				+ "WHERE cpf_p = ?";
    		try{
    			PreparedStatement smt = (PreparedStatement) bancoConect.retornoStatement(sql);
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
    			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
    		}
    		return atualizou;
    	}
    
    public Pessoa buscaPessoa(String cpf){
		Pessoa a = null;
		String query = "SELECT * FROM deinfo.pessoa WHERE cpf_p = \""+cpf+"\"";
		try{
			ResultSet resultSet = bancoConect.comandoSQL(query);
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
                                Calendar calendar = Calendar.getInstance();
                                resultSet.getDate("DATA_NASC", calendar);
				Endereco b = new Endereco(logradouro, numero, bairro, cidade, cep, estado);
                a = new Pessoa(p_nome, u_nome, cpf_p, sexo, senha, email, b, tipo_pessoa, calendar);
			}			
		}catch(SQLException e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
		return a;
	}
}
