/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui.myframes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import poo.negocios.FachadaSistema;
import poo.negocios.beans.Disciplina;
import poo.negocios.beans.Horario;
import poo.negocios.beans.Localizacao;
import poo.negocios.beans.Professor;

/**
 *
 * @author Lucas
 */
public class FrameCadastroOferta extends javax.swing.JInternalFrame {
	private FachadaSistema fachada;
	private DefaultListModel<String> modeloListaProfessor = new DefaultListModel<String>();
	private ArrayList<String> listaProfessoresString = new ArrayList<String>();
	private ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
	private ArrayList<Horario> horarios = new ArrayList<Horario>();
	private Localizacao local;
	private Disciplina ofertaD;

	/**
	 * Creates new form FrameCadastroOferta
	 */
	public FrameCadastroOferta() {
		initComponents();
		jTCodigoDisciplina.setEditable(false);
		jTNomeDisciplina.setEditable(false);
		this.preencherDepartamentos();
		jListProfessores = new JList<String>();
		jListProfessores.setModel(modeloListaProfessor);
		jListProfessores.setVisibleRowCount(5);
		this.preencherLocalPredio();
		this.preencherJTableHorarios();
	}
	
	
	public void preencherLocalPredio(){
		fachada = FachadaSistema.getInstance();
		ArrayList<String> aux = null;
		aux = fachada.listaPredios();
		for(String a: aux){
			jCListaPredios.addItem(a);
		}
		
	}
	
	public void preencherLocalSalas(){
		jCListaSalas.removeAllItems();
		fachada = FachadaSistema.getInstance();
		ArrayList<Integer> aux = null;
		aux = fachada.listaSalasPorPredio(jCListaPredios.getSelectedItem().toString());
		for(Integer a : aux){
			jCListaSalas.addItem(a.toString());
		}
	}
	

	public void preencherDepartamentos(){
		fachada = FachadaSistema.getInstance();
		ArrayList<String> aux = null;
		try {
			aux = fachada.listaDepartamentosPorNomeList();
		} catch (SQLException ex) {
			Logger.getLogger(FrameListarDisciplinas2.class.getName()).log(Level.SEVERE, null, ex);
		}
		jCDepartamentos.addItem("Selecione um Departamento...");
		for(String a : aux ){
			jCDepartamentos.addItem(a);
		}
		

	}


	public void preencherFiltroCursos(){
		jCFiltroCursos.removeAllItems();
		fachada = FachadaSistema.getInstance();
		ArrayList<String> aux = fachada.listarCursosPorDepartamentoList(jCDepartamentos.getSelectedItem().toString());
		for(String a : aux ){
			jCFiltroCursos.addItem(a);
		}
	}

	public String soNumerosCPF(String cpf){
        String resultado = "";
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(4, 7);
        String bloco3 = cpf.substring(8, 11);
        String bloco4 = cpf.substring(12, 14);
        resultado = bloco1+bloco2+bloco3+bloco4;
        return resultado;
    }
	
	public void preencherJTableHorarios(){
		TableModelHorario modelo = new TableModelHorario();
		jTableHorarios.setModel(modelo);
		if(modelo.getRowCount() > 0){
			modelo.removeAll();
		}
		fachada = FachadaSistema.getInstance();
		modelo.addListaDisciplinas(fachada.listarHorarios());
		
		jTableHorarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableHorarios.getColumnModel().getColumn(0).setMaxWidth(30);
		jTableHorarios.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTableHorarios.getColumnModel().getColumn(0).setResizable(false);
		jTableHorarios.getColumnModel().getColumn(1).setMaxWidth(40);
		jTableHorarios.getColumnModel().getColumn(1).setPreferredWidth(40);
		jTableHorarios.getColumnModel().getColumn(1).setResizable(false);
		jTableHorarios.getTableHeader().setReorderingAllowed(false);
		
	}
	
	public void preencherJTableProfessores(){
		TableModelProfessor modelo = new TableModelProfessor();
		jTableProfessores.setModel(modelo);
		if(modelo.getRowCount() > 0){
			modelo.removeAll();
		}
		fachada = FachadaSistema.getInstance();
		modelo.addListaDisciplinas(fachada.listarProfessoresPorDepartamento(jCDepartamentos.getSelectedItem().toString()));
		listaProfessores = fachada.listarProfessoresPorDepartamento(jCDepartamentos.getSelectedItem().toString());
		jTableProfessores.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = jTableProfessores.getSelectedRow();
				Object codigo = jTableProfessores.getModel().getValueAt(i, 0);
				Professor aux = fachada.buscarProfessorPorCPF(soNumerosCPF(codigo.toString()));
				modeloListaProfessor.addElement(aux.getPnome()+" "+aux.getUnome());
				listaProfessoresString.add(aux.getPnome()+" "+aux.getUnome());
				listaProfessores.add(aux);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
	}

	public void preencherJTableDisciplinas(){
		TableModelEdit modelo = new TableModelEdit();
		jTableDisciplinas.setModel(modelo);

		if(modelo.getRowCount() > 0){
			modelo.removeAll();
		}

		fachada = FachadaSistema.getInstance();
		modelo.addListaDisciplinas(fachada.listarDisciplinasPorCurso(jCFiltroCursos.getSelectedItem().toString()));
		jTableDisciplinas.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = jTableDisciplinas.getSelectedRow();
				Object codigo = jTableDisciplinas.getModel().getValueAt(i, 0);
				Disciplina aux = fachada.buscarDisciplinaPorCodigo(codigo.toString());
				jTCodigoDisciplina.setText(aux.getCodigo());
				jTNomeDisciplina.setText(aux.getNome());
				ofertaD = aux;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		jTableDisciplinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableDisciplinas.getColumnModel().getColumn(0).setMaxWidth(80);
		jTableDisciplinas.getColumnModel().getColumn(0).setPreferredWidth(80);
		jTableDisciplinas.getColumnModel().getColumn(0).setResizable(false);
		jTableDisciplinas.getTableHeader().setReorderingAllowed(false);

	}


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCDepartamentos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jCFiltroCursos = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisciplinas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProfessores = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCListaPredios = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCListaSalas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHorarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListHorarios = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTCodigoDisciplina = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListProfessores = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTNomeDisciplina = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Cadastro Oferta Disciplina");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

        jCDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDepartamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));

        jCFiltroCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCFiltroCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCFiltroCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCFiltroCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 255), null, null));

        jTableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableDisciplinas);

        jTabbedPane1.addTab("Disciplinas", jScrollPane1);

        jTableProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableProfessores);

        jTabbedPane1.addTab("Professores", jScrollPane2);

        jLabel5.setText("Predio:");

        jCListaPredios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCListaPrediosActionPerformed(evt);
            }
        });

        jLabel6.setText("Sala: ");

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCListaPredios, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCListaSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCListaPredios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCListaSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Localizações", jPanel4);

        jTableHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableHorarios);

        jTabbedPane1.addTab("Horarios", jScrollPane3);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes da oferta"));

        jLabel3.setText("Horários:");

        jLabel4.setText("Localizacao:");

        jScrollPane5.setViewportView(jListHorarios);

        jLabel1.setText("Codigo Disciplina:");

        jLabel2.setText("Professores da Oferta:");

        jListProfessores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jListProfessores);

        jLabel7.setText("Nome Disciplina:");

        jButton3.setText("Remover");

        jButton4.setText("Remover");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTCodigoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTNomeDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTCodigoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(85, 85, 85))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jButton2.setText("Continuar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jCFiltroCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCFiltroCursosActionPerformed
		// TODO add your handling code here:
		preencherJTableDisciplinas();
	}//GEN-LAST:event_jCFiltroCursosActionPerformed

    private void jCDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDepartamentosActionPerformed
        // TODO add your handling code here:
        preencherFiltroCursos();
        preencherJTableProfessores();
    }//GEN-LAST:event_jCDepartamentosActionPerformed

    private void jCListaPrediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCListaPrediosActionPerformed
        // TODO add your handling code here:
        preencherLocalSalas();
    }//GEN-LAST:event_jCListaPrediosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int i = fachada.buscarIdLocalizacao(jCListaPredios.getSelectedItem().toString(), Integer.parseInt(jCListaSalas.getSelectedItem().toString()));
        local = new Localizacao(i);
        local.setPredio(jCListaPredios.getSelectedItem().toString());
        local.setSala(Integer.parseInt(jCListaSalas.getSelectedItem().toString()));
        jTextField2.setText(jCListaPredios.getSelectedItem().toString()+" Sala: "+jCListaSalas.getSelectedItem().toString());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCDepartamentos;
    private javax.swing.JComboBox<String> jCFiltroCursos;
    private javax.swing.JComboBox<String> jCListaPredios;
    private javax.swing.JComboBox<String> jCListaSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jListHorarios;
    private javax.swing.JList<String> jListProfessores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTCodigoDisciplina;
    private javax.swing.JTextField jTNomeDisciplina;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDisciplinas;
    private javax.swing.JTable jTableHorarios;
    private javax.swing.JTable jTableProfessores;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
