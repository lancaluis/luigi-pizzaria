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
import model.Cardapio;
import model.CardapioDAO;
import view.CardapioTM;
import view.CardapioView;
import view.fCardapio;

public class PizzariaController implements ActionListener, ListSelectionListener{
    
    private fCardapio frmCardapio;
    
    private CardapioDAO dao = new CardapioDAO();
    
    private char flagInsAltCons = 'C'; // I --> Incluir  A--> Alterar - C-->Consulta;
    
    private CardapioTM tabModel;
    
    
    public PizzariaController(fCardapio frmCardapio) throws SQLException{
        
        this.frmCardapio = frmCardapio;
        inicializaTableModel();
        adicionarListeners();
        
    }

    public PizzariaController() {}
    
    private void inicializaTableModel() throws SQLException {
        
        tabModel = new CardapioTM();
        frmCardapio.getTbCardapio().setModel(tabModel);
    }
     
    private void adicionarListeners() {
        frmCardapio.getBtIncluir().addActionListener(this);
        frmCardapio.getBtAlterar().addActionListener(this);
        frmCardapio.getBtExcluir().addActionListener(this);
        frmCardapio.getBtSalvar().addActionListener(this);
        frmCardapio.getBtCancelar().addActionListener(this);
        frmCardapio.getBtListarTodos().addActionListener(this);
        frmCardapio.getBtPesquisar().addActionListener(this);
        frmCardapio.getTbCardapio().getSelectionModel().addListSelectionListener(this);
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
        } else if (acao.getActionCommand().equals("Pesquisar")){
            pesquisarProduto();
        }
     }

    private void incluirProduto() {
        habilitarBotoesSalvar();
        limparCampos(frmCardapio.getPaCardapio());
        flagInsAltCons = 'I';
        
    }

    private void alterarProduto() {
        if(!"".equals(frmCardapio.getLblCodigo().getText())){
          habilitarBotoesSalvar();
          flagInsAltCons = 'A';
        }
    }

    private void excluirProduto() {
      
        if(!"".equals(frmCardapio.getLblCodigo().getText())){
            int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.YES_NO_OPTION);
        
            if (op==0){
                try{
                    dao.Excluir(dadosFrmProduto());
                }catch (SQLException e){
                }
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                listarTodos();
                limparCampos(frmCardapio.getPaCardapio());
           }
        }
    }

    private void salvarProduto() {
        
        try{
            if(flagInsAltCons=='I'){
                int codCardapio;
                codCardapio = dao.Inserir(dadosFrmProduto());
                frmCardapio.getLblCodigo().setText(Integer.toString(codCardapio));
                tabModel.addCardapio(dadosFrmProduto());
            }
            else{
                dao.Alterar(dadosFrmProduto());
                
                tabModel.setValueAt(frmCardapio.getTxtNomeCardapio().getText(), frmCardapio.getTbCardapio().getSelectedRow(),1);
                tabModel.setValueAt(frmCardapio.getTxtDescricao().getText(), frmCardapio.getTbCardapio().getSelectedRow(),2);
                tabModel.setValueAt(frmCardapio.getTxtTamanho().getText(), frmCardapio.getTbCardapio().getSelectedRow(),3);
                tabModel.setValueAt(frmCardapio.getTxtPreco().getText(), frmCardapio.getTbCardapio().getSelectedRow(),4);
               
            }
        }catch (SQLException e){
            
        }
        desabilitarBotoesSalvar();
        habilitaDesabilitaPainel(frmCardapio.getPaCardapio(), false);
        listarTodos();
        flagInsAltCons = 'C';
    }

    private void cancelarProduto() {
        desabilitarBotoesSalvar();
        frmCardapio.getTbCardapio().setEnabled(true);
    }

    private void listarTodos() {
        try {
            tabModel.limpar();
            tabModel.setCardapios(dao.ListaProdutos());
        } catch (SQLException ex) {
            Logger.getLogger(controller.PizzariaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilita botoes Alterar e Excluir
        frmCardapio.getBtAlterar().setEnabled(true);
        frmCardapio.getBtExcluir().setEnabled(true);
    }

    private void pesquisarProduto() {
        Cardapio cardapio;
        try{
            cardapio = dao.localizarProduto(frmCardapio.getTxtLocalizar().getText());
            dadosProdutoFrm(cardapio);
        }catch(SQLException e){
            
        }
    }

    private void habilitarBotoesSalvar() {
       habilitaDesabilitaBotoes(true);
       habilitaDesabilitaPainel(frmCardapio.getPaCardapio(), true);
       
    }

    private void habilitaDesabilitaBotoes(boolean habilitado) {
        
        frmCardapio.getBtIncluir().setEnabled(!habilitado);
        frmCardapio.getBtAlterar().setEnabled(!habilitado);
        frmCardapio.getBtExcluir().setEnabled(!habilitado);
        frmCardapio.getBtSalvar().setEnabled(habilitado);
        frmCardapio.getBtCancelar().setEnabled(habilitado);
        frmCardapio.getBtListarTodos().setEnabled(!habilitado);
        frmCardapio.getTbCardapio().setEnabled(!habilitado);
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
        frmCardapio.getLblCodigo().setText("");
    }

    private Cardapio dadosFrmProduto() {
       Cardapio cardapio = new Cardapio();
       
       if(flagInsAltCons != 'I')       
          cardapio.setCodigo(Integer.parseInt(frmCardapio.getLblCodigo().getText()));
           
       cardapio.setNome(frmCardapio.getTxtNomeCardapio().getText());
       cardapio.setDescricao(frmCardapio.getTxtDescricao().getText());
       cardapio.setTamanho(frmCardapio.getTxtTamanho().getText());
       cardapio.setPreco(Double.parseDouble(frmCardapio.getTxtPreco().getText()));
       return cardapio;
       
    }
    
    private void dadosProdutoFrm(Cardapio cardapio) {
        
        frmCardapio.getLblCodigo().setText(""+cardapio.getCodigo());
        frmCardapio.getTxtNomeCardapio().setText(cardapio.getNome());
        frmCardapio.getTxtDescricao().setText(cardapio.getDescricao());
        frmCardapio.getTxtTamanho().setText(""+cardapio.getTamanho());
        frmCardapio.getTxtPreco().setText(""+cardapio.getPreco());
    }

    private void desabilitarBotoesSalvar() {
        habilitaDesabilitaBotoes(false);
        habilitaDesabilitaPainel(frmCardapio.getPaCardapio(), false);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) throws IndexOutOfBoundsException{
                
        try {
            Cardapio cardapio = tabModel.getCardapios().get(frmCardapio.getTbCardapio().getSelectedRow());
            dadosProdutoFrm(cardapio);
        }catch (IndexOutOfBoundsException e) {
        }
    }
}
