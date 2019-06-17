package model;

import dao.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BebidaDAO {

    private Connection con = null;
    private PreparedStatement stm;
    private ResultSet rs;
    private DbConnection dao;
    
    public BebidaDAO(){
        dao = new DbConnection();
        try{
            con = dao.getConnection();
        }
        
        catch(SQLException e){
            
        }
    }
    
    public int Inserir (Bebida bebida) throws SQLException{
        
        String sql = " Insert into bebida (nome,tamanho,preco) values (?,?,?)";
        
        stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setString(1, bebida.getNome());
        stm.setString(2, bebida.getTamanho());
        stm.setDouble(3, bebida.getPreco());
        
        stm.executeUpdate();
        
        rs = stm.getGeneratedKeys();
        
        if(rs.next()){
            bebida.setCodigo(rs.getInt(1));
        }
        
        return bebida.getCodigo();
    }
    
    public void Alterar (Bebida bebida) throws SQLException{
        String sql = "Update bebida set nome=?, tamanho=?, preco=? where id_bebida=?";
        
        stm = con.prepareStatement(sql);
        stm.setString(1, bebida.getNome());
        stm.setString(2, bebida.getTamanho());
        stm.setDouble(3, bebida.getPreco());
        stm.setInt(4, bebida.getCodigo());
        
        stm.executeUpdate();
    }
    
    public void Excluir (Bebida bebida) throws SQLException{
        
        String sql = "Delete from bebida where id_bebida =?";
        stm = con.prepareStatement(sql);
        stm.setInt(1,bebida.getCodigo());
        stm.executeUpdate();
    }
    
    public ArrayList<Bebida> ListaBebidas() throws SQLException{
       
        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
        
        String sql = "Select * From bebida";
        
        stm = con.prepareStatement(sql);
        rs = stm.executeQuery();
        
        while(rs.next()){
            bebidas.add(new Bebida(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDouble(4)));
        }
        return bebidas;
    }
}