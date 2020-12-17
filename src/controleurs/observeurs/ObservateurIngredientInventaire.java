/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.packageFenetre.FenetreJeu.FJeu;
import javafx.scene.layout.Pane;

/**
 *
 * @author antho
 */
public class ObservateurIngredientInventaire extends Observateur{
    private FJeu fjeu;
    
    public ObservateurIngredientInventaire(FJeu fjeu) {
        super();
        this.fjeu = fjeu;
    }

    
    @Override
    public void avertir() {
        fjeu.displayInvContent();
    }
    
}
