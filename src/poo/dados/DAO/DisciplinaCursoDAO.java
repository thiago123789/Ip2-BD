package poo.dados.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import poo.dados.DAO.interfaces.IDisciplinaCursoDAO;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.DisciplinaCurso;

import com.mysql.jdbc.PreparedStatement;

public class DisciplinaCursoDAO implements IDisciplinaCursoDAO{
	private ConnectionBanco bank;
	private static DisciplinaCursoDAO instance;
	
	public static DisciplinaCursoDAO getInstance(){
		if(instance == null){
			instance = new DisciplinaCursoDAO();
		}
		return instance;
	}
	
	private DisciplinaCursoDAO(){
		bank = ConnectionBanco.getInstance();
	}
	
	public boolean inserir(Disciplina a){
		boolean inseriu = false;
		String query = "INSERT INTO deinfo.disciplina_curso(COD_DISCIPLINA, COD_CURSO) values(?,?)";
		try {
			PreparedStatement st = (PreparedStatement) bank.retornoStatement(query);
			st.setString(1, a.getCodigo());
			st.setInt(2, a.getCurso().getCodigo());
			inseriu = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return inseriu;
	}
        
        
        public ArrayList<DisciplinaCurso> litar(){
            ArrayList<DisciplinaCurso> retorno = new ArrayList<DisciplinaCurso>();
            String query = "SELECT * FROM deinfo.disciplina_curso";
            try {
                ResultSet rs = bank.comandoSQL(query);
                while(rs.next()){
                    String dis = rs.getString("COD_DISCIPLINA");
                    int curso = rs.getInt("COD_CURSO");
                    DisciplinaCurso aux = new DisciplinaCurso(dis, curso);
                    retorno.add(aux);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaCursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return retorno;
        }
	
	
	
	
}
