package metier.PackageJeu;

import metier.PackageRecette.Recette;
import metier.PackageRecette.Recettes;
import metier.PackageCarte.FabriqueCarte;
import metier.PackageCarte.Carte;
import metier.PackageAlgorithme.AlgorithmeParcours;
import metier.PackageAlgorithme.Dijkstra;
import metier.PackageCarte.PackageCase.Case;
import java.util.ArrayList;

/**
 * Represente une partie
 */
public class Partie {
    
    private Dijkstra dijkstra;
    private Carte carte;
    private Joueur joueur;
    
    /**
     * Construit la partie
     */
    public Partie(int seed) {
        //this.carte = FabriqueCarte.CreerCarte("dur");
        this.carte = FabriqueCarte.CreerCarte("procedural",seed);
        
        this.joueur = new Joueur(this.carte.getMaison(),this);
        this.dijkstra = new Dijkstra(this);
    }
    
    public Dijkstra getDijkstra() {
        return dijkstra;
    }

    public ArrayList<Case> getBatimentsAccessible() {
        AlgorithmeParcours algo = new AlgorithmeParcours(this);
        return algo.getBatimentsAccessible(this.joueur.getCase());
    }
    
    /**
     * Provoque la fin de la partie
     */
    public void finDePartie() {
            // TODO - implement Partie.finDePartie
            throw new UnsupportedOperationException();
    }

    /**
     * Permet de concocter une recette
     * @param recette
     */
    public void concocter(Recette recette) {
            if (this.joueur.concocter(recette))
                finDePartie();
    }

    public Carte getCarte() {
        return this.carte;
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

}