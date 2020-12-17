/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.packageFenetre.FenetreJeu;

import controleurs.controleurs.ControleurDeplacementJoueur;
import controleurs.observeurs.ObservateurCoutDeplacement;
import controleurs.observeurs.ObservateurDepense;
import controleurs.observeurs.ObservateurDeplacementJoueur;
import ihm.EnumFONTS;
import ihm.EnumINTERFACE;
import ihm.EnumSPRITE;
import ihm.ManagerFonts;
import ihm.packageFenetre.Fenetre;
import ihm.ManagerSprite;
import ihm.packageFenetre.FenetreJeu.ElementInterface.IngredientsView;
import ihm.packageFenetre.FenetreMenu.FMenu;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageJeu.Jeu;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import metier.PackageIngredient.Ingredients;
import metier.PackageRecette.Recette;
import metier.PackageRecette.Recettes;

/**
 * 
 * @author antho
 */
public class FJeu extends Fenetre{

    private Pane map;
    private JoueurView joueurView;
    private Text depenseView = new Text();
    private ArrayList<Tile> tiles = new ArrayList<>();
    private final ControleurDeplacementJoueur controleurDeplacementJoueur;
    private Pane inventaireView;
    private ScrollPane contentInventaire;
    
    private GridPane recetteView; 
    private ScrollPane ScrollpanRecette = new ScrollPane();
    private ArrayList<VBox> listVboxRecette;
    private ArrayList<IngredientsView> listIngrViewRecettes = new ArrayList<>();
    
    public FJeu(Stage primStage) {
        super(primStage);
        
        // Link CSS
        this.setCSS("ressources/css/CSSFenetreJeu.css");
        
        // Création du Pane map
        this.map = new DragablePane();
        this.depenseView.setX(50);
        this.depenseView.setY(50);
        this.depenseView.setFont(ManagerFonts.getBigFont(EnumFONTS.ALMOND_NOUGAT));
        
        SetDepense(Jeu.getInstance().getJoueur().getDepense());
        
        ImageView background = new ImageView(ManagerSprite.get(EnumSPRITE.background));
        this.root.getChildren().addAll(background,map,depenseView);
        this.joueurView = new JoueurView(this);
        
        
        // Controleur
        controleurDeplacementJoueur = new ControleurDeplacementJoueur(this.joueurView);
        ObservateurDeplacementJoueur observateurDeplacementJoueur = new ObservateurDeplacementJoueur(this.getJoueurView(), this);
        initCarteDuJeu();
        ObservateurCoutDeplacement observateurCoutDeplacement = new ObservateurCoutDeplacement(this.tiles);
        ObservateurDepense observateurDepense = new ObservateurDepense(this);
        
        controleurDeplacementJoueur.addObservateur(observateurDeplacementJoueur,observateurDepense,observateurCoutDeplacement);
        
        afficherCarte();
        //afficheConsole();
        AfficherInv();
        AfficherLayoutRecette();
        afficherRecette();

        afficherBtnMenu();
        //AfficherBatimentsAccessible();
        
        this.joueurView.displayImage();
        setupPopup();
    }

    public ControleurDeplacementJoueur getControleurDeplacementJoueur() {
        return controleurDeplacementJoueur;
    }
    
    public ArrayList<IngredientsView> getIngredientsViewRecette() {
        return this.listIngrViewRecettes;
    }
    
    @Override
    public Pane getMap() {
        return this.map;
    }
    
    public JoueurView getJoueurView() {
        return joueurView;
    }
    
    public void initCarteDuJeu() {
        this.map.setTranslateX(500);
        this.map.setTranslateY(50);
        
        for(int i=0 ;i< Jeu.getInstance().getPartie().getCarte().getNbColonne();i++) {
            for(int j=0 ;j< Jeu.getInstance().getPartie().getCarte().getNbLigne();j++) {
                tiles.add(new Tile(Jeu.getInstance().getPartie(),this,new Coordonnee(i,j)));
            }
        }
    }
    
    /**
     * affiche les images des tiles (case)
     */
    private void afficherCarte() {
        for (Tile t : this.tiles)
            t.displayImage();
    }
    
    /**
     * permet de mettre en place les popup des magasin
     */
    private void setupPopup() {
        for (Tile t : this.tiles)
            if(t.getCaseLogic().getType() == "Magasin")
                t.setPopupView(new MagasinPopView(this, t));
    }
    
    public Text SetDepense(int i) {
        depenseView.setText("DEPENSE : " + String.valueOf(i));
        return depenseView;
    }
    
    public void AfficherLayoutRecette() {
        ImageView Layout = new ImageView(ManagerSprite.get(EnumINTERFACE.Interface_bg_Recette));
        Layout.setX(1100);
        Layout.setY(0);
        this.root.getChildren().add(Layout);
    }
    
    public void AfficherBatimentsAccessible() {
        ArrayList<Case> batAccessibles = Jeu.getInstance().getPartie().getBatimentsAccessible();
        
        
        for (Case c : batAccessibles) {
            System.out.println(c.getCoordonnee().toString());
            for (Tile tile : this.tiles) {
                if (c.getCoordonnee().equals(tile.getCoordonnee())) tile.setEstAccessible(true);
                else tile.setEstAccessible(false);
                tile.displayImage();
            }
        }
    }
    
    public void switchInventaireBtnPos(ImageView n, Pane inv) {
        Timeline timeline = new Timeline();
        KeyFrame move;
        KeyFrame move2;
        if(n.getY() == 814) {
            move = new KeyFrame(Duration.seconds(0.4),new KeyValue(n.yProperty(), 614));
            move2 = new KeyFrame(Duration.seconds(0.4),new KeyValue(inv.layoutYProperty(), 654));
            timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                n.setImage(ManagerSprite.get(EnumINTERFACE.BtInventaireFermer));
            }
        });
        } else {
            move = new KeyFrame(Duration.seconds(0.4),new KeyValue(n.yProperty(), 814));
            move2 = new KeyFrame(Duration.seconds(0.4),new KeyValue(inv.layoutYProperty(), 853));
            timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                n.setImage(ManagerSprite.get(EnumINTERFACE.BtInventaireOuvert));
            }
        });
        }
        
        timeline.getKeyFrames().addAll(move,move2);
        timeline.play();
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    
    /**
     * ferme toutes les popups de la fenetre
     */
    public void FermerToutesPopup() {
        for(Tile t : getTiles())
            if(t.getCaseLogic().getType() == "Magasin") {
                t.getPopupView().hide();
            }
    }

    private void afficherBtnMenu() {
        ImageView btnMenu = new ImageView(ManagerSprite.get(EnumINTERFACE.quitterBTN));
        btnMenu.setX(1260);
        btnMenu.setY(787);
        btnMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> retourMenu());
        btnMenu.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnMenu.setImage(ManagerSprite.get(EnumINTERFACE.quitterBTNhover));
            }
        });
        btnMenu.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnMenu.setImage(ManagerSprite.get(EnumINTERFACE.quitterBTN));
            }
        });

  
        ImageView btnSave = new ImageView(ManagerSprite.get(EnumINTERFACE.sauvegarderBTN));
        btnSave.setX(1232);
        btnSave.setY(647);
        btnSave.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> sauvegarde());
        btnSave.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnSave.setImage(ManagerSprite.get(EnumINTERFACE.sauvegarderBTNhover));
            }
        });
        btnSave.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnSave.setImage(ManagerSprite.get(EnumINTERFACE.sauvegarderBTN));
            }
        });
        
        ImageView btnAbandon = new ImageView(ManagerSprite.get(EnumINTERFACE.abandonnerBTN));
        btnAbandon.setX(1245);
        btnAbandon.setY(728);
        btnAbandon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> abandon());
        btnAbandon.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnAbandon.setImage(ManagerSprite.get(EnumINTERFACE.abandonnerBTNhover));
            }
        });
        btnAbandon.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                btnAbandon.setImage(ManagerSprite.get(EnumINTERFACE.abandonnerBTN));
            }
        });
        
        this.root.getChildren().addAll(btnMenu,btnSave,btnAbandon);
    }
    
    private void retourMenu() {
        FMenu menu = new FMenu(primaryStage);
        Fenetre.primaryStage.setScene(menu.GetScene());
    }
    
    public void displayInvContent() {
        GridPane gridPane = (GridPane) this.contentInventaire.getContent();
        gridPane.getChildren().clear();
        
        int k = 0;
        int ligne=0;
        int ingMinus = 0;
        for(int i = 0; i<Jeu.getInstance().getJoueur().getInventaire().getIngredients().size()/6;i++) {
            for(int j = 0;j<6;j++) {
                Ingredients ingr = Jeu.getInstance().getJoueur().getInventaire().getIngredients().get(k);
                k++;
                if(ingr.getNombre() != 0) {
                    gridPane.add(new IngredientsView(ingr,this).getVisuelInventaire(),j-ingMinus,i);
                } else {
                    ingMinus++;
                }
            }
            ligne = i;
        }
        for(int i = 0;i<Jeu.getInstance().getJoueur().getInventaire().getIngredients().size()%6;i++) {
            Ingredients ingr = Jeu.getInstance().getJoueur().getInventaire().getIngredients().get(k);
            k++;
            if(ingr.getNombre() != 0) {
                gridPane.add(new IngredientsView(ingr,this).getVisuelInventaire(),i-ingMinus,ligne+1);
            } else {
                ingMinus++;
            }
        }
    }
    
    /**
     * affiche l'inventaire
     */
    public void AfficherInv() { 
        this.inventaireView = new Pane();
        
        // contenue inv
        this.contentInventaire = new ScrollPane();
        // Fixe les règles sur la scrollbar
        this.contentInventaire.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.contentInventaire.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.contentInventaire.setPrefSize(2000, 300);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(100);
        gridPane.setVgap(15);
        gridPane.setGridLinesVisible(true);
        
        this.contentInventaire.setContent(gridPane);
        
        ImageView inventaire_bg = new ImageView(ManagerSprite.get(EnumINTERFACE.Interface_bg_Inventaire));
        this.inventaireView.layoutXProperty().set(0);
        this.inventaireView.layoutYProperty().set(860);
        this.inventaireView.getChildren().add(0,inventaire_bg);
        this.inventaireView.getChildren().addAll(this.contentInventaire);
        displayInvContent();
        
        ImageView btnInv = new ImageView(ManagerSprite.get(EnumINTERFACE.BtInventaireOuvert));
        btnInv.setX(0);
        btnInv.setY(814);
        
        btnInv.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> switchInventaireBtnPos(btnInv,this.inventaireView));
  
        this.root.getChildren().addAll(this.inventaireView,btnInv);
    }
    
    /**
     * affiche les recettes
     */
    public void afficherRecette() {
        this.ScrollpanRecette = new ScrollPane();
        this.recetteView = new GridPane();
        
        this.ScrollpanRecette.setContent(recetteView);
        this.ScrollpanRecette.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.ScrollpanRecette.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.ScrollpanRecette.setPrefSize(350,390);
        this.ScrollpanRecette.setLayoutX(1160);
        this.ScrollpanRecette.setLayoutY(190);
        
        this.listVboxRecette = new ArrayList<VBox>();
        int i = 0;
        for (Recette r : Recettes.get().listRecettesPartie())
        {
            
            Pane p = new Pane(new ImageView(ManagerSprite.get(r.getNom())));
            GridPane g = ContenuGridPaneRecette(r);
            
            this.listVboxRecette.add(new VBox(p,g));
            this.listVboxRecette.get(i).getChildren().get(1).setVisible(false);
            this.listVboxRecette.get(i).getChildren().get(1).managedProperty().bind(this.listVboxRecette.get(i).getChildren().get(1).visibleProperty());

            VBox vb = this.listVboxRecette.get(i);
            p.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> EventBoutonRecette(vb));
            i++;
        }

        for(int j =0;j<this.listVboxRecette.size();j++)
        {
            this.recetteView.add(this.listVboxRecette.get(j),0,j); 
        }

        this.root.getChildren().addAll(this.ScrollpanRecette); 
       

    }
    public void EventBoutonRecette(VBox v){
        if(!v.getChildren().get(1).isVisible())
        {
            for(VBox instance : this.listVboxRecette)
            {
               instance.getChildren().get(1).setVisible(false);
               instance.getChildren().get(1).managedProperty().bind(instance.getChildren().get(1).visibleProperty());
            }
            v.getChildren().get(1).setVisible(true);
            v.getChildren().get(1);
            this.recetteView.autosize();
            

        }
        else
        {
            v.getChildren().get(1).setVisible(false);            
        }
    }
    public GridPane ContenuGridPaneRecette(Recette r) {
        GridPane g = new GridPane();
        g.getChildren().clear();
        int k =0;
        for(Ingredients i :r.getInventaire().getIngredients())
        {
            IngredientsView ingrViewRecette = new IngredientsView(i, this);
            this.listIngrViewRecettes.add(ingrViewRecette);
            g.add(ingrViewRecette.getVisuelRecette(),0,k);
            k++;
        }        
        return g;
    }
    
    private void sauvegarde() {
        // Appel de Sauvegarde
    }

    private void abandon() {
        // Appel de Solution
    }
}