/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui;

import static java.awt.SystemColor.desktop;
import javax.swing.JOptionPane;
import poo.gui.myframes.FrameBuscarUsuario;
import poo.gui.myframes.FrameCadastroDisciplina;
import poo.gui.myframes.FrameCadastroProfessor;
import poo.gui.myframes.FrameCadastroUsuario;
import poo.gui.myframes.FrameDesativarUsuario;
import poo.gui.myframes.FrameEditarUsuario;
import poo.gui.myframes.FrameListarUsuarios;
import poo.gui.myframes.FrameNovaConsulta;
import poo.gui.myframes.JFrameAlterarSenha;

/**
 *
 * @author Thiago Gomes
 */
public class JFCoordenadorViceCurso extends javax.swing.JFrame {

    /**
     * Creates new form JFCoordenadorViceCurso
     */
    public JFCoordenadorViceCurso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        mnuMinhaContaAlterarSenha = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuMinhaContaSair = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        mnuUsuarioAdicionar = new javax.swing.JMenuItem();
        mnuUsuarioEditar = new javax.swing.JMenuItem();
        mnuUsuarioBuscar = new javax.swing.JMenuItem();
        mnuUsuarioListar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuUsuarioDesativar = new javax.swing.JMenuItem();
        mnuProfessor = new javax.swing.JMenu();
        mnuProfessorAdd = new javax.swing.JMenuItem();
        mnuProfessorAtualizar = new javax.swing.JMenuItem();
        mnuProfessorRemover = new javax.swing.JMenuItem();
        mnuProfessorListar = new javax.swing.JMenuItem();
        mnuDisciplina = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuBuscar = new javax.swing.JMenu();
        mnuBuscarNovaConsulta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuSobre = new javax.swing.JMenu();
        mnuSobreVersao = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSobreSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
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

        mnuMinhaContaAlterarSenha.setText("Alterar senha");
        mnuMinhaContaAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMinhaContaAlterarSenhaActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMinhaContaAlterarSenha);
        jMenu1.add(jSeparator3);

        mnuMinhaContaSair.setText("Sair");
        mnuMinhaContaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMinhaContaSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMinhaContaSair);

        jMenuBar1.add(jMenu1);

        mnuUsuario.setText("Usuario");

        mnuUsuarioAdicionar.setText("Adicionar");
        mnuUsuarioAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioAdicionarActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuUsuarioAdicionar);

        mnuUsuarioEditar.setText("Editar");
        mnuUsuarioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioEditarActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuUsuarioEditar);

        mnuUsuarioBuscar.setText("Buscar");
        mnuUsuarioBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioBuscarActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuUsuarioBuscar);

        mnuUsuarioListar.setText("Listar");
        mnuUsuarioListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioListarActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuUsuarioListar);
        mnuUsuario.add(jSeparator1);

        mnuUsuarioDesativar.setText("Desativar Usuario");
        mnuUsuarioDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioDesativarActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuUsuarioDesativar);

        jMenuBar1.add(mnuUsuario);

        mnuProfessor.setText("Professor");

        mnuProfessorAdd.setText("Adicionar Professor");
        mnuProfessorAdd.setToolTipText("");
        mnuProfessorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProfessorAddActionPerformed(evt);
            }
        });
        mnuProfessor.add(mnuProfessorAdd);
        mnuProfessorAdd.getAccessibleContext().setAccessibleDescription("Adiciona um professor ao sistema");

        mnuProfessorAtualizar.setText("Alterar Professor");
        mnuProfessorAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProfessorAtualizarActionPerformed(evt);
            }
        });
        mnuProfessor.add(mnuProfessorAtualizar);

        mnuProfessorRemover.setText("Remover Professor");
        mnuProfessor.add(mnuProfessorRemover);

        mnuProfessorListar.setText("Listar Professores");
        mnuProfessor.add(mnuProfessorListar);

        jMenuBar1.add(mnuProfessor);

        mnuDisciplina.setText("Disciplina");

        jMenuItem5.setText("Adicionar Disciplina");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuDisciplina.add(jMenuItem5);

        jMenuItem7.setText("Atualizar Disciplina");
        mnuDisciplina.add(jMenuItem7);

        jMenuItem8.setText("Remover Disciplina");
        mnuDisciplina.add(jMenuItem8);

        jMenuItem10.setText("Listar Disciplinas");
        mnuDisciplina.add(jMenuItem10);

        jMenuBar1.add(mnuDisciplina);

        mnuBuscar.setText("Buscar");

        mnuBuscarNovaConsulta.setText("Nova consulta");
        mnuBuscarNovaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBuscarNovaConsultaActionPerformed(evt);
            }
        });
        mnuBuscar.add(mnuBuscarNovaConsulta);

        jMenuBar1.add(mnuBuscar);

        jMenu2.setText("Relatórios");

        jMenuItem1.setText("Relatório Professor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem12.setText("Relatório Periodo");
        jMenu2.add(jMenuItem12);

        jMenuItem4.setText("Relatório Disciplina");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Matricula");

        jMenuItem2.setText("Matricular Aluno");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

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
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMinhaContaAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMinhaContaAlterarSenhaActionPerformed
        // TODO add your handling code here:
        JFrameAlterarSenha f = new JFrameAlterarSenha();
        f.setVisible(true);
        f.recebeUsuario(jTCPFUser.getText());
        f.setLocation(new java.awt.Point(500, 200));

    }//GEN-LAST:event_mnuMinhaContaAlterarSenhaActionPerformed

    private void mnuMinhaContaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMinhaContaSairActionPerformed
        // TODO add your handling code here:
        /*
        FALTA FAZER METODO NA CAMADA DE NEGOCIOS PARA LOGOUT
        */
        JFLogin f = new JFLogin();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuMinhaContaSairActionPerformed

    private void mnuUsuarioAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioAdicionarActionPerformed
        // TODO add your handling code here:
        FrameCadastroUsuario f = new FrameCadastroUsuario();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioAdicionarActionPerformed

    private void mnuUsuarioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioEditarActionPerformed
        // TODO add your handling code here:
        FrameEditarUsuario f = new FrameEditarUsuario();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioEditarActionPerformed

    private void mnuUsuarioBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioBuscarActionPerformed
        // TODO add your handling code here:
        FrameBuscarUsuario f = new FrameBuscarUsuario();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioBuscarActionPerformed

    private void mnuUsuarioListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioListarActionPerformed
        // TODO add your handling code here:
        FrameListarUsuarios f = new FrameListarUsuarios();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioListarActionPerformed

    private void mnuUsuarioDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioDesativarActionPerformed
        // TODO add your handling code here:
        FrameDesativarUsuario f = new FrameDesativarUsuario();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioDesativarActionPerformed

    private void mnuProfessorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProfessorAddActionPerformed
        // TODO add your handling code here:
        FrameCadastroProfessor f = new FrameCadastroProfessor();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuProfessorAddActionPerformed

    private void mnuProfessorAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProfessorAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuProfessorAtualizarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        FrameCadastroDisciplina f = new FrameCadastroDisciplina();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mnuBuscarNovaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscarNovaConsultaActionPerformed
        // TODO add your handling code here:
        FrameNovaConsulta f = new FrameNovaConsulta();
        desktop.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_mnuBuscarNovaConsultaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuSobreVersaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobreVersaoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Sistema academico - DEinfo\nVersão 1.0", "Versão do sistema", -1);
    }//GEN-LAST:event_mnuSobreVersaoActionPerformed

    private void jTCPFUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCPFUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCPFUserActionPerformed

    private void jTLastLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLastLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLastLoginActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(JFCoordenadorViceCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCoordenadorViceCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCoordenadorViceCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCoordenadorViceCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCoordenadorViceCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextField jTCPFUser;
    private javax.swing.JTextField jTLastLogin;
    private javax.swing.JTextField jTNameUser;
    private javax.swing.JMenu mnuBuscar;
    private javax.swing.JMenuItem mnuBuscarNovaConsulta;
    private javax.swing.JMenu mnuDisciplina;
    private javax.swing.JMenuItem mnuMinhaContaAlterarSenha;
    private javax.swing.JMenuItem mnuMinhaContaSair;
    private javax.swing.JMenu mnuProfessor;
    private javax.swing.JMenuItem mnuProfessorAdd;
    private javax.swing.JMenuItem mnuProfessorAtualizar;
    private javax.swing.JMenuItem mnuProfessorListar;
    private javax.swing.JMenuItem mnuProfessorRemover;
    private javax.swing.JMenu mnuSobre;
    private javax.swing.JMenuItem mnuSobreSistema;
    private javax.swing.JMenuItem mnuSobreVersao;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JMenuItem mnuUsuarioAdicionar;
    private javax.swing.JMenuItem mnuUsuarioBuscar;
    private javax.swing.JMenuItem mnuUsuarioDesativar;
    private javax.swing.JMenuItem mnuUsuarioEditar;
    private javax.swing.JMenuItem mnuUsuarioListar;
    // End of variables declaration//GEN-END:variables
}