/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreJeu;

import ihm.EnumSPRITE;
import ihm.ManagerSprite;
import metier.PackageCarte.Coordonnee;
import metier.PackageJeu.Joueur;
import javafx.scene.image.ImageView;
import metier.PackageJeu.Jeu;

/**
 *
 * @author antho
 */
public class JoueurView extends ElementMap{
    private Coordonnee coorIHM;
    private Joueur joueur;
    private FJeu fjeu;
    private boolean enMouvement;
    
    public JoueurView(FJeu fJeu) {
        super(fJeu);
        this.fjeu = fJeu;
        this.enMouvement = false;
        this.joueur = Jeu.getInstance().getJoueur();
        this.coorIHM = this.joueur.getCase().getCoordonnee();
    }

    public Joueur getJoueur() {
        return joueur;
    }
    
    @Override
    public void displayImage() {
        this.caseImg.setImage(ManagerSprite.get(EnumSPRITE.alva));
        this.fjeu.getMap().getChildren().add(this.fjeu.getMap().getChildren().size()-2,this.caseImg);
        this.caseImg.setX(this.coorIHM.getX());
        this.caseImg.setY(this.coorIHM.getY());
        this.fjeu.placeNode(this.caseImg,this.joueur.getCase());
    }

    public Coordonnee getCoorIHM() {
        return coorIHM;
    }

    public ImageView getCaseImg() {
        return caseImg;
    }

    public void setCoorIHM(Coordonnee coordonnee) {
        this.coorIHM = coordonnee;
    }

    public boolean isEnMouvement() {
        return enMouvement;
    }

    public void setEnMouvement(boolean enMouvement) {
        this.enMouvement = enMouvement;
    }
    
}