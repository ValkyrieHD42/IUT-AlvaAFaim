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
public class ControleurAchatIngredient extends Controleur {
        
    private Magasin magasin;
    private EnumINGREDIENTS ingredient;
    
    public ControleurAchatIngredient(Magasin magasin,EnumINGREDIENTS ingredient) {
        super();
        this.magasin = magasin;
        this.ingredient = ingredient;
    }
    
    public void avertir() {
        this.magasin.venteIngredient(this.ingredient);
        this.avertirObservateurs();
    }
    
}
