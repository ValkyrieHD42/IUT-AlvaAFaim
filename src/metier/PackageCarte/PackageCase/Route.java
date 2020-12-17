package metier.PackageCarte.PackageCase;

import metier.PackageCarte.PackageCase.Case;
import java.util.*;
import metier.PackageCarte.Coordonnee;
import metier.PackageCarte.EnumROUTES;
import metier.PackageIngredient.EnumINGREDIENTS;

/**
 * Case de route 
 */
public class Route extends Case{
    
    private EnumROUTES sens;
    
    /**
     * Crée une route
     * @param coordonnee
     */
    public Route(Coordonnee coordonnee) {
        super(coordonnee);
    }

    public EnumROUTES getSens() {
        return sens;
    }

    public void setSens(EnumROUTES sens) {
        this.sens = sens;
    }
    
    @Override
    public String getType() {
        return "Route";
    }

    @Override
    public int getPrix() {
        return 2;
    }
    
    @Override
    public int getPrix(EnumINGREDIENTS ing) {
        return 0;
    }

    @Override
    public EnumCASE getTypeEnum() {
        return EnumCASE.ROUTE;
    }
}