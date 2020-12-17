package metier.PackageCarte;

import metier.PackageAlgorithme.AlgorithmeDur;
import metier.PackageAlgorithme.AlgorithmeGenMap;
import metier.PackageAlgorithme.AlgorithmeProcedural;
import metier.PackageJeu.Jeu;

/**
 * Fabrique de cartes
 */
public class FabriqueCarte {

    private static AlgorithmeGenMap algo;
    /**
     * Creer une carte, un niveau
     * @param difficulte
     */
    public static Carte CreerCarte(String typeAlgo,int seed) {
        Carte res = null;
        
        switch(typeAlgo){
            case "dur":
                algo = new AlgorithmeDur();
                break;
            case "procedural": 
                algo = new AlgorithmeProcedural();
                break;
        }
        
        res = new Carte(algo.calcul(seed),algo.getNbColonne(),algo.getNbLigne());
        return res;
    }
}