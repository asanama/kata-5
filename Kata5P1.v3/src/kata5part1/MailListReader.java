/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MailListReader {
        private final String pwd;
    
    public MailListReader(String pwd){
        this.pwd=pwd;
    }
    
    public ArrayList<String> read() throws FileNotFoundException, IOException{
        
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
