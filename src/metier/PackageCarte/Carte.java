package metier.PackageCarte;

import metier.PackageCarte.PackageCase.Case;
import java.util.*;

/**
 * Represente la carte
 */
public class Carte {

    private HashMap<Coordonnee, Case> cases;
    private int nbColonne;
    private int nbLigne;

    public int getNbColonne() {
        return nbColonne;
    }
    
    public int getNbLigne() {
        return nbLigne;
    }
    
    /**
     * Construit la carte
     */
    public Carte(HashMap<Coordonnee, Case> cases, int nbColonne,  int nbLigne) {
        this.cases = cases;
        this.nbColonne = nbColonne;
        this.nbLigne = nbLigne;
        
    }
    
    /**
     * retourne la case correspondant a la maison de la partie
     * @return Case
     */
    public Case getMaison() {
        Case res = null;
        
        for(Case c : cases.values())
            if (c.getType() == "Maison") res = c;
        
        return res;
    }
    
    /**
     * entièreté des cases de la carte
     * @return 
     */
    public HashMap<Coordonnee, Case> getCases() {
        return this.cases;
    }
}