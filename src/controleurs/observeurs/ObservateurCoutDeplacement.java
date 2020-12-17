/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.packageFenetre.FenetreJeu.Tile;
import java.util.ArrayList;

/**
 *
 * @author antho
 */
public class ObservateurCoutDeplacement extends Observateur{
    private ArrayList<Tile> tiles;

    public ObservateurCoutDeplacement(ArrayList<Tile> tiles) {
        super();
        this.tiles = tiles;
    }

    @Override
    public void avertir() {
        for(Tile t : this.tiles)
            if(t.getCaseLogic().getType() == "Magasin")
                t.getPopupView().displayCoutDeplacer();
    }
    
}
