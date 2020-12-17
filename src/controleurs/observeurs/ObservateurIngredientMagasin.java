/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.packageFenetre.FenetreJeu.ElementInterface.IngredientsView;
import metier.PackageCarte.PackageCase.Magasin;
import metier.PackageIngredient.EnumINGREDIENTS;

/**
 *
 * @author antho
 */
public class ObservateurIngredientMagasin extends Observateur {
    private IngredientsView vue;
    private Magasin magasin;
    private EnumINGREDIENTS ingredient;
    
    public ObservateurIngredientMagasin(IngredientsView vue,Magasin magasin,EnumINGREDIENTS ingredient) {
        this.vue = vue;
        this.magasin = magasin;
        this.ingredient = ingredient;
        
    }
    
    @Override
    public void avertir() {
        this.vue.majNumIngredient(this.magasin.getInventaire().getIngredient(ingredient).getNombre());
    }
}