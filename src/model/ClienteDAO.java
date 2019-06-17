package model;

import dao.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection con = null;
    private PreparedStatement stm;
    private ResultSet rs;
    private DbConnection dao;
    
    public ClienteDAO(){
        dao = new DbConnection();
        try{
            con = dao.getConnection();
        }
        
        catch(SQLException e){
            
        }
    }
    
    public int Inserir (Cliente cliente) throws SQLException{
        
        String sql = " Insert into cliente (nome,telefone,endereco) values (?,?,?)";
        
        stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getTelefone());
        stm.setString(3, cliente.getEndereco());
        
        stm.executeUpdate();
        
        rs = stm.getGeneratedKeys();
        
        if(rs.next()){
            cliente.setCodigo(rs.getInt(1));
        }
        
        return cliente.getCodigo();
    }
    
    public void Alterar (Cliente cliente) throws SQLException{
        String sql = "Update cliente set nome=?, telefone=?, endereco=? where id_cliente=?";
        
        stm = con.prepareStatement(sql);
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getTelefone());
        stm.setString(3, cliente.getEndereco());
        stm.setInt(4, cliente.getCodigo());
        
        stm.executeUpdate();
    }
    
    public void Excluir (Cliente cliente) throws SQLException{
        
        String sql = "Delete from cliente where id_cliente =?";
        stm = con.prepareStatement(sql);
        stm.setInt(1,cliente.getCodigo());
        stm.executeUpdate();
    }
    
    public Cliente localizarcliente(String cliente) throws SQLException{
        
        String sql = "Select * from cliente where nome = ? ";
        
        stm = con.prepareStatement(sql);
        stm.setString(1,cliente);
        rs = stm.executeQuery();
        
        Cliente prod = new Cliente(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4));
                         
        
        return prod;
    }
    
    public ArrayList<Cliente> ListaClientes() throws SQLException{
       
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        String sql = "Select * From cliente";
        
        stm = con.prepareStatement(sql);
        rs = stm.executeQuery();
        
        while(rs.next()){
            clientes.add(new Cliente(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)));
        }
        return clientes;
    }
}