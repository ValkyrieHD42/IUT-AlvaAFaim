/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageJeu;

import metier.PackageJeu.Partie;
import metier.PackageJeu.Jeu;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Galadrielle
 */
public class TestJeu 
{
    @Test
    public void TestgetPartie()
    {
        Jeu jeu = Jeu.getInstance();
        jeu.NouvellePartie();
        Partie partie1 = jeu.getPartie();
        Partie partie2 = new Partie();
        assertEquals(partie2,partie1);
    }
    
}
