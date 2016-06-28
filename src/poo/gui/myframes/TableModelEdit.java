package poo.gui.myframes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.sun.prism.Image;

import poo.negocios.beans.Disciplina;

public class TableModelEdit extends AbstractTableModel {
	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final long serialVersionUID = 1L;
	private String[] colunas = {"Codigo", "Nome"};
	private List<Disciplina> linhas;

	public TableModelEdit(){
		this.linhas = new ArrayList<Disciplina>();
	}

	public TableModelEdit(ArrayList<Disciplina> lista) {
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
		Disciplina ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case CODIGO:
			return ob.getCodigo();
		case NOME:
			return ob.getNome();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case CODIGO:
			return String.class;
		case NOME:
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
		Disciplina ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case CODIGO:
			ob.setCodigo((String) aValue);;
			break;
		case NOME:
			ob.setNome((String) aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}

	public Disciplina getDisciplina(int rowIndex){
		return linhas.get(rowIndex);
	}

	public void addDisciplina(Disciplina disciplina) {
		// Adiciona o registro.
		linhas.add(disciplina);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudança.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void addListaDisciplinas(ArrayList<Disciplina> disciplinas) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(disciplinas);

		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + disciplinas.size());
	}


}