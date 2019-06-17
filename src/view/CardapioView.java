package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cardapio;

public class CardapioView extends AbstractTableModel{
    
    private ArrayList<Cardapio> linhas;
    private String[] colunas = new String[]{"Código","Sabor","Descrição","Tamanho","Preço"};
    
    public CardapioView(){
        linhas = new ArrayList<Cardapio>();
    }
    
    public CardapioView(ArrayList<Cardapio> produtos){
        linhas = new ArrayList<Cardapio>(produtos);
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
                return linhas.get(linha).getPais();
            case 3:
                return linhas.get(linha).getSafra();
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
                linhas.get(linha).setPais((String)valor);
                break;
            case 3:
                linhas.get(linha).setSafra(Integer.parseInt((String)valor));
                break;
            case 4:
                linhas.get(linha).setPreco(Double.parseDouble((String)valor));
        } 
        fireTableRowsUpdated(linha, linha);
    }
    
    public void addProdutos(Cardapio v){       
        linhas.add(v);
        fireTableDataChanged();
    }
    
    public void remove(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public Cardapio getProduto(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public List<Cardapio> getProdutos(){
        return linhas;
    }
    
    public void setProdutos(List<Cardapio> produtos){
        
        int tamanhoAntigo = this.getRowCount();

        linhas.addAll(produtos);
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
