/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Competences est la classe représentant une compétence de l'entreprise
 * @author Isadora Bartkowiak, Marie Roca
 * @version 1.0
 */
public class Competences {

    /**
     * @param args the command line arguments
     */
    private String nom, description;
    
    public Competences(String nom, String description){
        this.nom = nom;
        this.description = description;
    }

    
    public String getNom(){
        return nom;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
        return nom + ": " + description;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
