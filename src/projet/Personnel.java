/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marieroca
 */
public class Personnel {
    private String nom, prenom;
    private Date dateEntree;
    
    public Personnel(String nom, String prenom, String dateEntree){
        this.nom = nom;
        this.prenom = prenom;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateEntree = (Date) formatter.parse(dateEntree);
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
    }
    
    @Override
    public String toString(){
        return nom + "," + prenom + "," + dateEntree;
    }
    
}
