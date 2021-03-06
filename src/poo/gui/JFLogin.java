/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import poo.dados.DAO.PessoaDAO;
import poo.excecoes.SenhaIncorretaException;
import poo.excecoes.UsuarioNaoExiste;
import poo.negocios.Autenticar;
import poo.negocios.FachadaUsuario;
import poo.negocios.FormatacaoAuxiliar;

/**
 *
 * @author Davi Sales
 */


public class JFLogin extends javax.swing.JFrame {
	JFrameAdmin admin;
	JFrameAluno aluno;
	JFrameProfessor prof;
	FormatacaoAuxiliar format;
	ImageIcon img;
	/**
	 * Creates new form JFLogin
	 */



	public JFLogin() {
		initComponents();
		//        img = new ImageIcon("\");

		JRootPane rootPane = SwingUtilities.getRootPane(jBLogar);
		rootPane.setDefaultButton(jBLogar);
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
		jLabel5 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jBLimparLogin = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jBLogar = new javax.swing.JButton();
		jPSenhaLogin = new javax.swing.JPasswordField();
		jTUsuario = new javax.swing.JFormattedTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sistema Academico - DEINFO");
		setLocation(new java.awt.Point(0, 0));
		setResizable(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel1.setBackground(new java.awt.Color(0, 0, 102));

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Untitled-2.png"))); // NOI18N

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(29, 29, 29)
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(391, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE))
				);

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setText("Login");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 169, -1, -1));

		jBLimparLogin.setText("Limpar");
		jBLimparLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBLimparLoginActionPerformed(evt);
			}
		});

		jLabel3.setText("Senha:");

		jLabel2.setText("Usuario:");

		jBLogar.setText("Logar");
		jBLogar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBLogarActionPerformed(evt);
			}
		});
		jBLogar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jBLogarKeyPressed(evt);
			}
		});

		jPSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jPSenhaLoginActionPerformed(evt);
			}
		});
		jPSenhaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jPSenhaLoginKeyPressed(evt);
			}
		});

		try {
			jTUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(15, 15, 15)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jPSenhaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
										.addComponent(jTUsuario))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jBLimparLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jBLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jPSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3))
										.addGap(18, 18, 18)
										.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jBLogar)
												.addComponent(jBLimparLogin))
												.addContainerGap())
				);

		getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 204, -1, -1));

		setSize(new java.awt.Dimension(832, 538));
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void jPSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPSenhaLoginActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jPSenhaLoginActionPerformed

	private void jBLimparLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparLoginActionPerformed
		// TODO add your handling code here:
		jTUsuario.setText(null);
		jPSenhaLogin.setText("");
                jTUsuario.requestFocus();
	}//GEN-LAST:event_jBLimparLoginActionPerformed

	private void jBLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogarActionPerformed
		// TODO add your handling code here:
		FachadaUsuario auto = FachadaUsuario.getInstance();
			format = FormatacaoAuxiliar.getInstance();
			String usuario1 = jTUsuario.getText();
			char[] senhaC = jPSenhaLogin.getPassword();
			String senha = "";

			for(int i = 0; i < senhaC.length; i++){
				senha += senhaC[i];
			}

			String usuario = format.soNumerosCPF(usuario1);
			try{
				boolean existe = auto.usuarioExiste(usuario);
				if(existe){
					if(auto.tipoDeUsuario(usuario) == 3){
						boolean ok = auto.autenticaSenha(usuario, senha);
						if(ok){
							if(aluno == null || format == null){
								aluno = new JFrameAluno();
								aluno.setVisible(true);
								aluno.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								aluno.setExtendedState(aluno.MAXIMIZED_BOTH);
								this.setVisible(false);
								auto.logar(usuario);
							}else{
								aluno.setVisible(true);
								aluno.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								aluno.setExtendedState(aluno.MAXIMIZED_BOTH);
								this.setVisible(false);
								auto.logar(usuario);
							}
						}
					}else if(auto.tipoDeUsuario(usuario) == 2){
						boolean ok = auto.autenticaSenha(usuario, senha);
						if(ok){
							if(admin == null || format == null){
								admin = new JFrameAdmin();
								admin.setVisible(true);
								admin.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								admin.setExtendedState(admin.MAXIMIZED_BOTH);
								admin.setResizable(false);
								this.setVisible(false);
								auto.logar(usuario);
							}else{
								admin.setVisible(true);
								admin.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario),  auto.ultimoLogin(usuario));
								admin.setExtendedState(admin.MAXIMIZED_BOTH);
								admin.setResizable(false);
								this.setVisible(false);
								auto.logar(usuario);
							}
						}
					}else{
						if(auto.tipoDeUsuario(usuario) == 1){
							boolean ok = auto.autenticaSenha(usuario, senha);
							if(ok){
								if(admin == null || format == null){
									prof = new JFrameProfessor();
									prof.setVisible(true);
									prof.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
									prof.setExtendedState(prof.MAXIMIZED_BOTH);
									prof.setResizable(false);
									this.setVisible(false);
									auto.logar(usuario);
								}else{
									prof.setVisible(true);
									prof.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario),  auto.ultimoLogin(usuario));
									prof.setExtendedState(admin.MAXIMIZED_BOTH);
									prof.setResizable(false);
									this.setVisible(false);
									auto.logar(usuario);
								}
							}
						}
					}
				}
			}catch(UsuarioNaoExiste e){
				jTUsuario.setText(null);
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
			}catch(SenhaIncorretaException e){
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);

			}catch(SQLException e){
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);

			}

	}//GEN-LAST:event_jBLogarActionPerformed

	private void jBLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBLogarKeyPressed
		// TODO add your handling code here:
		//         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
		//             this.jBLogarActionPerformed(java.awt.event.ActionEvent a);
		//         }
	}//GEN-LAST:event_jBLogarKeyPressed

	private void jPSenhaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaLoginKeyPressed
		// TODO add your handling code here:
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			FachadaUsuario auto = FachadaUsuario.getInstance();
			format = FormatacaoAuxiliar.getInstance();
			String usuario1 = jTUsuario.getText();
			char[] senhaC = jPSenhaLogin.getPassword();
			String senha = "";

			for(int i = 0; i < senhaC.length; i++){
				senha += senhaC[i];
			}

			String usuario = format.soNumerosCPF(usuario1);
			try{
				boolean existe = auto.usuarioExiste(usuario);
				if(existe){
					if(auto.tipoDeUsuario(usuario) == 3){
						boolean ok = auto.autenticaSenha(usuario, senha);
						if(ok){
							if(aluno == null || format == null){
								aluno = new JFrameAluno();
								aluno.setVisible(true);
								aluno.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								aluno.setExtendedState(aluno.MAXIMIZED_BOTH);
								this.setVisible(false);
								auto.logar(usuario);
							}else{
								aluno.setVisible(true);
								aluno.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								aluno.setExtendedState(aluno.MAXIMIZED_BOTH);
								this.setVisible(false);
								auto.logar(usuario);
							}
						}
					}else if(auto.tipoDeUsuario(usuario) == 2){
						boolean ok = auto.autenticaSenha(usuario, senha);
						if(ok){
							if(admin == null || format == null){
								admin = new JFrameAdmin();
								admin.setVisible(true);
								admin.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
								admin.setExtendedState(admin.MAXIMIZED_BOTH);
								admin.setResizable(false);
								this.setVisible(false);
								auto.logar(usuario);
							}else{
								admin.setVisible(true);
								admin.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario),  auto.ultimoLogin(usuario));
								admin.setExtendedState(admin.MAXIMIZED_BOTH);
								admin.setResizable(false);
								this.setVisible(false);
								auto.logar(usuario);
							}
						}
					}else{
						if(auto.tipoDeUsuario(usuario) == 1){
							boolean ok = auto.autenticaSenha(usuario, senha);
							if(ok){
								if(admin == null || format == null){
									prof = new JFrameProfessor();
									prof.setVisible(true);
									prof.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario), auto.ultimoLogin(usuario));
									prof.setExtendedState(prof.MAXIMIZED_BOTH);
									prof.setResizable(false);
									this.setVisible(false);
									auto.logar(usuario);
								}else{
									prof.setVisible(true);
									prof.recebeValor(auto.nomeUsuario(usuario), format.formatarCpf(usuario),  auto.ultimoLogin(usuario));
									prof.setExtendedState(admin.MAXIMIZED_BOTH);
									prof.setResizable(false);
									this.setVisible(false);
									auto.logar(usuario);
								}
							}
						}
					}
				}
			}catch(UsuarioNaoExiste e){
				jTUsuario.setText(null);
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
			}catch(SenhaIncorretaException e){
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);

			}catch(SQLException e){
				jPSenhaLogin.setText(null);
				JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);

			}

		}
	}//GEN-LAST:event_jPSenhaLoginKeyPressed

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
			java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JFLogin().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jBLimparLogin;
	private javax.swing.JButton jBLogar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPasswordField jPSenhaLogin;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JFormattedTextField jTUsuario;
	// End of variables declaration//GEN-END:variables
}
