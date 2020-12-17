package metier.PackageJeu;

/**
 * Represente le jeu
 */
public class Jeu {

    private Partie partie;
    private int difficulte = 0;
    private static Jeu instance;

    private Jeu() {
    }

    public static Jeu getInstance() {
        if (instance == null)
            instance = new Jeu();
        return instance;
    }

    /**
     * Permet de creer une partie
     */
    public void NouvellePartie(String seedString) {
        int seed = 0;
        
        try
        {
            seed = Integer.valueOf(seedString);
        } catch (Exception e)
        {
            if (seedString.length() > 0) 
                for (int i = 0 ; i < seedString.length() ; i++)
                {
                    char c = seedString.charAt(i);
                    seed += Character.getNumericValue(c);
                }
        }
        
        this.partie = new Partie(seed);
    }

    /**
     * Permet de charger une partie existante
     */
    public void ChargerPartie() {
            // TODO - implement Jeu.ChargerPartie
            throw new UnsupportedOperationException();
    }

    public Partie getPartie() {
        return this.partie;
    }

    public Joueur getJoueur() {
        return this.partie.getJoueur();
    }

    /**
     * Permet de changer les options du jeu
     */
    public void Options() {
            // TODO - implement Jeu.Options
            throw new UnsupportedOperationException();
    }

}