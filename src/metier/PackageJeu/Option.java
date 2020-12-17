package metier.PackageJeu;

/**
 * Classe singleton stock des options du jeu 
 * @author antho
 */
public class Option {
    
    private static Option instance = null;
    
    private int volume = 0;
    private int difficulté = 1;
    
    private Option() {
    }
    
    /**
     * retourne la classe Option
     * @return 
     */
    public static Option getInstance() {
        if (instance == null) instance = new Option();
        
        return instance;
    }
    
}