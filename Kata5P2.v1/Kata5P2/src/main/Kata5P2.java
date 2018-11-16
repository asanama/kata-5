package main;

import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;
import model.Histogram;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kata5P2 {

    private MailListReader mlr;
    private String filename;
    private List<String> listaMail;
    private Histogram<String> hist;
    
    public Kata5P2(String filename){
        this.filename = filename;
    }
    
    public static void main(String[] args) throws IOException {
        Kata5P2 kata = new Kata5P2("email.txt");
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
