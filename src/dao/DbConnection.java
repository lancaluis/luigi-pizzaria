package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println(e.getMessage());   
	}
	return con;
    }
    
}
