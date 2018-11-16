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
        System.out.println(db.getAll());
    }
    
}
