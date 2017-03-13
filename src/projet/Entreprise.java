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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isadora Bartkowiak, Marie Roca
 * @version 1.0
 */
public class Entreprise {
    private HashMap<String, Competences> competences;
    private HashMap<Integer, Personnel> personnel;
    
    
    public Entreprise(){
        competences = new HashMap<String, Competences>();
        personnel = new HashMap<Integer, Personnel>();
    }
    
    public Entreprise(HashMap<String, Competences> competences, HashMap<Integer, Personnel> personnel){
        this.competences = competences;
        this.personnel = personnel;
    }

    /**
     * Renvoie la map des compétences
     * 
     * @return Une HashMap(String,Competences) des compétences présentes dans l'entreprise
     */
    public HashMap<String, Competences> getCompetences() {
        return competences;
    }

    /**
     * Renvoie la map du personnel
     * 
     * @return Une HashMap(Integer,Personnel) du personnel present dans l'entreprise
     */
    public HashMap<Integer, Personnel> getPersonnel() {
        return personnel;
    }
    
    /**
     * Renvoie une chaine de caractère représentant la liste du personnel
     * 
     * @return une chaine de caractère représentant la liste du personnel de l'entreprise
     */
    public void personnelToString(){
        for (Integer mapKey : personnel.keySet()) {
            // utilise ici hashMap.get(mapKey) pour accéder aux valeurs
            System.out.println(mapKey + "-" + personnel.get(mapKey));
        }
    }
    
        /**
     * Renvoie une chaine de caractère représentant la liste des compétences
     * 
     * @return une chaine de caractère représentant la liste des compétences de l'entreprise
     */
    public void competencesToString(){
        for (String mapKey : competences.keySet()) {
            // utilise ici hashMap.get(mapKey) pour accéder aux valeurs
            System.out.println(mapKey + "-" + competences.get(mapKey));
        }
    }
    
    /**
     * Importe du personnel contenu dans un classeur excel (format .csv) dans les données de l'entreprise
     * @param chemin
     *          Le chemin du fichier à lire (.csv) contenu dans les sources du projet
     * @throws IOException
     * @throws ParseException 
     */
    //public void importerPersonnel(File fichierPersonnel) throws IOException{
    public void importerPersonnel(String chemin) throws IOException, ParseException{
        //CSVReader reader = new CSVReader(new FileReader(fichierPersonnel));
        CSVReader reader = new CSVReader(new FileReader(chemin));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null){
            String[] tab = new String[3];
            tab = nextLine[0].split(";");
            //System.out.println(nextLine[0]);
            Personnel p = new Personnel(tab[1],tab[0],tab[2]);
            personnel.put(Integer.parseInt(tab[3]), p);
            //System.out.println(tab[3] + " - " + p.toString());
        }
        reader.close();
    }
    
    
    /**
     * Importe des compétences contenue dans un classeur excel (format .csv) dans les données de l'entreprise
     * @param chemin
     *          Le chemin du fichier à lire (.csv) contenu dans les sources du projet
     * @throws IOException
     * @throws ParseException 
     */
    //liste_competences.csv
    //public void importerCompetences(File fichierPersonnel) throws IOException{
    public void importerCompetences(String chemin) throws IOException, ParseException{
        //CSVReader reader = new CSVReader(new FileReader(fichierPersonnel));
        CSVReader reader = new CSVReader(new FileReader(chemin));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null){
            String[] tab = new String[3];
            tab = nextLine[0].split(";");
            //System.out.println(nextLine[0]);
            Competences c = new Competences(tab[1],tab[2]);
            competences.put(tab[0], c);
            //System.out.println(tab[3] + " - " + p.toString());
        }
        reader.close();
    }
    
    /**
     * Ajoute une personne à la liste du personnel de l'entreprise
     * @param code
     *          Identifiant de la personne
     * @param nom
     *          Nom de la personne
     * @param prenom
     *          Prénom de la personne
     * @param dateEntree 
     *          Date d'entrée dans l'entreprise de la personne
     */
    public void addPersonnel(int code, String nom, String prenom, String dateEntree){
        Personnel p = new Personnel(nom, prenom, dateEntree);
        personnel.put(code, p);
    }
    
    /**
     * Ajoute une compétence à la liste des compétences de l'entreprise
     * @param code
     *          Identifiant de la compétence
     * @param nom
     *          Nom de la compétence
     * @param description 
     *          Description de la compétences
     */
    public void addCompetence(String code, String nom, String description){
        Competences c = new Competences(nom, description);
        competences.put(code, c);
    }
    
    public static void main(String args[]){
        Entreprise e = new Entreprise();
        try {
            e.importerCompetences("src/liste_competences.csv");
        } catch (IOException ex) {
            Logger.getLogger(Entreprise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Entreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.competencesToString();
        
        
    }
}
    

