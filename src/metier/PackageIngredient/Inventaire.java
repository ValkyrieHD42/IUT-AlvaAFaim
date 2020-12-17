package metier.PackageIngredient;

import java.util.*;

/**
 * Represente un inventaire
 */
public class Inventaire {

    private ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();

    public Inventaire(Inventaire invInit) {
        this.ingredients = invInit.ingredients;
    }
    
    public Inventaire() {}

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    /**
     * Permet d'ajouter un ingredient a l'inventaire
     * @param nom
     * @param nombre
     */
    public void ajouterIngredient(EnumINGREDIENTS nom, int nombre) {
        Boolean ElementPresent = false;
        for (Ingredients i : ingredients)
            if(nom == i.getNom())
            {
                i.setNombre(i.getNombre()+ nombre);
                ElementPresent = true;
            }
        
        if(!ElementPresent) this.ingredients.add(new Ingredients(nom,nombre));
    }

    /**
     * Permet de comparer 2 inventaires (savoir si l'un "possede" l'autre)
     * @param inventaire
     */
    public boolean contient(Inventaire inventaire) {
        Boolean ElementPresent = false;
        int count = 0;
            for(Ingredients i1 : inventaire.ingredients) {
                for(Ingredients i2 : this.ingredients) 
                    if (i1.getNom() == i2.getNom() && i1.getNombre() <= i2.getNombre()) {
                                count += 1;
                                ElementPresent = true;
                    }
                
                if(!ElementPresent && i1.getNombre() == 0) count += 1;
                ElementPresent = false;
            }
            
        return inventaire.ingredients.size() == count;
    }

    /**
     * Permet d'enlever un ingredient a l'inventaire
     * @param nom
     * @param nombre
     */
    public boolean enleverIngredient(EnumINGREDIENTS nom, int nombre) {
        boolean res = false;
        for(Ingredients i1 : this.ingredients)
            if(i1.getNom() == nom && i1.getNombre()>= nombre)
                {
                i1.setNombre( i1.getNombre() - nombre);
                res = true;
                }
            return res;
    }

    public Ingredients getIngredient(EnumINGREDIENTS ingredient) {
        Ingredients res = null;
        for(int i = 0 ; i < this.ingredients.size() ; i++) {
            if (ingredient == this.ingredients.get(i).getNom())
                res = this.ingredients.get(i);
        }
        return res;
    }
    
    
    @Override
    public Inventaire clone() {
        Inventaire res = new Inventaire();
        
        for (Ingredients i : this.ingredients)
            res.ajouterIngredient(i.getNom(), i.getNombre());
        
        return res;
    }
}