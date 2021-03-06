/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui.myframes;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import poo.gui.PDFViewer;
import poo.negocios.FachadaSistema;
import poo.negocios.beans.Disciplina;

/**
 *
 * @author Thiago Gomes
 */
public class FrameBuscaAvancada2 extends javax.swing.JInternalFrame {

    private FachadaSistema fachada;
    private TableModelSistema modelo = new TableModelSistema();
    private ArrayList<String> chaves = new ArrayList<String>();
    private ArrayList<Disciplina> buscadas = new ArrayList<Disciplina>();

    /**
     * Creates new form FrameBuscaAvancada2
     */
    public FrameBuscaAvancada2() {
        initComponents();
    }

    public void pesquisar(TableModelSistema aux) {
        if (aux.getColumnCount() > 0) {
            aux.removeAll();
        }
        aux.addListaDisciplinas(this.buscadas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Busca Avançada de Disciplinas");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jTable1MouseClicked(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("Palavra(s) chave(s): ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            chaves.clear();
            fachada = FachadaSistema.getInstance();
            if (jTextField1.getText().contains(" ")) {
                StringTokenizer st = new StringTokenizer(jTextField1.getText(), " ", false);
                String temp;
                while (st.hasMoreTokens()) {
                    temp = st.nextToken();
                    if (temp != null) {
                        chaves.add(st.nextToken());
                    }
                }
            } else {
                chaves.add(jTextField1.getText().toString());
            }
            this.buscadas.clear();
            System.out.println("TAMANHO:" + this.buscadas.size());
            buscadas = fachada.searchAdvancedVariasChaves(chaves);
            System.out.println("TAMANHO:" + this.buscadas.size());
            TableModelSistema modeloLocal = new TableModelSistema();
            this.pesquisar(modeloLocal);
            System.out.println(modeloLocal.toString());
            jTable1 = new JTable(modeloLocal);
            jScrollPane1.setViewportView(jTable1);
            jTable1.setColumnSelectionAllowed(true);
            jTable1.setRowHeight(40);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(1).setResizable(true);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jTable1.addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // TODO Auto-generated method stub
                    if (jTable1.columnAtPoint(e.getPoint()) == 5) {
                        int i = jTable1.getSelectedRow();
                        Object codigo = jTable1.getModel().getValueAt(i, 0);
                        PDFViewer pdf;
                        try {
                            pdf = new PDFViewer(codigo.toString());
                            pdf.setVisible(true);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
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
            //jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

	}//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            chaves.clear();
            fachada = FachadaSistema.getInstance();
            if (jTextField1.getText().contains(" ")) {
                StringTokenizer st = new StringTokenizer(jTextField1.getText(), " ", false);
                String temp;
                while (st.hasMoreTokens()) {
                    temp = st.nextToken();
                    if (temp != null) {
                        chaves.add(st.nextToken());
                    }
                }
            } else {
                chaves.add(jTextField1.getText().toString());
            }
            this.buscadas.clear();
            System.out.println("TAMANHO:" + this.buscadas.size());
            buscadas = fachada.searchAdvancedVariasChaves(chaves);
            System.out.println("TAMANHO:" + this.buscadas.size());
            TableModelSistema modeloLocal = new TableModelSistema();
            this.pesquisar(modeloLocal);
            System.out.println(modeloLocal.toString());
            jTable1 = new JTable(modeloLocal);
            jScrollPane1.setViewportView(jTable1);

//                jTable1.getTableHeader().setReorderingAllowed(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(1).setResizable(true);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setResizable(false);

//                jTable1.setColumnSelectionInterval(0, modeloLocal.getColumnCount()-1);
//		jTable1.setColumnSelectionAllowed(true);
            jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) throws IOException {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON2) {
            int i = jTable1.getSelectedRow();
            Object codigo = jTable1.getModel().getValueAt(i, 0);
            PdfView pdf = new PdfView();
            pdf.setup(codigo.toString());
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int i = jTable1.getSelectedRow();
            Object codigo = jTable1.getModel().getValueAt(i, 0);
            PdfView pdf = new PdfView();
            pdf.setup(codigo.toString());
        }

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
