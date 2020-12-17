/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import metier.PackageCarte.EnumBATIMENTS;
import metier.PackageCarte.EnumROUTES;
import metier.PackageIngredient.EnumINGREDIENTS;
import java.io.File;
import java.util.HashMap;
import javafx.scene.image.Image;
import metier.PackageIngredient.EnumINGREDIENTSPRITE;
import metier.PackageRecette.EnumRECETTES;

/**
 *
 * @author antho
 */
public class ManagerSprite {
    private static ManagerSprite instance;
    private final static HashMap<EnumINTERFACE, Image> listInterface = new HashMap<>();
    private final static HashMap<EnumSPRITE, Image> listSprite = new HashMap<>();
    private final static HashMap<EnumINGREDIENTSPRITE, Image> listIngredients = new HashMap<>();
    private final static HashMap<EnumROUTES, Image> listSpriteRoutes = new HashMap<>();
    private final static HashMap<EnumBATIMENTS, Image> listSpriteBatiments = new HashMap<>();
    private final static HashMap<EnumRECETTES, Image> listSpriteRecettes = new HashMap<>();
    private final static HashMap<EnumHERBE, Image> listSpriteHerbe = new HashMap<>();
    
    private ManagerSprite() {
        
        for (EnumINTERFACE enumsprite : EnumINTERFACE.values())
            listInterface.put(enumsprite,new Image(new File("src/ressources/images/Interface/" + enumsprite.name() +".png").toURI().toString()));
        
        for (EnumSPRITE enumsprite : EnumSPRITE.values())
            listSprite.put(enumsprite,new Image(new File("src/ressources/images/map/Autres/" + enumsprite.name() +".png").toURI().toString()));
        
        for (EnumINGREDIENTSPRITE enumsprite : EnumINGREDIENTSPRITE.values())
            listIngredients.put(enumsprite,new Image(new File("src/ressources/images/Ingredients/" + enumsprite.name() +".png").toURI().toString()));
        
        for (EnumROUTES enumsprite : EnumROUTES.values())
            listSpriteRoutes.put(enumsprite,new Image(new File("src/ressources/images/map/Routes/" + enumsprite.name() +".png").toURI().toString()));
        
        for (EnumBATIMENTS enumsprite : EnumBATIMENTS.values())
            listSpriteBatiments.put(enumsprite,new Image(new File("src/ressources/images/map/Batiments/" + enumsprite.name() +".png").toURI().toString()));
       
        for (EnumRECETTES enumsprite : EnumRECETTES.values())
            listSpriteRecettes.put(enumsprite,new Image(new File("src/ressources/images/Recettes/" + enumsprite.name() +".png").toURI().toString()));
        
        for (EnumHERBE enumsprite : EnumHERBE.values())
            listSpriteHerbe.put(enumsprite,new Image(new File("src/ressources/images/map/Vides/" + enumsprite.name() +".png").toURI().toString()));
    }
    
    
    /**
     * 
     * @param spriteName
     * @return 
     */
    
    public static Image get(EnumSPRITE spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listSprite.get(spriteName);
    }
    
    public static Image get(EnumINGREDIENTSPRITE spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listIngredients.get(spriteName);
    }
    
    public static Image get(EnumINTERFACE spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listInterface.get(spriteName);
    }
    
    public static Image get(EnumROUTES spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listSpriteRoutes.get(spriteName);
    }
        
    public static Image get(EnumBATIMENTS spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listSpriteBatiments.get(spriteName);
    }
    
    public static Image get(EnumHERBE spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listSpriteHerbe.get(spriteName);
    }
    
    public static Image get(EnumRECETTES spriteName) {
        if (instance == null) instance = new ManagerSprite();

        return listSpriteRecettes.get(spriteName);
    }
}
