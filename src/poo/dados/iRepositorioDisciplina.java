package poo.dados;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.*;
import poo.negocios.beans.Disciplina;

public interface iRepositorioDisciplina {
	public ArrayList<Disciplina> consulta();
	public boolean inserir(Disciplina disciplina) throws SQLException;
	public boolean atualiza(Disciplina disciplina) throws SQLException;


}
