/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.controleurs;

import ihm.packageFenetre.FenetreJeu.JoueurView;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageJeu.Joueur;


/**
 *
 * @author antho
 */
public class ControleurDeplacementJoueur extends Controleur {
    private JoueurView joueur;
    
    
    public ControleurDeplacementJoueur(JoueurView joueur) {
        super();
        this.joueur = joueur;
    }
    
    public void avertir(Case caseLogic) {
        if(!this.joueur.isEnMouvement()) {
            this.joueur.getJoueur().seDeplacer(caseLogic);
            this.avertirObservateurs();
        }
    }
}
