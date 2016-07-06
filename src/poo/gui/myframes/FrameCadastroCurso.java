/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui.myframes;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.negocios.FachadaSistema;
import poo.negocios.beans.Curso;
import poo.negocios.beans.Departamento;

/**
 *
 * @author Davi Sales
 */
public class FrameCadastroCurso extends javax.swing.JInternalFrame {
    private FachadaSistema fachada;
    /**
     * Creates new form FrameCadastroCurso
     */
    public FrameCadastroCurso() throws SQLException {
        initComponents();
        preencher();
        preencher2();
    }
    
    public void preencher() throws SQLException{
        fachada = FachadaSistema.getInstance();
        ArrayList<String> aux = fachada.listaDepartamentosPorNomeList();
        for(String a : aux ){
            jCDepartamentos.addItem(a);
        }
    }
    
    public void preencher2(){
        fachada = FachadaSistema.getInstance();
        ArrayList<Integer> aux = fachada.retornarAnosAteAtualList();
        for(Integer a : aux ){
            jCAnos.addItem(a.toString());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTNomeCurso = new javax.swing.JTextField();
        jCDepartamentos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRGraduacao = new javax.swing.JRadioButton();
        jRPosGraducao = new javax.swing.JRadioButton();
        jCAnos = new javax.swing.JComboBox<>();
        jBConfirma = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        buttonGroup1.add(jRGraduacao);
        buttonGroup1.add(jRPosGraducao);

        setClosable(true);
        setTitle("Cadastro Curso");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do curso"));

        jLabel3.setText("Tipo:");

        jCDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDepartamentosActionPerformed(evt);
            }
        });

        jLabel2.setText("Ano Inicio:");

        jLabel1.setText("Nome:");

        jLabel4.setText("Departamento:");

        jRGraduacao.setText("Graduacao");
        jRGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRGraduacaoActionPerformed(evt);
            }
        });

        jRPosGraducao.setText("Pos Graduacao");
        jRPosGraducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRPosGraducaoActionPerformed(evt);
            }
        });

        jCAnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String []{ "Selecione"}));
        jCAnos.setToolTipText("Selecione");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTNomeCurso)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRGraduacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRPosGraducao))
                            .addComponent(jCAnos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRGraduacao)
                    .addComponent(jRPosGraducao))
                .addContainerGap())
        );

        jBConfirma.setText("Confirmar");
        jBConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmaActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jBConfirma))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRGraduacaoActionPerformed

    private void jBConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmaActionPerformed
        // TODO add your handling code here:
        int result = 0;
        boolean ok = false;
        
        
        try{
            fachada = FachadaSistema.getInstance();
            String nome = jTNomeCurso.getText();
            String depat = jCDepartamentos.getSelectedItem().toString();
            int ano = Integer.parseInt(jCAnos.getSelectedItem().toString());
            boolean graduacao = false;
            if(jRGraduacao.isSelected()){
                graduacao = true;
            }
            Curso aux = new Curso(nome, graduacao);
            aux.setAnoInicio(ano);
            Departamento depatN = new Departamento(depat);
            aux.setDepat(depatN);
            fachada.cadastroCurso(aux);
            ok = true;
        }catch(Exception e){
            
        }
        
        if(ok){
            JOptionPane.showConfirmDialog(null, "Curso Cadastrado com sucesso", "Sucesso", -1);
        }else{
            JOptionPane.showConfirmDialog(null, "Não foi possivel cadastrar o curso", "Erro", -1);
        }
        
        result = fachada.okcancel("Deseja adicionar um novo curso?", "Alerta");
        
        if( result == 2){
            this.setVisible(false);
        }
        
        ok = false;
        jTNomeCurso.setText(null);
        jCDepartamentos.setSelectedIndex(0);
        jCAnos.setSelectedIndex(0);
        
    
        
    }//GEN-LAST:event_jBConfirmaActionPerformed

    private void jCDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDepartamentosActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jCDepartamentosActionPerformed

    private void jRPosGraducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRPosGraducaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRPosGraducaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        jTNomeCurso.setText("");
        jCAnos.setSelectedIndex(0);
        jCDepartamentos.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConfirma;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCAnos;
    private javax.swing.JComboBox<String> jCDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRGraduacao;
    private javax.swing.JRadioButton jRPosGraducao;
    private javax.swing.JTextField jTNomeCurso;
    // End of variables declaration//GEN-END:variables
}
