package model;

import dao.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardapioDAO {

    private Connection con = null;
    private PreparedStatement stm;
    private ResultSet rs;
    private DbConnection dao;
    
    public CardapioDAO(){
        dao = new DbConnection();
        try{
            con = dao.getConnection();
        }
        
        catch(SQLException e){
            
        }
    }
    
    public int Inserir (Cardapio produto) throws SQLException{
        
        String sql = " Insert into pizza (nome,descricao,tamanho,preco) values (?,?,?,?)";
        
        stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setString(3, produto.getTamanho());
        stm.setDouble(4, produto.getPreco());
        
        stm.executeUpdate();
        
        rs = stm.getGeneratedKeys();
        
        if(rs.next()){
            produto.setCodigo(rs.getInt(1));
        }
        
        return produto.getCodigo();
    }
    
    public void Alterar (Cardapio produto) throws SQLException{
        String sql = "Update pizza set nome=?, descricao=?, tamanho=?, preco=? where id_pizza=?";
        
        stm = con.prepareStatement(sql);
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setString(3, produto.getTamanho());
        stm.setDouble(4, produto.getPreco());
        stm.setInt(5, produto.getCodigo());
        
        stm.executeUpdate();
    }
    
    public void Excluir (Cardapio produto) throws SQLException{
        
        String sql = "Delete from pizza where id_pizza =?";
        stm = con.prepareStatement(sql);
        stm.setInt(1,produto.getCodigo());
        stm.executeUpdate();
    }
    
    public Cardapio localizarProduto(String produto) throws SQLException{
        
        String sql = "Select * from pizza where nome = ? ";
        
        stm = con.prepareStatement(sql);
        stm.setString(1,produto);
        rs = stm.executeQuery();
        
        Cardapio prod = new Cardapio(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getDouble(5));
        
        return prod;
    }
    
    public ArrayList<Cardapio> ListaProdutros() throws SQLException{
       
        ArrayList<Cardapio> produtos = new ArrayList<Cardapio>();
        
        String sql = "Select * From pizza";
        
        stm = con.prepareStatement(sql);
        rs = stm.executeQuery();
        
        while(rs.next()){
            produtos.add(new Cardapio(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getDouble(5)));
        }
        return produtos;
    }
}