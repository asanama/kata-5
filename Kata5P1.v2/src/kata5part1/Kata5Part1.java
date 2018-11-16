/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5part1;

/**
 *
 * @author Usuario
 */
public class Kata5Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database db = new Database("Kata5.db");
        db.createTable("CREATE TABLE IF NOT EXISTS EMAIL(\n"
                + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n MAIL TEXT NOT NULL );");
    }
    
}
