/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.packageFenetre.FenetreJeu.ElementInterface.IngredientsView;
import ihm.packageFenetre.FenetreJeu.FJeu;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import metier.PackageIngredient.Ingredients;
import metier.PackageJeu.Jeu;
import metier.PackageJeu.Joueur;

/**
 *
 * @author antho
 */
public class ObservateurRecette extends Observateur{
    private ArrayList<IngredientsView> listVue = new ArrayList<>();
    private final Joueur joueur;
    
    public ObservateurRecette(FJeu fjeu) {
        super();
        this.listVue = fjeu.getIngredientsViewRecette();
        this.joueur = Jeu.getInstance().getJoueur();
    }

    
    
    @Override
    public void avertir() {
        for (IngredientsView vue : this.listVue) {
            vue.majColor(Color.WHITE);
            if (joueur.getInventaire().getIngredient(vue.getIngredientsLogic().getNom()) != null) {
                if (joueur.getInventaire().getIngredient(vue.getIngredientsLogic().getNom()).getNombre() >= vue.getIngredientsLogic().getNombre())
                    vue.majColor(Color.GREENYELLOW);
            }
        }
    }
    
}
