/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui.myframes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import poo.negocios.FachadaSistema;
import poo.negocios.beans.Disciplina;

/**
 *
 * @author Thiago Gomes
 */
public class FrameBuscaAvancada extends javax.swing.JInternalFrame {
    private FachadaSistema fachada;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String textoBusca;
   
    /**
     * Creates new form FrameBuscaAvancada
     */
    public FrameBuscaAvancada() {
        initComponents();
        //fachada = FachadaSistema.getInstance();
        
        this.criaJTable();
        this.pesquisar(modelo);
        
//        jTResultados.
    }

    private void criaJTable() {
		jTResultados = new JTable(modelo);
		modelo.addColumn("Codio");
		modelo.addColumn("Nome");
		modelo.addColumn("Periodizacao");
		modelo.addColumn("Carga Horaria");
                modelo.addColumn("Ementa");
		jTResultados.getColumnModel().getColumn(0).setPreferredWidth(10);
		jTResultados.getColumnModel().getColumn(1).setPreferredWidth(120);
		jTResultados.getColumnModel().getColumn(2).setPreferredWidth(10);
		jTResultados.getColumnModel().getColumn(3).setPreferredWidth(10);
                jTResultados.getColumnModel().getColumn(4).setPreferredWidth(10);
		pesquisar(modelo);
                
	}
    
    
        public void pesquisar(DefaultTableModel modelo) {
                fachada = FachadaSistema.getInstance();
                String[] resultados = new String[5];
                int posicao = 0;
                StringTokenizer st = new StringTokenizer(textoBusca, ",", false);
                while(st.hasMoreTokens()){
                    resultados[posicao] = st.nextToken();
                    posicao++;
                }
		modelo.setNumRows(0);
		ArrayList<Disciplina> list = fachada.searchAdvancedVariasChaves(resultados);

		for (Disciplina aux : list) {
			modelo.addRow(new Object[]{aux.getCodigo(), aux.getNome(), aux.getCurso(), aux.getCargaHoraria(), null});
		}
        }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTBusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();

        setClosable(true);
        setTitle("Busca Avançada (Disciplina)");

        jLabel1.setText("Palavra(s) chave(s):");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Carga Horaria", "Obrigatoria", "Optativa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTResultados.setColumnSelectionAllowed(true);
        jTResultados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTResultados);
        jTResultados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTResultados.getColumnModel().getColumnCount() > 0) {
            jTResultados.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTResultados.getColumnModel().getColumn(0).setMaxWidth(90);
            jTResultados.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTResultados.getColumnModel().getColumn(2).setMaxWidth(90);
            jTResultados.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTResultados.getColumnModel().getColumn(3).setMaxWidth(90);
            jTResultados.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTResultados.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTBusca)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        textoBusca = jTBusca.getText();
        fachada = FachadaSistema.getInstance();
        String busca = jTBusca.getText();
        this.criaJTable();
        this.pesquisar(modelo);
//        TableModel model = new TableModel.ge
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTBusca;
    private javax.swing.JTable jTResultados;
    // End of variables declaration//GEN-END:variables
}
