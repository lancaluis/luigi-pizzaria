package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DbConnection {
    
    // Connection settings
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:8080/luigipizza";
    private String user = "root";
    private String password = "123Aa321";
    
    // Connection DB
    public Connection getConnection() throws SQLException {
        Connection con = null;

        try {
       Class.forName(driver);
           con = DriverManager.getConnection(url, user, password);
        } 
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Problemas na conexão com a fonte de dados! "+e,"Banco da dados", JOptionPane.ERROR_MESSAGE);
        }
	return con;
    }

    public void fecharConexao(Connection con, Statement stmt, ResultSet rs){
        
        try{
            if (stmt != null){
                stmt.close();
            }
        }
        catch (SQLException e){
            
        }
        
        try{
            if (rs != null){
                rs.close();
            }
        }
        catch (SQLException e){
        }
               
        
        try {
            con.close();
        } catch (SQLException e) {
        }
        System.out.println("DbConnection fechada!");
    }
    
}
