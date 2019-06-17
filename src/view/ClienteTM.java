package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

public class ClienteTM extends AbstractTableModel{
    
    private ArrayList<Cliente> linhas;
    private String[] colunas = new String[]{"Código","Nome","Telefone","Endereço"};
    
    public ClienteTM(){
        linhas = new ArrayList<Cliente>();
    }
    
    public ClienteTM(ArrayList<Cliente> Clientes){
        linhas = new ArrayList<Cliente>(Clientes);
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
                return linhas.get(linha).getTelefone();
            case 3:
                return linhas.get(linha).getEndereco();
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
                linhas.get(linha).setTelefone((String)valor);
                break;
            case 3:
                linhas.get(linha).setEndereco((String)valor);
                break;
        } 
        fireTableRowsUpdated(linha, linha);
    }
    
    public void addCliente(Cliente c){       
        linhas.add(c);
        fireTableDataChanged();
    }
    
    public void remove(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public Cliente getCliente(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public List<Cliente> getClientes(){
        return linhas;
    }
    
    public void setClientes(List<Cliente> Clientes){
        
        int tamanhoAntigo = this.getRowCount();
        linhas.addAll(Clientes);
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
