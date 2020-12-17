/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageAlgorithme;

import metier.PackageAlgorithme.AlgorithmeGenMap;
import metier.PackageAlgorithme.AlgorithmeDur;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.EnumROUTES;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageCarte.PackageCase.EnumCASE;
import metier.PackageCarte.PackageCase.FabriqueCase;
import metier.PackageCarte.PackageCase.Route;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathi
 */
public class AlgorithmeGenMapTest {
    /**
     * Test of calcul method, of class Algorithme.
     */
    @Test
    public void testCalcul() {
    }

    /**
     * Test of init method, of class Algorithme.
     */
    @Test
    public void testInit() {
        AlgorithmeGenMap a = new AlgorithmeDur();   
        a.init();
        for(Case c : a.cases.values()) 
        {
            Assert.assertEquals("Herbe",c.getType());
        }

    }

    /**
     * Test of ajouterCase method, of class Algorithme.
     */
    @Test
    public void testAjouterCase() 
    {
        AlgorithmeGenMap a = new AlgorithmeDur();   
        a.init(10);

        // ajouter magasins
        a.ajouterCaseV(new Coordonnee(1, 2),EnumCASE.MAGASIN);
            
        Case c = a.cases.get(new Coordonnee(1,2));
        Assert.assertEquals("Magasin",c.getType());
        Assert.assertEquals(new Coordonnee(1,2),c.getCoordonnee());

    }

    /**
     * Test of calculVoisin method, of class Algorithme.
     */
    @Test
    public void testCalculVoisin() {
        AlgorithmeGenMap a = new AlgorithmeDur();   
        a.init(10);

        // ajouter magasins
        a.ajouterCaseV(new Coordonnee(1, 2),EnumCASE.MAGASIN);
        a.ajouterCaseV(new Coordonnee(2, 2),EnumCASE.ROUTE);
        
        a.calculVoisin();
        
        Case c = a.cases.get(new Coordonnee(1,2));
       // POUR LES TEST : Redefinir la fonction Equals peut permettre de le faire (enfin je crois)  et faire un Equals a la place de tester s'il sont egal au string
        Assert.assertEquals("Herbe",c.getVoisins().get(0).getType()); // 0 correspond a haut
        Assert.assertEquals("Route",c.getVoisins().get(1).getType()); // 1 correspond a droite
        Assert.assertEquals("Herbe",c.getVoisins().get(2).getType()); // 2 correspond a bas
        Assert.assertEquals("Herbe",c.getVoisins().get(3).getType()); // 3 correspond a gauche


    }

    /**
     * Test of calculRoute method, of class Algorithme.
     */
    @Test
    public void testCalculRoute() {
        AlgorithmeGenMap a = new AlgorithmeDur();   
        a.init(10);

        // ajouter magasins
        a.ajouterCaseV(new Coordonnee(1, 2),EnumCASE.MAGASIN);
        a.ajouterCaseV(new Coordonnee(2, 1),EnumCASE.MAGASIN);
        
        // ajouter route
        a.ajouterCaseV(new Coordonnee(2, 2),EnumCASE.ROUTE);
        a.calculVoisin();
        a.calculSens();
        
        Route r = (Route) a.cases.get(new Coordonnee(2, 2));
        Assert.assertEquals(EnumROUTES.ROUTE_HAUT_GAUCHE,r.getSens());

    }
    
}
