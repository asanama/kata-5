/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Database {
    
    private String filename;
    
    public Database(String filename){
        this.filename = filename;
    }
    
    private Connection setConnection(){
        String url = "jdbc:sqlite:" + filename ;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getSQLState());
        }
        return conn;
    }
    
    public String getAll(){
        String str = "";
        String sql = "SELECT * FROM PEOPLE";
        
        try  {
            
            Connection conn = this.setConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                str +=  rs.getInt("ID") + " "+ rs.getString("NAME") + " " +
                        rs.getString("APELLIDOS") + " " + 
                        rs.getString("DEPARTAMENTO") + "\n";
            }
            
            
        }catch(SQLException e){
            System.err.println("No se puede conectar a la base de datos");
        }
        
        
        
        return str;
    }
    
}
