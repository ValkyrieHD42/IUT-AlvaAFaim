/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageAlgorithme;

import metier.PackageAlgorithme.AlgorithmeParcours;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.PackageCase.Case;
import metier.PackageCarte.PackageCase.EnumCASE;
import metier.PackageCarte.PackageCase.FabriqueCase;
import metier.PackageJeu.Partie;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author antho
 */
public class AlgorithmeParcoursTest {

    /**
     * Test of getBatimentsAccessible method, of class AlgorithmeParcours.
     */
    @Test
    public void testGetBatimentsAccessible() {
        Partie partie = new Partie();
        
        AlgorithmeParcours algo = new AlgorithmeParcours(partie);
        
        // Test 1
        ArrayList<Case> actual1 = algo.getBatimentsAccessible();
        ArrayList<Case> expected1 = new ArrayList<>();
        expected1.add(FabriqueCase.creer(new Coordonnee(5, 1), EnumCASE.MAGASIN));
        expected1.add(FabriqueCase.creer(new Coordonnee(4, 4), EnumCASE.MAGASIN));
        
        Assert.assertEquals(2, actual1.size());
        Assert.assertEquals(actual1.get(0).getCoordonnee(),expected1.get(0).getCoordonnee());
        Assert.assertEquals(actual1.get(1).getCoordonnee(),expected1.get(1).getCoordonnee());
        
        // Test 2
        
        partie.getJoueur().setCaseJoueur(partie.getCarte().getCases().get(new Coordonnee(4, 4)));
        
        ArrayList<Case> actual2 = algo.getBatimentsAccessible();
        ArrayList<Case> expected2 = new ArrayList<>();
        expected2.add(FabriqueCase.creer(new Coordonnee(5, 1), EnumCASE.MAGASIN));
        expected2.add(FabriqueCase.creer(new Coordonnee(7, 3), EnumCASE.MAGASIN));
        expected2.add(FabriqueCase.creer(new Coordonnee(1, 2), EnumCASE.MAISON));
        
        Assert.assertEquals(3, actual2.size());
        Assert.assertEquals(actual2.get(0).getCoordonnee(),expected2.get(0).getCoordonnee());
        Assert.assertEquals(actual2.get(1).getCoordonnee(),expected2.get(1).getCoordonnee());
        Assert.assertEquals(actual2.get(2).getCoordonnee(),expected2.get(2).getCoordonnee());
    }
}
