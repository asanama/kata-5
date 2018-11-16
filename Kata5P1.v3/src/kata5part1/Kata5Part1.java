/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Kata5Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Database db = new Database("Kata5.db");
        MailListReader mlr = new MailListReader("email.txt");
        List<String> list = mlr.read();
        db.insertData(list);
    
    }
    
}
