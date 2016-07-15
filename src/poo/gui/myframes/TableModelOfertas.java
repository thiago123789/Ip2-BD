package poo.gui.myframes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.OfertaDisciplina;
import poo.negocios.beans.Professor;

public class TableModelOfertas extends AbstractTableModel {
	private static final int DISCIPLINA_COD = 0;
	private static final int DISCIPLINA_NOME = 1;
	private static final int ANO = 2;
	private static final int SEMESTRE = 3;
	private static final int DETALHES = 4;
	private static final long serialVersionUID = 1L;
	private String[] colunas = {"COD_DISCIPLINA","DISCIPLINA","ANO","SEMESTRE","DETALHES"};
	private List<OfertaDisciplina> linhas;

	public TableModelOfertas(){
		this.linhas = new ArrayList<OfertaDisciplina>();
	}

	public TableModelOfertas(ArrayList<OfertaDisciplina	> lista) {
		this.linhas = lista;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	public void removeAll(){
		int indice = getRowCount();

		this.linhas.clear();

		fireTableRowsDeleted(0, indice-1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OfertaDisciplina ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case DISCIPLINA_COD:
			return ob.getDisciplina().getCodigo();
		case DISCIPLINA_NOME:
			return ob.getDisciplina().getNome();
		case ANO:
			return ob.getAno();
		case SEMESTRE:
			return ob.getSemestre();
		case DETALHES:
			return "Em teste";
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public OfertaDisciplina getOferta(int rowIndex){
                System.out.println(rowIndex);
                System.out.println(linhas);
		return linhas.get(rowIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case DISCIPLINA_COD:
			return String.class;
		case DISCIPLINA_NOME:
			return String.class;
		case ANO:
			return Integer.class;
		case SEMESTRE:
			return Integer.class;
		case DETALHES:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		OfertaDisciplina ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case DISCIPLINA_COD:
			ob.getDisciplina().setCodigo((String) aValue);
			break;
		case DISCIPLINA_NOME:
			ob.getDisciplina().setNome((String) aValue);
			break;
		case ANO:
			ob.setAno((Integer) aValue);
			break;
		case SEMESTRE:
			ob.setSemestre((Integer) aValue);
			break;
		case DETALHES:
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}



	public void addOferta(OfertaDisciplina prof) {
		// Adiciona o registro.
		linhas.add(prof);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudança.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void addListaOferta(ArrayList<OfertaDisciplina> off) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(off);

		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + off.size());
	}


}