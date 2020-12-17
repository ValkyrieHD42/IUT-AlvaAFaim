/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.controleurs;

import ihm.packageFenetre.FenetreJeu.FJeu;
import ihm.packageFenetre.FenetreJeu.Tile;

/**
 *
 * @author antho
 */
public class ControleurInteractionTile extends Controleur{
    private Tile tile;
    private FJeu fjeu;

    public ControleurInteractionTile(Tile tile,FJeu fjeu) {
        super();
        this.tile = tile;
        this.fjeu = fjeu;
        
    }
    
    public void avertir() {
        
        this.avertirObservateurs();
    }
}
