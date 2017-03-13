/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marieroca
 */
public class Personnel {
    private String nom, prenom;
    private Date dateEntree;
    private HashMap<String, Competences> competences;
    final static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public Personnel(String nom, String prenom, String dateEntree){
        this.nom = nom;
        this.prenom = prenom;
        try {
            this.dateEntree = (Date) format.parse(dateEntree);
        } catch (ParseException ex) {
            Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*//Si on veut prendre en compte différents formats de dates
        String s = "";
        if (dateEntree.contains("/"))
        s = "/";
        if (dateEntree.contains("-"))
        s = "-";
        if (dateEntree.contains("."))
        s = ".";
        String date[] = dateEntree.split(s);*/
        competences = new HashMap<String, Competences>();
    }
    
    @Override
    public String toString(){
        String tabC = "";
        for(String mapKey : competences.keySet()){
            tabC += mapKey + ", ";
        }
        String date = format.format(dateEntree);
        return nom + "," + prenom + "," + date + "\n" + tabC + "\n";
    }
    
    public void addCompetences(String clef, Competences c){
        competences.put(clef, c);
    }
    
    public HashMap<String, Competences> getCompetences(){
        return competences;
    }
    
}
