/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreJeu;

import javafx.scene.layout.Pane;

/**
 *
 * @author antho
 */
public class DragablePane extends Pane {
        private double mouseX ;
        private double mouseY ;
        
        public DragablePane() {

            setOnMousePressed(event -> {
                mouseX = event.getSceneX() ;
                mouseY = event.getSceneY() ;
            });

            setOnMouseDragged(event -> {
               double deltaX = event.getSceneX() - mouseX ;
               double deltaY = event.getSceneY() - mouseY ;
               relocate(getLayoutX() + deltaX, getLayoutY() + deltaY);
               mouseX = event.getSceneX() ;
               mouseY = event.getSceneY() ;
            });
        }
    }
