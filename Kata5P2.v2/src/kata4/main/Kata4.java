package kata4.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.*;
import kata4.view.*;

public class Kata4 {

    private MailListReader mlr;
    private String filename;
    private List<String> listaMail;
    private Histogram<String> hist;
    
    public Kata4(String filename){
        this.filename = filename;
    }
    
    public static void main(String[] args) throws IOException {
        Kata4 kata = new Kata4("C:\\Users\\Usuario\\Documents\\"
                + "NetBeansProjects\\Kata4\\src\\kata4\\email.txt");
        kata.input();
        kata.process();
        kata.output();
    }
    
    
    void input() throws IOException{       
        mlr = new MailListReader(filename);
        listaMail = mlr.getMailList();
    }
    
    void process(){
        hist = new MailHistogramBuilder().buildHist(listaMail);
    }
    
    void output(){
        HistogramDisplay histD = new HistogramDisplay("Histograma", hist,
        "Dominios", "Cantidad");
        
        histD.execute();
    }
    
}
