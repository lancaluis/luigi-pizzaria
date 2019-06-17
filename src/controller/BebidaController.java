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
import model.Bebida;
import model.BebidaDAO;
import view.BebidaTM;
import view.fBebida;

public class BebidaController implements ActionListener, ListSelectionListener{
    
    private fBebida frmBebida;
    
    private BebidaDAO dao = new BebidaDAO();
    
    private char flagInsAltCons = 'C'; // I --> Incluir  A--> Alterar - C-->Consulta;
    
    private BebidaTM tabModel;
    
    
    public BebidaController(fBebida frmBebida) throws SQLException{
        
        this.frmBebida = frmBebida;
        inicializaTableModel();
        adicionarListeners();
        
    }

    public BebidaController() {}
    
    private void inicializaTableModel() throws SQLException {
        
        tabModel = new BebidaTM();
        frmBebida.getTbBebida().setModel(tabModel);
    }
     
    private void adicionarListeners() {
        frmBebida.getBtIncluir().addActionListener(this);
        frmBebida.getBtAlterar().addActionListener(this);
        frmBebida.getBtExcluir().addActionListener(this);
        frmBebida.getBtSalvar().addActionListener(this);
        frmBebida.getBtCancelar().addActionListener(this);
        frmBebida.getBtListarTodos().addActionListener(this);
        frmBebida.getTbBebida().getSelectionModel().addListSelectionListener(this);
    }   
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        
        if(acao.getActionCommand().equals("Incluir")){
            incluirBebida();
        } else if (acao.getActionCommand().equals("Alterar")){
            alterarBebida();
        } else if (acao.getActionCommand().equals("Excluir")){
            excluirBebida();
        } else if (acao.getActionCommand().equals("Salvar")){
            salvarBebida();
        } else if (acao.getActionCommand().equals("Cancelar")){
            cancelarBebida();
        } else if (acao.getActionCommand().equals("Listar Todos")){
            listarTodos();
        }
     }

    private void incluirBebida() {
        habilitarBotoesSalvar();
        limparCampos(frmBebida.getPaBebida());
        flagInsAltCons = 'I';
        
    }

    private void alterarBebida() {
        if(!"".equals(frmBebida.getLblCodigo().getText())){
          habilitarBotoesSalvar();
          flagInsAltCons = 'A';
        }
    }

    private void excluirBebida() {
      
        if(!"".equals(frmBebida.getLblCodigo().getText())){
            int op = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Exclusão", JOptionPane.YES_NO_OPTION);
        
            if (op==0){
                try{
                    dao.Excluir(dadosFrmBebida());
                }catch (SQLException e){
                }
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                listarTodos();
                limparCampos(frmBebida.getPaBebida());
           }
        }
    }

    private void salvarBebida() {
        
        try{
            if(flagInsAltCons=='I'){
                int codBebida;
                codBebida = dao.Inserir(dadosFrmBebida());
                frmBebida.getLblCodigo().setText(Integer.toString(codBebida));
                tabModel.addBebida(dadosFrmBebida());
            }
            else{
                dao.Alterar(dadosFrmBebida());
                
                tabModel.setValueAt(frmBebida.getTxtNomeBebida().getText(), frmBebida.getTbBebida().getSelectedRow(),1);
                tabModel.setValueAt(frmBebida.getTxtTamanho().getText(), frmBebida.getTbBebida().getSelectedRow(),3);
                tabModel.setValueAt(frmBebida.getTxtPreco().getText(), frmBebida.getTbBebida().getSelectedRow(),4);
               
            }
        }catch (SQLException e){
            
        }
        desabilitarBotoesSalvar();
        habilitaDesabilitaPainel(frmBebida.getPaBebida(), false);
        listarTodos();
        flagInsAltCons = 'C';
    }

    private void cancelarBebida() {
        desabilitarBotoesSalvar();
        frmBebida.getTbBebida().setEnabled(true);
    }

    private void listarTodos() {
        try {
            tabModel.limpar();
            tabModel.setCardapios(dao.ListaBebidas());
        } catch (SQLException ex) {
            Logger.getLogger(controller.BebidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //habilita botoes Alterar e Excluir
        frmBebida.getBtAlterar().setEnabled(true);
        frmBebida.getBtExcluir().setEnabled(true);
    }

    private void habilitarBotoesSalvar() {
       habilitaDesabilitaBotoes(true);
       habilitaDesabilitaPainel(frmBebida.getPaBebida(), true);
       
    }

    private void habilitaDesabilitaBotoes(boolean habilitado) {
        
        frmBebida.getBtIncluir().setEnabled(!habilitado);
        frmBebida.getBtAlterar().setEnabled(!habilitado);
        frmBebida.getBtExcluir().setEnabled(!habilitado);
        frmBebida.getBtSalvar().setEnabled(habilitado);
        frmBebida.getBtCancelar().setEnabled(habilitado);
        frmBebida.getBtListarTodos().setEnabled(!habilitado);
        frmBebida.getTbBebida().setEnabled(!habilitado);
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
        frmBebida.getLblCodigo().setText("");
    }

    private Bebida dadosFrmBebida() {
       Bebida bebida = new Bebida();
       
       if(flagInsAltCons != 'I')       
          bebida.setCodigo(Integer.parseInt(frmBebida.getLblCodigo().getText()));
           
       bebida.setNome(frmBebida.getTxtNomeBebida().getText());
       bebida.setTamanho(frmBebida.getTxtTamanho().getText());
       bebida.setPreco(Double.parseDouble(frmBebida.getTxtPreco().getText()));
       return bebida;
       
    }
    
    private void dadosProdutoFrm(Bebida bebida) {
        
        frmBebida.getLblCodigo().setText(""+bebida.getCodigo());
        frmBebida.getTxtNomeBebida().setText(bebida.getNome());
        frmBebida.getTxtTamanho().setText(""+bebida.getTamanho());
        frmBebida.getTxtPreco().setText(""+bebida.getPreco());
    }

    private void desabilitarBotoesSalvar() {
        habilitaDesabilitaBotoes(false);
        habilitaDesabilitaPainel(frmBebida.getPaBebida(), false);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) throws IndexOutOfBoundsException{
                
        try {
            Bebida bebida = tabModel.getBebidas().get(frmBebida.getTbBebida().getSelectedRow());
            dadosProdutoFrm(bebida);
        }catch (IndexOutOfBoundsException e) {
        }
    }
}
