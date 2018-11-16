package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    
    private final String pwd;
    private List<String> ret ;
    
    public MailListReaderBD(String pwd){
        this.pwd=pwd;
        ret = new ArrayList<>();
    }
    
    public ArrayList<String> getMailList(){
        String sql = "SELECT * FROM EMAIL"; 
        try  {
            
            Connection conn = this.setConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                ret.add(rs.getString("MAIL"));
            }
            
        }catch(SQLException e){
            System.err.println(e.getErrorCode());
        }
        
        return (ArrayList<String>) ret;
    }
    
    private Connection setConnection(){
     String url = "jdbc:sqlite:" + this.pwd ;
     Connection conn = null;
     try{
         conn = DriverManager.getConnection(url);
     }catch(SQLException e){
         System.out.println(e.getSQLState());
     }
     return conn;
    }
    
    private void getAll(){

    }
}
