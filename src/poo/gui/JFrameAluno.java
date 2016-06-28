/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Gomes
 */
public class JFrameAluno extends javax.swing.JFrame {
	private String nome, cpf, lastLogin;

    /**
     * Creates new form JFrameAdmin
     */


    public void setValores(String nome, String cpf, String last){
        this.nome = nome;
        this.cpf = cpf;
        this.lastLogin = last;
    }
    
    public JFrameAluno() {
        this.setValores(nome, cpf, lastLogin);
        System.out.println(nome+cpf);
        initComponents();
        Font nova = new Font("Arial", Font.BOLD, 14);
        Color branco = new Color(255,255,255);
        jTNameUser.setFont(nova);
        Color padrao = new Color(22, 34, 58);
        jTNameUser.setText(this.nome);
        jTCPFUser.setText(this.cpf);
        jTCPFUser.setEditable(false);
        jTNameUser.setEditable(false);
        jTLastLogin.setEditable(false);
        jTCPFUser.setBackground(padrao);
        jTNameUser.setBackground(padrao);
        jTLastLogin.setBackground(padrao);
        jTCPFUser.setForeground(branco);
        jTNameUser.setForeground(branco);
        jTLastLogin.setForeground(branco);
        this.setVisible(true);
    }

    
    public void recebeValor(String nome, String cpf, String last){
        this.nome = nome;
        this.cpf = cpf;
        this.lastLogin = last;
        jTLastLogin.setText(last);
        jTNameUser.setText(nome.toUpperCase());
        jTCPFUser.setText(cpf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTNameUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTCPFUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTLastLogin = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuMyAccAlterarSenha = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuMyAccSair = new javax.swing.JMenuItem();
        mnuProfessor = new javax.swing.JMenu();
        mnuProfessorListar = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuDisciplina = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        mnuBuscar = new javax.swing.JMenu();
        mnuBuscarNovaConsulta = new javax.swing.JMenuItem();
        mnuSobre = new javax.swing.JMenu();
        mnuSobreVersao = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSobreSistema = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem11.setText("jMenuItem11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Academico - DEINFO (Aluno)");
        setLocation(new java.awt.Point(200, 150));

        desktop.setBackground(new java.awt.Color(212, 52, 52));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jLabel1.setText("NOME USUÁRIO: ");

        jLabel2.setText("CPF:");

        jTCPFUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCPFUserActionPerformed(evt);
            }
        });

        jLabel3.setText("ULTIMO LOGIN: ");

        jTLastLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLastLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTCPFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTCPFUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("Minha Conta");

        mnuMyAccAlterarSenha.setText("Alterar Senha");
        jMenu1.add(mnuMyAccAlterarSenha);
        jMenu1.add(jSeparator3);

        mnuMyAccSair.setText("Sair");
        mnuMyAccSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMyAccSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMyAccSair);

        jMenuBar1.add(jMenu1);

        mnuProfessor.setText("Professor");

        mnuProfessorListar.setText("Listar Professores");
        mnuProfessor.add(mnuProfessorListar);

        jMenuItem4.setText("Buscar Professor");
        mnuProfessor.add(jMenuItem4);

        jMenuBar1.add(mnuProfessor);

        mnuDisciplina.setText("Disciplina");

        jMenuItem10.setText("Listar Disciplinas");
        mnuDisciplina.add(jMenuItem10);

        jMenuItem12.setText("Buscar Disciplina");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        mnuDisciplina.add(jMenuItem12);

        jMenuBar1.add(mnuDisciplina);

        mnuBuscar.setText("Buscar");

        mnuBuscarNovaConsulta.setText("Nova consulta");
        mnuBuscar.add(mnuBuscarNovaConsulta);

        jMenuBar1.add(mnuBuscar);

        mnuSobre.setText("Sobre");

        mnuSobreVersao.setText("Sobre a versão");
        mnuSobreVersao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSobreVersaoActionPerformed(evt);
            }
        });
        mnuSobre.add(mnuSobreVersao);
        mnuSobre.add(jSeparator2);

        mnuSobreSistema.setText("Sobre o sistema");
        mnuSobreSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSobreSistemaActionPerformed(evt);
            }
        });
        mnuSobre.add(mnuSobreSistema);

        jMenuBar1.add(mnuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSobreVersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobreVersaoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Sistema academico - DEinfo\nVersão 1.0", "Versão do sistema", -1);
    }//GEN-LAST:event_mnuSobreVersaoActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void mnuMyAccSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMyAccSairActionPerformed
        // TODO add your handling code here:
        JFLogin f = new JFLogin();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuMyAccSairActionPerformed

    private void jTCPFUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCPFUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCPFUserActionPerformed

    private void jTLastLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLastLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLastLoginActionPerformed

    private void mnuSobreSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobreSistemaActionPerformed
        // TODO add your handling code here:
        Object[] options = { "Sim", "Nao" };
        JOptionPane.showOptionDialog(null, "Professor, gostou do nosso aplicativo?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    }//GEN-LAST:event_mnuSobreSistemaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextField jTCPFUser;
    private javax.swing.JTextField jTLastLogin;
    private javax.swing.JTextField jTNameUser;
    private javax.swing.JMenu mnuBuscar;
    private javax.swing.JMenuItem mnuBuscarNovaConsulta;
    private javax.swing.JMenu mnuDisciplina;
    private javax.swing.JMenuItem mnuMyAccAlterarSenha;
    private javax.swing.JMenuItem mnuMyAccSair;
    private javax.swing.JMenu mnuProfessor;
    private javax.swing.JMenuItem mnuProfessorListar;
    private javax.swing.JMenu mnuSobre;
    private javax.swing.JMenuItem mnuSobreSistema;
    private javax.swing.JMenuItem mnuSobreVersao;
    // End of variables declaration//GEN-END:variables
}
