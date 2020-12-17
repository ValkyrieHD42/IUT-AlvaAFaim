package metier.PackageRecette;

import metier.PackageIngredient.Inventaire;
import java.util.ArrayList;

/**
 * Represente une recette
 */
public class Recette {

    private Inventaire inventaire;
    private boolean estPret;
    private EnumRECETTES nom;
    
    public Recette(EnumRECETTES nom, Inventaire inventaire) {
        this.nom = nom;
        this.inventaire = inventaire;
    }
    
    public Inventaire getInventaire() {
        return inventaire;
    }

    public EnumRECETTES getNom() {
        return nom;
    }
    
    public boolean isEstPret() {
        return this.estPret;
    }

    public void setEstPret(boolean estPret) {
        this.estPret = estPret;
    }

    
    /**
    * Converti le nom de l'enum en toString correct a afficher
    * 
    */
    public String toString() {
        char[] actual = this.nom.toString().toCharArray();
        char[] res = null;
        
        for(char c : actual) {
            for (int i = 0 ; i<actual.length ; i++) {
                String space = " "; 
                if (String.valueOf(c).equals("_")) {
                    char[] spaceChar = space.toCharArray();
                    res[i] = spaceChar[0];
                }
                else res[i] = c;
            }
        }
        return res.toString();
    }
}