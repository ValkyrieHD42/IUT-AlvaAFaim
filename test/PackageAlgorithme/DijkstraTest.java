/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageAlgorithme;

import metier.PackageAlgorithme.Dijkstra;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageCarte.PackageCase.Magasin;
import metier.PackageCarte.PackageCase.Route;
import metier.PackageJeu.Partie;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antho
 */
public class DijkstraTest {

    /**
     * Test of getChemin method, of class Dijkstra.
     */
    @Test
    public void testGetChemin() {
        
        // Test 1
        System.out.println("getChemin");
        Partie partie = new Partie();
        Case depart1 = partie.getJoueur().getCase();
        Case batiment1 = partie.getCarte().getCases().get(new Coordonnee(5, 1));
        Dijkstra instance = new Dijkstra(partie);
        ArrayList<Case> expResult1 = new ArrayList<>();
        
        expResult1.add(new Route(new Coordonnee(1, 1)));
        expResult1.add(new Route(new Coordonnee(2, 1)));
        expResult1.add(new Route(new Coordonnee(3, 1)));
        expResult1.add(new Route(new Coordonnee(4, 1)));
        expResult1.add(new Magasin(new Coordonnee(5, 1)));
        
        ArrayList<Case> result1 = instance.getChemin(depart1, batiment1);
        assertEquals(5,result1.size());
        assertEquals(expResult1, result1);
        
        // Test 2
        Case depart2 = partie.getJoueur().getCase();
        Case batiment2 = partie.getCarte().getCases().get(new Coordonnee(4, 4));
        ArrayList<Case> expResult2 = new ArrayList<>();
        
        expResult2.add(new Route(new Coordonnee(2, 2)));
        expResult2.add(new Route(new Coordonnee(3, 2)));
        expResult2.add(new Route(new Coordonnee(4, 2)));
        expResult2.add(new Route(new Coordonnee(4, 3)));
        expResult2.add(new Magasin(new Coordonnee(4, 4)));
        
        ArrayList<Case> result2 = instance.getChemin(depart2, batiment2);
        assertEquals(5,result2.size());
        assertEquals(expResult2, result2);
        
        // Test 3
        Case depart3 = partie.getJoueur().getCase();
        Case batiment3 = partie.getCarte().getCases().get(new Coordonnee(7, 3));
        
        ArrayList<Case> result3 = instance.getChemin(depart3, batiment3);
        assertEquals(0,result3.size());
        
        // Test 4
        partie.getJoueur().setCaseJoueur(partie.getCarte().getCases().get(new Coordonnee(7, 3)));
        Case depart4 = partie.getJoueur().getCase();
        Case batiment4 = partie.getCarte().getCases().get(new Coordonnee(4, 4));
        ArrayList<Case> expResult4 = new ArrayList<>();
        
        expResult4.add(new Route(new Coordonnee(7, 4)));
        expResult4.add(new Route(new Coordonnee(6, 4)));
        expResult4.add(new Route(new Coordonnee(5, 4)));
        expResult4.add(new Magasin(new Coordonnee(4, 4)));
        
        ArrayList<Case> result4 = instance.getChemin(depart4, batiment4);
        assertEquals(4,result4.size());
        assertEquals(expResult4, result4);
    }
}