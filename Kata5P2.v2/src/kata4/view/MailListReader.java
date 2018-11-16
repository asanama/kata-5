package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
    private final String pwd;
    
    public MailListReader(String pwd){
        this.pwd=pwd;
    }
    
    public ArrayList<String> getMailList() throws FileNotFoundException, IOException{
        
        List<String> ret = new ArrayList<>();
        File f = new File(pwd);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String mail;
            
            while ( (mail = br.readLine()) != null){
                ret.add(mail);
            }
        }
        
        return (ArrayList<String>) ret;
    }
    
    
}
