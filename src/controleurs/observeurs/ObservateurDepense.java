/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.packageFenetre.FenetreJeu.FJeu;
import metier.PackageJeu.Jeu;
import metier.PackageJeu.Joueur;

/**
 *
 * @author antho
 */
public class ObservateurDepense extends Observateur{
    private Joueur joueur;
    private FJeu fjeu;
    
    public ObservateurDepense(FJeu fjeu) {
        super();
        this.fjeu = fjeu;
        this.joueur = Jeu.getInstance().getJoueur();
    }
    
    @Override
    public void avertir() {
        this.fjeu.SetDepense(this.joueur.getDepense());
    }
    
}
