/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre;

import metier.PackageCarte.PackageCase.Case;
import metier.PackageJeu.Jeu;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author antho
 */
public abstract class Fenetre {
    
    protected static Stage primaryStage;
    protected Scene scene;
    protected String css;
    protected Pane root;
    

    public static Stage getStage() {
        return primaryStage;
    }
    
    public Fenetre(Stage primStage) {
        this.primaryStage = primStage;
        this.root = new Pane();
        this.root.setId("root");
        this.scene = new Scene(this.root , 1518, 854);
    }
    
    /**
     * Association du CSS
     * @param url le lien du css
     */
    protected void setCSS(String url)
    {
        scene.getStylesheets().add(url);
    }
    
    public void placeNode(ImageView i, Case c) {
        Translate transX = new Translate();
        Translate transY = new Translate();
        transX.setX(74*c.getCoordonnee().getX());
        transX.setY(38*c.getCoordonnee().getX());

        transY.setX(-74*c.getCoordonnee().getY());
        transY.setY(38*c.getCoordonnee().getY());
        i.getTransforms().addAll(transX,transY);
    }
    
    /**
     * @return la scene du menu principal
     */
    public Scene GetScene() {
        return this.scene;
    }
    
    public Pane getMap() {
        return this.root;
    }
}
