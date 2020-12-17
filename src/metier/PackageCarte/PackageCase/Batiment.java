package metier.PackageCarte.PackageCase;

import java.util.ArrayList;
import metier.PackageIngredient.EnumINGREDIENTS;
import metier.PackageIngredient.Ingredients;
import metier.PackageIngredient.Inventaire;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.EnumBATIMENTS;
import metier.PackageJeu.Jeu;
import metier.PackageJeu.Joueur;
import java.util.HashMap;
import java.util.Objects;

/**
 * Case de batiment abstrait
 */
public abstract class Batiment extends Case{

    private Inventaire inventaire;
    private HashMap<EnumINGREDIENTS, Integer> prix;
    private Inventaire inventaireInit = new Inventaire();
    private boolean estAccessible;
    private EnumBATIMENTS sens;
    /**
     * Construit le batiment
     * @param coor
     */
    public Batiment(Coordonnee coor) {
        super(coor);
        this.inventaire = new Inventaire();
    }

    public boolean estAccessible() {
        return estAccessible;
    }
    
        
    public EnumBATIMENTS getSens() {
        return sens;
    }

    public void setSens(EnumBATIMENTS sens) {
        this.sens = sens;
    }

    public void setAccessible(boolean estAccessible) {
        this.estAccessible = estAccessible;
    }
    
    /**
     * rachat d'un ingredient par le batiment (false si non possible)
     * @param ingredient
     */
    public boolean rachatIngredient(EnumINGREDIENTS ingredient) {
        boolean res = false;
        
        for(Ingredients iInit : this.inventaireInit.getIngredients())
        {
            for(Ingredients iChanger : this.inventaire.getIngredients())
            {
                if(iInit.getNom() == ingredient && iInit.getNom() == iChanger.getNom() && iInit.getNombre() > iChanger.getNombre())
                {
                    Joueur j = Jeu.getInstance().getJoueur();
                    j.setDepense(j.getDepense()-prix.get(ingredient));
                    j.retirerIngredient(ingredient);
                    this.inventaire.ajouterIngredient(ingredient, 1);
                    res = true;
                }
            }
        }
        return res;
    }

    /**
     * vente d'un ingredient par le batiment (false si non possible)
     * @param ingredient
     */
    public boolean venteIngredient(EnumINGREDIENTS ingredient) {
        boolean res = this.inventaire.enleverIngredient(ingredient, 1);  
        
        if (res)
        {
            Joueur j = Jeu.getInstance().getJoueur();
            j.setDepense(j.getDepense()+prix.get(ingredient));
            j.ajouterIngredient(ingredient);
        }
        return res;
    }

    /**
     * 
     */
    public Inventaire getInventaire() {
        return this.inventaire;
    }
    
    @Override
    public int getPrix(EnumINGREDIENTS ing){
        return this.prix.get(ing);
    }
    
    public void initInventaire(Inventaire invInit, HashMap<EnumINGREDIENTS, Integer> Ing) {
        this.inventaireInit = invInit.clone();
        this.inventaire = invInit;
        this.prix = Ing;
    }

    /**
     * renvoie le type du batiment
     */
    public abstract String getType();
    
    @Override
    public boolean equals(Object o) {
       boolean res = true;
       
       if (!(o instanceof Batiment)) res = false;
       if(this.hashCode() != o.hashCode()) res = false;
       
       return res;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.getCoordonnee());
        return hash;
    }
}