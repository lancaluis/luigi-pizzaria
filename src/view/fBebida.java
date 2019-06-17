/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BebidaController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class fBebida extends javax.swing.JFrame {
    
    private BebidaController listener;
  
    public fBebida() throws SQLException {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listener = new BebidaController(this);
        
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

    public BebidaController getListener() {
        return listener;
    }

    public void setListener(BebidaController listener) {
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

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public JPanel getPaBebida() {
        return paBebida;
    }

    public void setPaBebida(JPanel paCardapio) {
        this.paBebida = paBebida;
    }

    public JTable getTbBebida() {
        return tbBebida;
    }

    public void setTbBebida(JTable tbCardapio) {
        this.tbBebida = tbBebida;
    }

    public JTextField getTxtNomeBebida() {
        return txtNomeBebida;
    }

    public void setTxtNomeBebida(JTextField txtNomeCardapio) {
        this.txtNomeBebida = txtNomeBebida;
    }

    public JTextField getTxtPreco() {
        return txtPreco;
    }

    public void setTxtPreco(JTextField txtPreco) {
        this.txtPreco = txtPreco;
    }

    public JTextField getTxtTamanho() {
        return txtTamanho;
    }

    public void setTxtTamanho(JTextField txtTamanho) {
        this.txtTamanho = txtTamanho;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        paBebida = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeBebida = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btListarTodos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBebida = new javax.swing.JTable();
        btIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);

        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);

        paBebida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jLabel2.setText("Sabor");

        jLabel3.setText("Tamanho");

        txtNomeBebida.setEnabled(false);

        txtTamanho.setEnabled(false);

        jLabel7.setText("Preço: ");

        txtPreco.setEnabled(false);

        javax.swing.GroupLayout paBebidaLayout = new javax.swing.GroupLayout(paBebida);
        paBebida.setLayout(paBebidaLayout);
        paBebidaLayout.setHorizontalGroup(
            paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBebidaLayout.createSequentialGroup()
                .addGroup(paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paBebidaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paBebidaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paBebidaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCodigo))))
                    .addGroup(paBebidaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paBebidaLayout.setVerticalGroup(
            paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBebidaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addGroup(paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);

        btListarTodos.setText("Listar Todos");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("                     Pizzas");
        jLabel5.setOpaque(true);

        tbBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Sabor", "Descricao", "Tamanho", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        tbBebida.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tbBebida);
        tbBebida.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tbBebida.getColumnModel().getColumnCount() > 0) {
            tbBebida.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbBebida.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbBebida.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbBebida.getColumnModel().getColumn(3).setPreferredWidth(7);
            tbBebida.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        btIncluir.setText("Incluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btIncluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btListarTodos))
                        .addComponent(paBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btListarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleName("Vinhos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(fBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fBebida().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fBebida.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JPanel paBebida;
    private javax.swing.JTable tbBebida;
    private javax.swing.JTextField txtNomeBebida;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
