/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreJeu;

import controleurs.controleurs.ControleurDeplacementJoueur;
import ihm.EnumFONTS;
import ihm.EnumINTERFACE;
import ihm.EnumSPRITE;
import ihm.ManagerFonts;
import ihm.packageFenetre.FenetreJeu.ElementInterface.IngredientsView;
import ihm.ManagerSprite;
import metier.PackageCarte.PackageCase.Magasin;
import metier.PackageIngredient.Ingredients;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;

/**
 * Classe représentant un popup de magasin
 * @author antho
 */
public class MagasinPopView {
    
    private final Pane firstPane;
    private final Pane magasinContentPane;
    private final Pane magasinPane;
    private final FJeu fenetre;
    private final Tile tile;
    private final Magasin magasin;
    private final Text cout = new Text();
    private final ImageView btnSeDeplacer;
    private ControleurDeplacementJoueur controleurDeplacementJoueur;
    
    
    public MagasinPopView(FJeu fenetre, Tile tile) {
        this.firstPane = new Pane();
        this.magasinContentPane = new Pane();
        this.magasinPane = new Pane();
        this.fenetre = fenetre;
        this.tile = tile;
        this.magasin = (Magasin) tile.getCaseLogic();
        this.btnSeDeplacer = new ImageView(ManagerSprite.get(EnumINTERFACE.BtSeDeplacer));
        this.cout.setTranslateX(40);
        this.cout.setTranslateY(40);
        //this.cout.setTranslateY(100);
        this.cout.setFont(ManagerFonts.getBigFont(EnumFONTS.ALMOND_NOUGAT));
        placePopup();
        
        // Controleur
        this.controleurDeplacementJoueur = fenetre.getControleurDeplacementJoueur();

        displayPane();
        

    }
    
    public void showFirstPane() {
        this.firstPane.setVisible(true);
    }
    
    public void showContentPane() {
        this.magasinContentPane.setVisible(true);
    }
    
    public void showMagasinPane() {
        this.magasinPane.setVisible(true);
    }
    
    private void displayPane() {
        // Première fenetre
        this.firstPane.setVisible(false);
        this.firstPane.getChildren().add(new ImageView(ManagerSprite.get(EnumINTERFACE.infobullPopup)));
        this.fenetre.getMap().getChildren().add(this.firstPane);
        this.firstPane.getChildren().add(cout);
        this.firstPane.toFront();
        displayBtnContenu();
        displayBtnDeplacer();
        displayCoutDeplacer();
        displayCross(this.firstPane,192,10);
        
        // Contenu preview magasin
        this.magasinContentPane.setVisible(false);
        this.magasinContentPane.getChildren().add(new ImageView(ManagerSprite.get(EnumINTERFACE.infobullPopup)));
        this.magasinContentPane.toFront();
        this.fenetre.getMap().getChildren().add(this.magasinContentPane);
        displayMagasinContent();
        displayCross(this.magasinContentPane,192,10);
        displayArrow();
        
        // Fenetre magasin
        this.magasinPane.setVisible(false);
        this.magasinPane.getChildren().add(new ImageView(ManagerSprite.get(EnumINTERFACE.infofullMagasin)));
        this.magasinPane.toFront();
        this.fenetre.getMap().getChildren().add(this.magasinPane);
        displayMagasin();
        displayCross(this.magasinPane,280,10);
    }

    public void hide() {
        this.firstPane.setVisible(false);
        this.magasinContentPane.setVisible(false);
        this.magasinPane.setVisible(false);
        //this.fenetre.getMap().getChildren().removeAll(firstPane,magasinPane);
    }
    
    private void placePopup() {
        Translate transX = new Translate();
        Translate transY = new Translate();
        transX.setX(74*tile.getCaseLogic().getCoordonnee().getX()-20);
        transX.setY(38*tile.getCaseLogic().getCoordonnee().getX()-80);

        transY.setX(-74*tile.getCaseLogic().getCoordonnee().getY()-20);
        transY.setY(38*tile.getCaseLogic().getCoordonnee().getY()-80);
        firstPane.getTransforms().addAll(transX,transY);
        magasinContentPane.getTransforms().addAll(transX,transY);
        
        Translate transX2 = new Translate();
        Translate transY2 = new Translate();
        transX2.setX(74*tile.getCaseLogic().getCoordonnee().getX()-43);
        transX2.setY(38*tile.getCaseLogic().getCoordonnee().getX()-115);

        transY2.setX(-74*tile.getCaseLogic().getCoordonnee().getY()-43);
        transY2.setY(38*tile.getCaseLogic().getCoordonnee().getY()-115);
        magasinPane.getTransforms().addAll(transX2,transY2);
    }

    private void displayCross(Pane p, int x, int y) {
        ImageView cross = new ImageView(ManagerSprite.get(EnumSPRITE.crosstest));
        cross.setTranslateX(x);
        cross.setTranslateY(y);
        
        cross.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> hide());
        p.getChildren().add(cross);
    }
    
    private void displayBtnContenu() {
        ImageView btnContenu = new ImageView(ManagerSprite.get(EnumINTERFACE.BtVoirMagasin));
        btnContenu.setTranslateX(35);
        btnContenu.setTranslateY(110);
        //cross.setTranslateY(40);
        
        btnContenu.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> openContenu());
        this.firstPane.getChildren().add(btnContenu);
    }
    
    private void displayBtnDeplacer() {
        btnSeDeplacer.setTranslateX(35);
        btnSeDeplacer.setTranslateY(65);
        //btnSeDeplacer.setTranslateY(110);
        btnSeDeplacer.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> this.controleurDeplacementJoueur.avertir(magasin));
        this.firstPane.getChildren().add(btnSeDeplacer);
    }
    
    private void displayArrow() {
        ImageView arrow = new ImageView(ManagerSprite.get(EnumINTERFACE.smallArrow));
        arrow.setTranslateX(20);
        arrow.setTranslateY(10);
        
        arrow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> goBack());
        this.magasinContentPane.getChildren().add(arrow);
    }

    private void openContenu() {
        this.firstPane.setVisible(false);
        this.magasinContentPane.setVisible(true);
    }
    
    private void goBack() {
        this.magasinContentPane.setVisible(false);
        this.firstPane.setVisible(true);
    }

    public void displayCoutDeplacer() {
        
        int i = this.tile.getCoutDistance();
        if (i >= 0) {
            this.btnSeDeplacer.setImage(ManagerSprite.get(EnumINTERFACE.BtSeDeplacer));
            cout.setText("COUT  TRAJET : " + i);
        } else {
            this.btnSeDeplacer.setImage(ManagerSprite.get(EnumINTERFACE.BtInaccessible));
            cout.setText("");
        }
    }
    
    private void displayMagasinContent() {
        ScrollPane content = new ScrollPane();
        // Fixe les règles sur la scrollbar
        content.setHbarPolicy(ScrollBarPolicy.NEVER);
        content.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        content.setPrefSize(205, 130);
        
        content.setTranslateX(5);
        content.setTranslateY(30);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        
        for(int i = 0; i<this.magasin.getInventaire().getIngredients().size();i++) {
            Ingredients ingr = this.magasin.getInventaire().getIngredients().get(i);
            gridPane.add(new IngredientsView(ingr, this.tile,this.fenetre).getVisuelContenuMagasin(),1,i);
        }
        
        content.setContent(gridPane);
        
        this.magasinContentPane.getChildren().add(content);
    }
    
    public void displayMagasin() {
        ScrollPane content = new ScrollPane();
        // Fixe les règles sur la scrollbar
        content.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        content.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        content.setPrefSize(300, 200);
        
        content.setTranslateX(5);
        content.setTranslateY(30);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        
        int k = 0;
        int ligne=0;
        for(int i = 0; i<this.magasin.getInventaire().getIngredients().size()/3;i++) {
            for(int j = 0;j<3;j++) {
                Ingredients ingr = this.magasin.getInventaire().getIngredients().get(k);
                k++;
                gridPane.add(new IngredientsView(ingr, this.tile,this.fenetre).getVisuelMagasin(),j,i);
            }
            ligne = i;
        }
        for(int i = 0;i<this.magasin.getInventaire().getIngredients().size()%3;i++) {
            Ingredients ingr = this.magasin.getInventaire().getIngredients().get(k);
            k++;
            gridPane.add(new IngredientsView(ingr, this.tile,this.fenetre).getVisuelMagasin(),i,ligne+1);
        }
        
        content.setContent(gridPane);
        
        this.magasinPane.getChildren().add(content);
    }
    
    public void Actualise() {
        displayMagasin();
        displayMagasinContent();
    }
}
