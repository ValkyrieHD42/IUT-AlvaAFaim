/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageCarte;

import metier.PackageCarte.Carte;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageCarte.PackageCase.EnumCASE;
import metier.PackageCarte.PackageCase.FabriqueCase;
import metier.PackageJeu.Partie;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antho
 */
public class CarteTest {

    /**
     * Test of getMaison method, of class Carte.
     */
    @Test
    public void testGetMaison() {
        Partie partie = new Partie();
        Carte instance = partie.getCarte();
        Case expResult = FabriqueCase.creer(new Coordonnee(1, 2), EnumCASE.MAISON);
        Case result = instance.getMaison();
        assertEquals(expResult, result);
    }

}
