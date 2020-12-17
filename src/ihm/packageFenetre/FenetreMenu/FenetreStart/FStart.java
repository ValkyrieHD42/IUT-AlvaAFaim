/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreMenu.FenetreStart;

import ihm.packageFenetre.Fenetre;
import ihm.packageFenetre.FenetreMenu.FMenu;
import javafx.stage.Stage;

/**
 *
 * @author antho
 */
public class FStart extends Fenetre{
    
    public FStart(Stage primStage) {
        super(primStage);
        this.setCSS("ressources/css/CSSFenetreStart.css");
    }
    
    public void end() {
        Fenetre fenetreMenu = new FMenu(primaryStage);
        Fenetre.primaryStage.setScene(fenetreMenu.GetScene());
    }
}
