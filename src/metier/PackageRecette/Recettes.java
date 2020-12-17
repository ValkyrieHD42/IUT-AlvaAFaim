package metier.PackageRecette;

import java.util.*;

/**
 * Represente un gestionnaire de recettes
 */
public class Recettes {

	private ArrayList<Recette> recettes = new ArrayList<Recette>();
        private ArrayList<Recette> recettesPartie = new ArrayList<Recette>();
        private static Recettes instance;
        
	private Recettes() {
            EnumRECETTES[] tabEnum = EnumRECETTES.values();
            for(EnumRECETTES enumR : tabEnum)
                CreerRecette(enumR);  
	}

        public static Recettes get() {
            if (instance == null) instance = new Recettes();
            return instance;
        }
        
	public ArrayList<Recette> listRecettes() {
            return this.recettes;
	}

	public ArrayList<Recette> listRecettesPartie() {
            return this.recettesPartie;
	}
        
        public void ResetRecettePartie() {
            this.recettesPartie = new ArrayList<Recette>();
        }

	/**
	 * Permet d'ajouter une recette à la liste des recettes de la partie à partir de la liste recette
	 * @param recette
	 */
	public void ajouterRecette(EnumRECETTES recette) {
            for(Recette r :recettes)
                if(r.getNom() == recette)
                    recettesPartie.add(r);
                    
	}

	/**
	 * Creer une recette 
	 * @param nom
	 */
	public void CreerRecette(EnumRECETTES nom) {
           recettes.add(FabriqueRecette.CreerRecette(nom));
	}

}