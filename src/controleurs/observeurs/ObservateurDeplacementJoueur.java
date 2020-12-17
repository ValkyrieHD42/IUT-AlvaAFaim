/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.observeurs;

import ihm.EnumSPRITE;
import ihm.ManagerSprite;
import ihm.packageFenetre.FenetreJeu.FJeu;
import ihm.packageFenetre.FenetreJeu.JoueurView;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageJeu.Jeu;

/**
 *
 * @author antho
 */
public class ObservateurDeplacementJoueur extends Observateur{
    private FJeu fjeu;
    private JoueurView vue;
    private Case depart;
    private Coordonnee lastCoord;
    private boolean enMouvement = false;
    
    public ObservateurDeplacementJoueur(JoueurView vue, FJeu fjeu) {
        super();
        this.fjeu = fjeu;
        this.vue = vue;
        this.depart = Jeu.getInstance().getJoueur().getCase().clone();
        this.lastCoord = depart.getCoordonnee();
    }
    
    private Timeline moveElementTo(Coordonnee coor) {
        Coordonnee distance = new Coordonnee(coor.getX() - this.vue.getCoorIHM().getX(),coor.getY() - this.vue.getCoorIHM().getY());
        Timeline timeline = new Timeline();
        
        int moveX = -74*distance.getY() + 74*distance.getX();
        int moveY = 38*distance.getY() + 38*distance.getX();
        
        KeyFrame move = new KeyFrame(Duration.seconds(0.5),
                new KeyValue(this.vue.getCaseImg().xProperty(), moveX),
                new KeyValue(this.vue.getCaseImg().yProperty(), moveY));
        
        KeyFrame changeSprite = null;
        
        if((coor.getX()-this.lastCoord.getX() > 0) && (coor.getY()-this.lastCoord.getY() == 0)) {
            changeSprite = new KeyFrame(Duration.millis(1), e -> this.vue.getCaseImg().setImage(ManagerSprite.get(EnumSPRITE.alva_bas_droite)));
        } else if((coor.getX()-this.lastCoord.getX() == 0) && (coor.getY()-this.lastCoord.getY() > 0)) {
            changeSprite = new KeyFrame(Duration.millis(1), e -> this.vue.getCaseImg().setImage(ManagerSprite.get(EnumSPRITE.alva_bas_gauche)));
        } else if((coor.getX()-this.lastCoord.getX() < 0) && (coor.getY()-this.lastCoord.getY() == 0)) {
            changeSprite = new KeyFrame(Duration.millis(1), e -> this.vue.getCaseImg().setImage(ManagerSprite.get(EnumSPRITE.alva_haut_gauche)));
        } else if((coor.getX()-this.lastCoord.getX() == 0) && (coor.getY()-this.lastCoord.getY() < 0)) {
            changeSprite = new KeyFrame(Duration.millis(1), e -> this.vue.getCaseImg().setImage(ManagerSprite.get(EnumSPRITE.alva_haut_droite)));
        }
        
        timeline.getKeyFrames().addAll(changeSprite,move);
        this.lastCoord = coor;
        return timeline;
    }
    
    @Override
    public void avertir() {
        this.fjeu.FermerToutesPopup();
        
        SequentialTransition sequence = new SequentialTransition();
        Case arrivee = Jeu.getInstance().getJoueur().getCase();
        
        ArrayList<Case> mouvements = Jeu.getInstance().getPartie().getDijkstra().getChemin(this.depart,arrivee);
        for(Case c : mouvements) {
            sequence.getChildren().add(moveElementTo(c.getCoordonnee()));
        }
        
        this.depart = arrivee;
        
        sequence.play();
        vue.setEnMouvement(true);
        sequence.setOnFinished(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    vue.setEnMouvement(false);
                }
            }
        );
    }
    
}
