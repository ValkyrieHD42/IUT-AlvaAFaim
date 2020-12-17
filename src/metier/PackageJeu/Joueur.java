package metier.PackageJeu;

import metier.PackageRecette.Recette;
import metier.PackageIngredient.EnumINGREDIENTS;
import metier.PackageIngredient.Inventaire;
import metier.PackageAlgorithme.AlgorithmeParcours;
import metier.PackageAlgorithme.Dijkstra;
import metier.PackageCarte.PackageCase.Case;
import java.util.ArrayList;

/**
 * Represente le joueur
 */
public class Joueur {

    private Partie partie;
    private Inventaire inventaire;
    private Case caseJoueur;
    private int depense;

    public Case getCase() {
        return caseJoueur;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setCaseJoueur(Case caseJoueur) {
        this.caseJoueur = caseJoueur;
    }
    
    public int getDepense() {
            return this.depense;
    }

    public void setDepense(int depense) {
            this.depense = depense;
    }

    /**
     * Constuit le joueur
     */
    public Joueur(Case caseJoueur, Partie partie) {
        this.inventaire = new Inventaire();
        this.caseJoueur = caseJoueur;
        this.depense = 0;
        this.partie = partie;
    }

    /**
     * Permet de se deplacer sur la carte et retourne une liste de case parcourus + met la caseJoueur au batiment cible
     * @param batiment
     * @return ArrayList<Case>
     */
    public ArrayList<Case> seDeplacer(Case batiment) {
        ArrayList<Case> res = this.partie.getDijkstra().getChemin(this.getCase(), batiment);
        
        if (res.size() != 0) {
            this.depense += (res.size()-1) * 2;
            this.caseJoueur = res.get(res.size()-1);
        }
        
        return res;
    }
    
    /**
     * Permet de savoir si le joueur est ou non dans la maison
     */
    public boolean estDansMaison() {
            return (this.caseJoueur.getType() == "Maison");
    }

    /**
     * Permet de concoter une recette
     * @param recette
     */
    public boolean concocter(Recette recette) {
        boolean res = false;
            if (estDansMaison())
                if (this.inventaire.contient(recette.getInventaire()));
                        res = true;
        return res;
    }

    /**
     * Permet d'ajouter un ingredient a l'inventaire du joueur
     * @param ingredient
     */
    public void ajouterIngredient(EnumINGREDIENTS ingredient) {
            this.inventaire.ajouterIngredient(ingredient, 1);
    }

    /**
     * Permet de retirer un ingredient de l'inventaire du joueur
     * @param ingredient
     */
    public boolean retirerIngredient(EnumINGREDIENTS ingredient) {
            return this.inventaire.enleverIngredient(ingredient, 1);
    }

}