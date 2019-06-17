/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ctrVinho;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ef
 */
public class fVinhos extends javax.swing.JFrame {
    
    private ctrVinho listener;
    
    /**ˆ
     * Creates new form fVinhos
     */
    
    public fVinhos() throws SQLException {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listener = new ctrVinho(this);
        
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public JButton getBtAlterar() {
        return btAlterar;
    }

    public ctrVinho getListener() {
        return listener;
    }

    public void setListener(ctrVinho listener) {
        this.listener = listener;
    }

    public void setBtAlterar(JButton btAlterar) {
        this.btAlterar = btAlterar;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public void setBtCancelar(JButton btCancelar) {
        this.btCancelar = btCancelar;
    }

    public JButton getBtExcluir() {
        return btExcluir;
    }

    public void setBtExcluir(JButton btExcluir) {
        this.btExcluir = btExcluir;
    }

    public JButton getBtIncluir() {
        return btIncluir;
    }

    public void setBtIncluir(JButton btIncluir) {
        this.btIncluir = btIncluir;
    }

    public JButton getBtListarTodos() {
        return btListarTodos;
    }

    public void setBtListarTodos(JButton btListarTodos) {
        this.btListarTodos = btListarTodos;
    }

    public JButton getBtPesquisar() {
        return btPesquisar;
    }

    public void setBtPesquisar(JButton btPesquisar) {
        this.btPesquisar = btPesquisar;
    }

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public JPanel getPaVinho() {
        return paVinho;
    }

    public void setPaVinho(JPanel paVinho) {
        this.paVinho = paVinho;
    }

    public JTable getTbVinho() {
        return tbVinho;
    }

    public void setTbVinho(JTable tbVinho) {
        this.tbVinho = tbVinho;
    }

    public JTextField getTxtLocalizar() {
        return txtLocalizar;
    }

    public void setTxtLocalizar(JTextField txtLocalizar) {
        this.txtLocalizar = txtLocalizar;
    }

    public JTextField getTxtNomeVinho() {
        return txtNomeVinho;
    }

    public void setTxtNomeVinho(JTextField txtNomeVinho) {
        this.txtNomeVinho = txtNomeVinho;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    public JTextField getTxtPreco() {
        return txtPreco;
    }

    public void setTxtPreco(JTextField txtPreco) {
        this.txtPreco = txtPreco;
    }

    public JTextField getTxtSafra() {
        return txtSafra;
    }

    public void setTxtSafra(JTextField txtSafra) {
        this.txtSafra = txtSafra;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        paVinho = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeVinho = new javax.swing.JTextField();
        txtSafra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        txtLocalizar = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        btListarTodos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVinho = new javax.swing.JTable();
        btIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit24.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete24.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/success24.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);

        paVinho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jLabel2.setText("Nome Vinho:");

        jLabel3.setText("Safra:");

        txtNomeVinho.setEnabled(false);

        txtSafra.setEnabled(false);

        jLabel6.setText("País");

        txtPais.setEnabled(false);

        jLabel7.setText("Preço: ");

        txtPreco.setEnabled(false);

        javax.swing.GroupLayout paVinhoLayout = new javax.swing.GroupLayout(paVinho);
        paVinho.setLayout(paVinhoLayout);
        paVinhoLayout.setHorizontalGroup(
            paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paVinhoLayout.createSequentialGroup()
                .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paVinhoLayout.createSequentialGroup()
                        .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paVinhoLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paVinhoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paVinhoLayout.createSequentialGroup()
                                .addComponent(txtSafra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreco))
                            .addComponent(txtNomeVinho, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo)))
                    .addGroup(paVinhoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paVinhoLayout.setVerticalGroup(
            paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paVinhoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addGap(23, 23, 23)
                .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeVinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paVinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSafra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel24.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);

        txtLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");

        btListarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Open-Folder-Full24.png"))); // NOI18N
        btListarTodos.setText("Listar Todos");

        jLabel4.setText("Localizar Vinho por nome:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/brancorouge.jpeg"))); // NOI18N
        jLabel5.setText("        Vinhos");
        jLabel5.setOpaque(true);

        tbVinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Vinho", "País", "Safra", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVinho.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tbVinho);
        tbVinho.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tbVinho.getColumnModel().getColumnCount() > 0) {
            tbVinho.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbVinho.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbVinho.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbVinho.getColumnModel().getColumn(3).setPreferredWidth(7);
            tbVinho.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add2-24.png"))); // NOI18N
        btIncluir.setText("Incluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btListarTodos))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paVinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btListarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paVinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleName("Vinhos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizarActionPerformed

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
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fVinhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fVinhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fVinhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fVinhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fVinhos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fVinhos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btListarTodos;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JPanel paVinho;
    private javax.swing.JTable tbVinho;
    private javax.swing.JTextField txtLocalizar;
    private javax.swing.JTextField txtNomeVinho;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtSafra;
    // End of variables declaration//GEN-END:variables
}