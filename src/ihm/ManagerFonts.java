/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.util.HashMap;
import javafx.scene.text.Font;

/**
 * commentaires
 * @author Galadrielle
 */
public class ManagerFonts 
{
    private static ManagerFonts instance;
    private final static HashMap<EnumFONTS, Font> listLittleFonts = new HashMap<>();
    private final static HashMap<EnumFONTS, Font> listBigFonts = new HashMap<>();
    
    private ManagerFonts()
    {
        for (EnumFONTS enumfonts : EnumFONTS.values())
        {
            listLittleFonts.put(enumfonts,Font.loadFont("file:src/ressources/fonts/" + enumfonts.name() +".otf",12));
        }
        
        for (EnumFONTS enumfonts : EnumFONTS.values())
        {
            listBigFonts.put(enumfonts,Font.loadFont("file:src/ressources/fonts/" + enumfonts.name() +".otf",25));
        }
    }
    
    public static Font getLittleFont(EnumFONTS nameFont)
    {
        if(instance == null)
        {
            instance = new ManagerFonts();
        }
        Font font = listLittleFonts.get(nameFont);
        return font;
    }
    
    public static Font getBigFont(EnumFONTS nameFont)
    {
        if(instance == null)
        {
            instance = new ManagerFonts();
        }
        Font font = listBigFonts.get(nameFont);
        return font;
    }
}