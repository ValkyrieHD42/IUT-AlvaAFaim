package metier.PackageCarte.PackageCase;

import metier.PackageCarte.Coordonnee;

/**
 * Represente un batiment Magasin
 */
public class Magasin extends Batiment {
    
    public Magasin(Coordonnee coor) 
    {
        super(coor);
    }

    @Override
    public String getType() 
    {
        return "Magasin";
    }
    
    @Override
    public int getPrix() {
        return 0;
    }

    @Override
    public EnumCASE getTypeEnum() {
        return EnumCASE.MAGASIN;
    }
}