/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.controleurs;

import metier.PackageCarte.PackageCase.Magasin;
import metier.PackageIngredient.EnumINGREDIENTS;

/**
 *
 * @author antho
 */
public class ControleurVenteIngredient extends Controleur{
    private Magasin magasin;
    private EnumINGREDIENTS ingredient;
    
    public ControleurVenteIngredient(Magasin magasin, EnumINGREDIENTS ingredient) {
        super();
        this.ingredient = ingredient;
        this.magasin = magasin;
    }
    
    public void avertir() {
        this.magasin.rachatIngredient(this.ingredient);
        this.avertirObservateurs();
    }
    
}
