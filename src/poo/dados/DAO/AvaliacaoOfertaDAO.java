package poo.dados.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import poo.dados.DAO.interfaces.IAvaliacaoOfertaDAO;
import poo.negocios.beans.AvaliacaoOferta;

public class AvaliacaoOfertaDAO implements IAvaliacaoOfertaDAO{
	private static AvaliacaoOfertaDAO instance;
	private ConnectionBanco bancoConnect;

	public static AvaliacaoOfertaDAO getInstance(){
		if(instance == null){
			instance = new AvaliacaoOfertaDAO();
		}
		return instance;
	}

	private AvaliacaoOfertaDAO(){
		bancoConnect = ConnectionBanco.getInstance();
	}

	public boolean atualizar(AvaliacaoOferta av) throws SQLException{
		boolean atualizou = false;
		String query = "UPDATE deinfo.avaliacao_oferta AS AVA SET VA1 = ?, VA2 = ?, VA3 = ?, FINAL = ?, FALTAS = ? WHERE AVA.ID_AVALIACAO = ?;";
		PreparedStatement smt = bancoConnect.retornoStatement(query);
		smt.setFloat(1, av.getVA1());
		smt.setFloat(2, av.getVA2());
		smt.setFloat(3, av.getVA3());
		smt.setFloat(4, av.getFINAL());
		smt.setInt(5, av.getFALTAS());
		smt.setInt(6, av.getID_AVALIACAO());
		smt.executeUpdate();
		atualizou = true;
		return atualizou;
	}
	//'enum(''CURSANDO'',''APROVADO'',''APROVADO POR MÉDIA'',''CANCELADO COM ONUS'',''CANCELADO SEM ONUS'',''REPROVADO'',''REPROVADO POR FALTA'',''LISTA DE ESPERA'')'
	enum MyEnum{
		CURSANDO(1), APROVADO(2), TER(3), QUA(4), QUI(5), REPROVADO(6), SAB(7);
		int valorDia;
		MyEnum(int valor){
			this.valorDia =valor;
		}
		public int getValorDia() {
			return valorDia;
		}
	}


	//ID_AVALIACAO, ID_MATRICULA, VA1, VA2, VA3, FINAL, SITUACAO, MEDIA, FALTAS
	public ArrayList<AvaliacaoOferta> listar(){
		ArrayList<AvaliacaoOferta> retorno = new ArrayList<AvaliacaoOferta>();
		String query = "SELECT * FROM deinfo.avaliacao_oferta";

		ResultSet rs = bancoConnect.comandoSQL(query);
		try {
			while(rs.next()){
				int id_ava = rs.getInt("ID_AVALIACAO");
				int id_matricula = rs.getInt("ID_MATRICULA");
				float va1 = rs.getFloat("VA1");
				float va2 = rs.getFloat("VA2");
				float va3 = rs.getFloat("VA3");
				float nfinal =  rs.getFloat("FINAL");
				MyEnum situacao1 = MyEnum.valueOf(rs.getString("SITUACAO"));
				int situacao = situacao1.getValorDia();
				float media = rs.getFloat("MEDIA");
				int faltas = rs.getInt("FALTAS");
				AvaliacaoOferta aux = new AvaliacaoOferta();
				aux.setFALTAS(faltas);
				aux.setID_AVALIACAO(id_ava);
				aux.setID_MATRICULA(id_matricula);
				aux.setVA1(va1);
				aux.setVA2(va2);
				aux.setVA3(va3);
				aux.setSITUACAO(situacao);
				aux.setFINAL(nfinal);
				aux.setMEDIA(media);
				retorno.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retorno;
	}

}
