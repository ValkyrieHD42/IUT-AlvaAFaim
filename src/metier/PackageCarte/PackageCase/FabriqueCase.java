/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.PackageCarte.PackageCase;

import metier.PackageCarte.Coordonnee;

/**
 * Fabrique de case
 * @author antho
 */
public class FabriqueCase {
    
    public static Case creer(Coordonnee coor, EnumCASE type) {
        Case res = null;
        switch (type) {
            case HERBE: res = new Herbe(coor);
                break;
            case MAISON: res = new Maison(coor);
                break;
            case MAGASIN: res = new Magasin(coor);
                break;
            case ROUTE: res = new Route(coor);
                break;
        }
                
        return res;
    }
}
