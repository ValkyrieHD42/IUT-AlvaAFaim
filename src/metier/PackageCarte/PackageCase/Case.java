/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.PackageCarte.PackageCase;

import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.EnumROUTES;
import metier.PackageIngredient.EnumINGREDIENTS;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe d'une Case
 * @author Martin
 */
public abstract class Case {
    private Coordonnee coordonnee;
    private ArrayList<Case> voisins = new ArrayList<>();
    
    /**
     * Créer une case avec ses coordonnées
     * @param coordonnee 
     */
    public Case(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }
    
    public abstract int getPrix();
    /**
     * 
     * Permet d'obtenir le prix à partir d'une enum ingredient
     * @param ing
     * @return 
     */
    public abstract int getPrix(EnumINGREDIENTS ing);
    
    /**
     * Renvoie les coordonnées de la case
     * @return 
     */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }
    
    /**
     * Renvoie les voisins
     * @return 
     */
    public ArrayList<Case> getVoisins(){
        return voisins;
    }
    
    /**
     * Enleve un voisin
     * @return 
     */
    public void suprVoisin(Case c){
        this.voisins.remove(c);
    }
    
    public void clearVoisin() {
        this.voisins = new ArrayList<>();
    }
    
    /**
     * Ajoute un voisin à la case
     * @param voisin 
     */
    public void ajouterVoisin(Case voisin) {
        voisins.add(voisin);
    }
    
    public abstract String getType();
    
    public abstract EnumCASE getTypeEnum();
    
    @Override
    public boolean equals(Object o) {
       boolean res = true;
       
       if (!(o instanceof Case)) res = false;
       if(this.hashCode() != o.hashCode()) res = false;
       
       return res;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.getCoordonnee());
        return hash;
    }

    @Override
    public Case clone() {
        Case res = FabriqueCase.creer(new Coordonnee(this.getCoordonnee().getX(), this.getCoordonnee().getY()), this.getTypeEnum());
        
        for (Case v : this.getVoisins())
            res.ajouterVoisin(v);
        
        return res;
    }
}
