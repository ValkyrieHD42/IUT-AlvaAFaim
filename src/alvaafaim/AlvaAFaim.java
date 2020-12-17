/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvaafaim;


import ihm.EnumSPRITE;
import ihm.ManagerSprite;
import javafx.application.Application;
import javafx.stage.Stage;
import ihm.packageFenetre.FenetreMenu.FenetreStart.FStart;

/**
 *
 * @author Anthony
 */
public class AlvaAFaim extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        FStart start = new FStart(primaryStage);
        
        primaryStage.setTitle("Alva A Faim");
        primaryStage.getIcons().add(ManagerSprite.get(EnumSPRITE.icon));
        primaryStage.setScene(start.GetScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        start.end();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
