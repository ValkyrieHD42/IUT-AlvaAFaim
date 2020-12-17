/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreMenu;

import ihm.packageFenetre.Fenetre;
import ihm.packageFenetre.FenetreJeu.FJeu;
import javafx.animation.FadeTransition;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import metier.PackageJeu.Jeu;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author antho
 */
public class FMenu extends Fenetre{
    
    public FMenu(Stage primStage) {
        super(primStage);
        
        this.setCSS("ressources/css/CSSFenetreMenu.css");
        
        // TextBox seed
        TextField seedTextField = new TextField();
        seedTextField.setLayoutX(20);
        seedTextField.setLayoutY(20);
        
        // Création des boutons
        int x = 1099;
        int y = 202;
        
        ImageView playButton = new ImageView();
        playButton.setId("PlayButton");
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> CreateGame(event));
        playButton.setX(x);
        playButton.setY(y);
        
        ImageView newGameButton = new ImageView();
        newGameButton.setId("NewGame");
        newGameButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> NouvellePartie(event, seedTextField.getText()));
        newGameButton.setX(x);
        newGameButton.setY(y+113);
        
        ImageView optionButton = new ImageView();
        optionButton.setId("Option");
        optionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> onOption(event));
        optionButton.setX(x);
        optionButton.setY(y+113*2);
        
        ImageView quitButton = new ImageView();
        quitButton.setId("Quit");
        quitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> onQuit(event));
        quitButton.setX(x);
        quitButton.setY(y+113*3);
        

        
        // Ajout à la fenêtre
        
        this.root.getChildren().addAll(seedTextField,playButton,newGameButton,optionButton,quitButton);
        
    }

    public void NouvellePartie(InputEvent event, String seedString)
    {
        
        Jeu jeu = Jeu.getInstance();
        jeu.NouvellePartie(seedString);
        
        Fenetre fenetreJeu = new FJeu(primaryStage);
        
        Fenetre.primaryStage.setScene(fenetreJeu.GetScene());
        
        event.consume();
    }
    
    private void onQuit(MouseEvent event) {
        primaryStage.close();
    }

    private void CreateGame(MouseEvent event) {
        //TODO
    }

    private void onOption(MouseEvent event) {
        //TODO
    }
    
}
