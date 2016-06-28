package poo.gui.myframes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import poo.excecoes.CPFInvalidoException;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Professor;

public class TableModelProfessor extends AbstractTableModel {
	private static final int CPF = 0;
	private static final int NOME = 1;
	private static final long serialVersionUID = 1L;
	private String[] colunas = {"CPF", "Nome"};
	private List<Professor> linhas;

	public TableModelProfessor(){
		this.linhas = new ArrayList<Professor>();
	}

	public TableModelProfessor(ArrayList<Professor> lista) {
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

	private Object formatoComSimbolos(Object object){
		String cpf = (String) object;
		String retorno = "";
		retorno += cpf.substring(0, 3);
		retorno += ".";
		retorno += cpf.substring(3, 6);
		retorno += ".";
		retorno += cpf.substring(6, 9);
		retorno += "-";
		retorno += cpf.substring(9, 11);
		return retorno;
	}

	public void removeAll(){
		int indice = getRowCount();

		this.linhas.clear();

		fireTableRowsDeleted(0, indice-1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Professor ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case CPF:
			return this.formatoComSimbolos(ob.getCpf());
		case NOME:
			return ob.getPnome()+" "+ob.getUnome();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	public Professor getProfessor(int rowIndex){
		return linhas.get(rowIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case CPF:
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
		Professor ob = linhas.get(rowIndex);
		switch (columnIndex) {
		case CPF:
			try {
				ob.setCpf((String) aValue);
			} catch (CPFInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			break;
		case NOME:
			ob.setPnome((String) aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}



	public void addDisciplina(Professor prof) {
		// Adiciona o registro.
		linhas.add(prof);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudança.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void addListaDisciplinas(ArrayList<Professor> prof) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(prof);

		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + prof.size());
	}


}