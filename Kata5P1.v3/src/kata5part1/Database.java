/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
    
    public void createTable(String sql){
        
        try  {
            
            Connection conn = this.setConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            System.err.println("Fallo al crear la tabla");
        }
    }
    
    public void insertData(List<String> mail){
        try  {
            Connection conn = this.setConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMAIL"
                    + "(MAIL) VALUES(?)");
            for(String s : mail){
                pstmt.setString(1,s);
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            System.err.println("Fallo al insertar");
        }
    }
    
}
