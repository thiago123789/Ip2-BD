package poo.gui.myframes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import poo.negocios.beans.Horario;

public class TableModelHorario extends AbstractTableModel {
	private static final int ID = 0;
	private static final int DIA = 1;
	private static final int HORA_INICIO = 2;
	private static final int HORA_TERMINO = 3;

	private static final long serialVersionUID = 1L;
	private String[] colunas = {"ID", "Dia", "Hora Inicio", "Hora Termino"};
	private List<Horario> linhas;

	public TableModelHorario(){
		this.linhas = new ArrayList<Horario>();
	}

	public TableModelHorario(ArrayList<Horario> lista) {
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

	public Horario getHorario(int rowIndex){
		return linhas.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Horario ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return ob.getId();
		case DIA:
			return ob.getDia();
		case HORA_INICIO:
			return ob.getHoraInicio().toString();
		case HORA_TERMINO:
			return ob.getHoraTermino().toString();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case ID:
			return Integer.class;
		case DIA:
			return String.class;
		case HORA_INICIO:
			return String.class;
		case HORA_TERMINO:
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
		Horario ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case ID:
			ob.setId((Integer) aValue);;
			break;
		case DIA:
			ob.setDia((String) aValue);
			break;
		case HORA_INICIO:
			ob.setHoraInicio((Time) aValue);
			break;
		case HORA_TERMINO:
			ob.setHoraTermino((Time) aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}

	public void addDisciplina(Horario horario) {
		// Adiciona o registro.
		linhas.add(horario);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudança.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void addListaDisciplinas(ArrayList<Horario> horario) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(horario);

		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + horario.size());
	}


}