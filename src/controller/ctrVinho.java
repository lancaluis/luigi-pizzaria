/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Vinho;
import modelo.VinhoDao;
import visao.VinhoTM;
import visao.fVinhos;

/**
 *
 * @author ef
 */
public class ctrVinho implements ActionListener, ListSelectionListener{
    
    
    private fVinhos frmVinhos;
    
    private VinhoDao dao = new VinhoDao();
    
    private char flagInsAltCons = 'C'; // I --> Incluir  A--> Alterar - C-->Consulta;
    
    private VinhoTM tabModel;
    
    
    public ctrVinho(fVinhos frmVinhos) throws SQLException{
        
        this.frmVinhos = frmVinhos;
        inicializaTableModel();
        adicionarListeners();
        
    }

    public ctrVinho() {
    }
    
    private void inicializaTableModel() throws SQLException {
        
        tabModel = new VinhoTM();
        frmVinhos.getTbVinho().setModel(tabModel);
        //frmVinhos.getTbVinho().getSelectionModel().addListSelectionListener(this);  
    }
    
    private void adicionarListeners() {
        frmVinhos.getBtIncluir().addActionListener(this);
        frmVinhos.getBtAlterar().addActionListener(this);
        frmVinhos.getBtExcluir().addActionListener(this);
        frmVinhos.getBtSalvar().addActionListener(this);
        frmVinhos.getBtCancelar().addActionListener(this);
        frmVinhos.getBtListarTodos().addActionListener(this);
        frmVinhos.getBtPesquisar().addActionListener(this);
        frmVinhos.getTbVinho().getSelectionModel().addListSelectionListener(this);
    }   
    

    @Override
    public void actionPerformed(ActionEvent acao) {
        
        if(acao.getActionCommand().equals("Incluir")){
            incluirVinho();
        } else if (acao.getActionCommand().equals("Alterar")){
            alterarVinho();
        } else if (acao.getActionCommand().equals("Excluir")){
            excluirVinho();
        } else if (acao.getActionCommand().equals("Salvar")){
            salvarVinho();
        } else if (acao.getActionCommand().equals("Cancelar")){
            cancelarVinho();
        } else if (acao.getActionCommand().equals("Listar Todos")){
            listarTodos();
        } else if (acao.getActionCommand().equals("Pesquisar")){
            pesquisarVinho();
        }
     }

    private void incluirVinho() {
        //habilita botoes salvar/cancelar e depois limpa campos
        habilitarBotoesSalvar();
        limparCampos(frmVinhos.getPaVinho());
        flagInsAltCons = 'I';
        
    }

    private void alterarVinho() {
        if(!"".equals(frmVinhos.getLblCodigo().getText())){
          habilitarBotoesSalvar();
          flagInsAltCons = 'A';
        }
    }

    private void excluirVinho() {
      
        if(!"".equals(frmVinhos.getLblCodigo().getText())){
            int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.YES_NO_OPTION);
        
            if (op==0){
                try{
                    dao.Excluir(dadosFrmVinho());
                }catch (SQLException e){
                }
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                listarTodos();
                limparCampos(frmVinhos.getPaVinho());
           }
        }
    }

    private void salvarVinho() {
        
        try{
            if(flagInsAltCons=='I'){
                //adiciona o vinho e atualiza o Label com o código autoincremento gerado pelo BD
                int codVinho;
                codVinho = dao.Inserir(dadosFrmVinho());
                frmVinhos.getLblCodigo().setText(Integer.toString(codVinho));
                tabModel.addVinho(dadosFrmVinho());
            }
            else{
                dao.Alterar(dadosFrmVinho());
                
                tabModel.setValueAt(frmVinhos.getTxtNomeVinho().getText(), frmVinhos.getTbVinho().getSelectedRow(),1);
                tabModel.setValueAt(frmVinhos.getTxtPais().getText(), frmVinhos.getTbVinho().getSelectedRow(),2);
                tabModel.setValueAt(frmVinhos.getTxtSafra().getText(), frmVinhos.getTbVinho().getSelectedRow(),3);
                tabModel.setValueAt(frmVinhos.getTxtPreco().getText(), frmVinhos.getTbVinho().getSelectedRow(),4);
                
               // tabModel.alteraVinho(dadosFrmVinho(), frmVinhos.getTbVinho().getSelectedRow());
            }
        }catch (SQLException e){
            
        }
        desabilitarBotoesSalvar();
        habilitaDesabilitaPainel(frmVinhos.getPaVinho(), false);
        listarTodos();
        flagInsAltCons = 'C';
    }

    private void cancelarVinho() {
        desabilitarBotoesSalvar();
        frmVinhos.getTbVinho().setEnabled(true);
    }

    private void listarTodos() {
        try {
            tabModel.limpar();
            tabModel.setVinhos(dao.ListaVinhos());
        } catch (SQLException ex) {
            Logger.getLogger(ctrVinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilita botoes Alterar e Excluir
        frmVinhos.getBtAlterar().setEnabled(true);
        frmVinhos.getBtExcluir().setEnabled(true);
    }

    private void pesquisarVinho() {
        Vinho vinho;
        try{
            vinho = dao.localizarVinho(frmVinhos.getTxtLocalizar().getText());
            dadosVinhoFrm(vinho);
        }catch(SQLException e){
            
        }
    }

    private void habilitarBotoesSalvar() {
       habilitaDesabilitaBotoes(true);
       habilitaDesabilitaPainel(frmVinhos.getPaVinho(), true);
       
    }

    private void habilitaDesabilitaBotoes(boolean habilitado) {
        
        frmVinhos.getBtIncluir().setEnabled(!habilitado);
        frmVinhos.getBtAlterar().setEnabled(!habilitado);
        frmVinhos.getBtExcluir().setEnabled(!habilitado);
        frmVinhos.getBtSalvar().setEnabled(habilitado);
        frmVinhos.getBtCancelar().setEnabled(habilitado);
        frmVinhos.getBtListarTodos().setEnabled(!habilitado);
        frmVinhos.getTbVinho().setEnabled(!habilitado);
    }

    private void habilitaDesabilitaPainel(JPanel panel, boolean habilitado) {
        
        Component[] componente = panel.getComponents();
        
        for(Component comp : componente){
            if (comp instanceof JTextField){
                JTextField textField = (JTextField)comp;
                textField.setEnabled(habilitado);
            }
        }
    }

    private void limparCampos(JPanel panel) {
        
        Component[] componente = panel.getComponents();
        
        for(Component comp : componente){
            if (comp instanceof JTextField){
                JTextField textField = (JTextField)comp;
                textField.setText("");
            }
        }  
        frmVinhos.getLblCodigo().setText("");
    }

    private Vinho dadosFrmVinho() {
       Vinho vinho = new Vinho();
       
       if(flagInsAltCons != 'I')       
          vinho.setCodigo(Integer.parseInt(frmVinhos.getLblCodigo().getText()));
           
       vinho.setNome(frmVinhos.getTxtNomeVinho().getText());
       vinho.setPais(frmVinhos.getTxtPais().getText());
       vinho.setSafra(Integer.parseInt(frmVinhos.getTxtSafra().getText()));
       vinho.setPreco(Double.parseDouble(frmVinhos.getTxtPreco().getText()));
       return vinho;
       
    }
    
    private void dadosVinhoFrm(Vinho vinho) {
        
        frmVinhos.getLblCodigo().setText(""+vinho.getCodigo());
        frmVinhos.getTxtNomeVinho().setText(vinho.getNome());
        frmVinhos.getTxtPais().setText(vinho.getPais());
        frmVinhos.getTxtSafra().setText(""+vinho.getSafra());
        frmVinhos.getTxtPreco().setText(""+vinho.getPreco());
    }

    private void desabilitarBotoesSalvar() {
        habilitaDesabilitaBotoes(false);
        habilitaDesabilitaPainel(frmVinhos.getPaVinho(), false);
        
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) throws IndexOutOfBoundsException{
                
        try {
            Vinho vinho = tabModel.getVinhos().get(frmVinhos.getTbVinho().getSelectedRow());
            dadosVinhoFrm(vinho);
        }catch (IndexOutOfBoundsException e) {
        }
    }
}
