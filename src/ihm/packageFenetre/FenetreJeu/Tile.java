/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreJeu;

import controleurs.controleurs.ControleurDeplacementJoueur;
import ihm.EnumHERBE;
import ihm.EnumSPRITE;
import ihm.ManagerSprite;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Batiment;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageCarte.PackageCase.Route;
import metier.PackageJeu.Jeu;
import metier.PackageJeu.Partie;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Translate;
import metier.PackageAlgorithme.generator.GenerateurAleatoire;

/**
 *
 * @author Martin
 */
public class Tile extends ElementMap {
    private Case caseLogic;
    private boolean estAccessible = false;
    private MagasinPopView popupView;
    
    private ControleurDeplacementJoueur controleurDeplacementJoueur;
    
    public Tile(Partie partie, FJeu fjeu, Coordonnee initCoor) {
        super(fjeu);
        this.caseLogic = partie.getCarte().getCases().get(initCoor);
        placeTile();
        this.fenetreMap.getMap().getChildren().add(caseImg);
    
        // Controleur
        controleurDeplacementJoueur = fjeu.getControleurDeplacementJoueur();
        
        // Handler
        this.caseImg.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> interactTile());
    }
    
    public Case getCaseLogic() {
        return caseLogic;
    }

    public void setPopupView(MagasinPopView popupView) {
        this.popupView = popupView;
    }
    
    public boolean isEstAccessible() {
        return estAccessible;
    }

    public void setEstAccessible(boolean estAccessible) {
        this.estAccessible = estAccessible;
    }
    
    private void placeTile() {
        Translate transX = new Translate();
        Translate transY = new Translate();

        transX.setX(74*caseLogic.getCoordonnee().getX());
        transX.setY(38*caseLogic.getCoordonnee().getX());

        transY.setX(-74*caseLogic.getCoordonnee().getY());
        transY.setY(38*caseLogic.getCoordonnee().getY());
        caseImg.getTransforms().addAll(transX,transY);
    }
     
    public Coordonnee getCoordonnee() {
        return this.caseLogic.getCoordonnee();
    }
    
    @Override
    public void displayImage() {
        Random random = new Random();
        switch(caseLogic.getType()) {
            case "Route":
                Route r = (Route) caseLogic;
                caseImg.setImage(ManagerSprite.get(r.getSens()));
                break;
            case "Maison":
                Batiment bMaison = (Batiment) caseLogic;
                if (this.estAccessible) caseImg.setImage(ManagerSprite.get(bMaison.getSens()));
                else caseImg.setImage(ManagerSprite.get(bMaison.getSens()));
                break;
            case "Magasin":
                Batiment bMagasin = (Batiment) caseLogic;
                if (this.estAccessible) caseImg.setImage(ManagerSprite.get(bMagasin.getSens()));
                else caseImg.setImage(ManagerSprite.get(bMagasin.getSens()));
                break;
            case "Herbe":
                ArrayList<EnumHERBE> listEnum = new ArrayList<>();
                for (EnumHERBE enumH : EnumHERBE.values())
                    listEnum.add(enumH);               
                caseImg.setImage(ManagerSprite.get(listEnum.get(Math.abs(random.nextInt())%listEnum.size())));
                //caseImg.setImage(ManagerSprite.get(listEnum.get(GenerateurAleatoire.get().nextPositiveInt()%listEnum.size())));
                break;
        }
    }
    
    private void interactTile(){
        this.fenetreMap.FermerToutesPopup();
        if (this.caseLogic.getType() == "Magasin") {
            if(Jeu.getInstance().getJoueur().getCase() == this.getCaseLogic()) 
                this.popupView.showMagasinPane();
            else
                this.popupView.showFirstPane();
            
        } else if (this.caseLogic.getType() == "Maison") 
            controleurDeplacementJoueur.avertir(caseLogic);
    }

    public MagasinPopView getPopupView() {
        return popupView;
    }
    
    public int getCoutDistance() {
        return (Jeu.getInstance().getPartie().getDijkstra().getChemin(Jeu.getInstance().getJoueur().getCase(), this.caseLogic).size()-1)*2;
    }
}
