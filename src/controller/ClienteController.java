package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Cliente;
import model.ClienteDAO;
import view.ClienteTM;
import view.fCliente;

public class ClienteController implements ActionListener, ListSelectionListener{
    
    private fCliente frmCliente;
    
    private ClienteDAO dao = new ClienteDAO();
    
    private char flagInsAltCons = 'C'; // I --> Incluir  A--> Alterar - C-->Consulta;
    
    private ClienteTM tabModel;
    
    
    public ClienteController(fCliente frmCliente) throws SQLException{
        
        this.frmCliente = frmCliente;
        inicializaTableModel();
        adicionarListeners();
        
    }

    public ClienteController() {}
    
    private void inicializaTableModel() throws SQLException {
        
        tabModel = new ClienteTM();
        frmCliente.getTbCardapio().setModel(tabModel);
    }
     
    private void adicionarListeners() {
        frmCliente.getBtIncluir().addActionListener(this);
        frmCliente.getBtAlterar().addActionListener(this);
        frmCliente.getBtExcluir().addActionListener(this);
        frmCliente.getBtSalvar().addActionListener(this);
        frmCliente.getBtCancelar().addActionListener(this);
        frmCliente.getBtListarTodos().addActionListener(this);
        frmCliente.getTbCardapio().getSelectionModel().addListSelectionListener(this);
    }   
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        
        if(acao.getActionCommand().equals("Incluir")){
            incluirProduto();
        } else if (acao.getActionCommand().equals("Alterar")){
            alterarProduto();
        } else if (acao.getActionCommand().equals("Excluir")){
            excluirProduto();
        } else if (acao.getActionCommand().equals("Salvar")){
            salvarProduto();
        } else if (acao.getActionCommand().equals("Cancelar")){
            cancelarProduto();
        } else if (acao.getActionCommand().equals("Listar Todos")){
            listarTodos();
        }
     }

    private void incluirProduto() {
        habilitarBotoesSalvar();
        limparCampos(frmCliente.getPaCardapio());
        flagInsAltCons = 'I';
        
    }

    private void alterarProduto() {
        if(!"".equals(frmCliente.getLblCodigo().getText())){
          habilitarBotoesSalvar();
          flagInsAltCons = 'A';
        }
    }

    private void excluirProduto() {
      
        if(!"".equals(frmCliente.getLblCodigo().getText())){
            int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.YES_NO_OPTION);
        
            if (op==0){
                try{
                    dao.Excluir(dadosFrmProduto());
                }catch (SQLException e){
                }
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                listarTodos();
                limparCampos(frmCliente.getPaCardapio());
           }
        }
    }

    private void salvarProduto() {
        
        try{
            if(flagInsAltCons=='I'){
                int codCardapio;
                codCardapio = dao.Inserir(dadosFrmProduto());
                frmCliente.getLblCodigo().setText(Integer.toString(codCardapio));
                tabModel.addCliente(dadosFrmProduto());
            }
            else{
                dao.Alterar(dadosFrmProduto());
                
                tabModel.setValueAt(frmCliente.getTxtNome().getText(), frmCliente.getTbCardapio().getSelectedRow(),1);
                tabModel.setValueAt(frmCliente.getTxtTelefone().getText(), frmCliente.getTbCardapio().getSelectedRow(),2);
                tabModel.setValueAt(frmCliente.getTxtEndereco().getText(), frmCliente.getTbCardapio().getSelectedRow(),3);
               
            }
        }catch (SQLException e){
            
        }
        desabilitarBotoesSalvar();
        habilitaDesabilitaPainel(frmCliente.getPaCardapio(), false);
        listarTodos();
        flagInsAltCons = 'C';
    }

    private void cancelarProduto() {
        desabilitarBotoesSalvar();
        frmCliente.getTbCardapio().setEnabled(true);
    }

    private void listarTodos() {
        try {
            tabModel.limpar();
            tabModel.setClientes(dao.ListaClientes());
        } catch (SQLException ex) {
            Logger.getLogger(controller.ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilita botoes Alterar e Excluir
        frmCliente.getBtAlterar().setEnabled(true);
        frmCliente.getBtExcluir().setEnabled(true);
    }

    private void habilitarBotoesSalvar() {
       habilitaDesabilitaBotoes(true);
       habilitaDesabilitaPainel(frmCliente.getPaCardapio(), true);
       
    }

    private void habilitaDesabilitaBotoes(boolean habilitado) {
        
        frmCliente.getBtIncluir().setEnabled(!habilitado);
        frmCliente.getBtAlterar().setEnabled(!habilitado);
        frmCliente.getBtExcluir().setEnabled(!habilitado);
        frmCliente.getBtSalvar().setEnabled(habilitado);
        frmCliente.getBtCancelar().setEnabled(habilitado);
        frmCliente.getBtListarTodos().setEnabled(!habilitado);
        frmCliente.getTbCardapio().setEnabled(!habilitado);
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
        frmCliente.getLblCodigo().setText("");
    }

    private Cliente dadosFrmProduto() {
       Cliente cliente = new Cliente();
       
       if(flagInsAltCons != 'I')       
          cliente.setCodigo(Integer.parseInt(frmCliente.getLblCodigo().getText()));
           
       cliente.setNome(frmCliente.getTxtNome().getText());
       cliente.setTelefone(frmCliente.getTxtTelefone().getText());
       cliente.setEndereco(frmCliente.getTxtEndereco().getText());
       return cliente;
       
    }
    
    private void dadosProdutoFrm(Cliente cliente) {
        
        frmCliente.getLblCodigo().setText(""+cliente.getCodigo());
        frmCliente.getTxtNome().setText(cliente.getNome());
        frmCliente.getTxtTelefone().setText(cliente.getTelefone());
        frmCliente.getTxtEndereco().setText(""+cliente.getEndereco());
    }

    private void desabilitarBotoesSalvar() {
        habilitaDesabilitaBotoes(false);
        habilitaDesabilitaPainel(frmCliente.getPaCardapio(), false);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) throws IndexOutOfBoundsException{
                
        try {
            Cliente cliente = tabModel.getClientes().get(frmCliente.getTbCardapio().getSelectedRow());
            dadosProdutoFrm(cliente);
        }catch (IndexOutOfBoundsException e) {
        }
    }
}
