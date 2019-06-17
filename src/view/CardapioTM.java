package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cardapio;

public class CardapioTM extends AbstractTableModel{
    
    private ArrayList<Cardapio> linhas;
    private String[] colunas = new String[]{"Código","Sabor","Descrição","Tamanho","Preço"};
    
    public CardapioTM(){
        linhas = new ArrayList<Cardapio>();
    }
    
    public CardapioTM(ArrayList<Cardapio> cardapios){
        linhas = new ArrayList<Cardapio>(cardapios);
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override 
    public String getColumnName(int coluna){
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getCodigo();
            case 1:
                return linhas.get(linha).getNome();
            case 2:
                return linhas.get(linha).getDescricao();
            case 3:
                return linhas.get(linha).getTamanho();
            case 4:
                return linhas.get(linha).getPreco();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                linhas.get(linha).setCodigo(Integer.parseInt((String)valor));
                break;
            case 1:
                linhas.get(linha).setNome((String)valor);
                break;
            case 2:
                linhas.get(linha).setDescricao((String)valor);
                break;
            case 3:
                linhas.get(linha).setTamanho((String)valor);
                break;
            case 4:
                linhas.get(linha).setPreco(Double.parseDouble((String)valor));
        } 
        fireTableRowsUpdated(linha, linha);
    }
    
    public void addCardapio(Cardapio c){       
        linhas.add(c);
        fireTableDataChanged();
    }
    
    public void remove(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public Cardapio getCardapio(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public List<Cardapio> getCardapios(){
        return linhas;
    }
    
    public void setCardapios(List<Cardapio> cardapios){
        
        int tamanhoAntigo = this.getRowCount();
        linhas.addAll(cardapios);
        fireTableRowsInserted(tamanhoAntigo, this.getRowCount() - 1);
    }
    
    public void limpar(){
        linhas.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return linhas.isEmpty();
    }
}
