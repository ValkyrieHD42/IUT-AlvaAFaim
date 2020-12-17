package metier.PackageCarte;

/**
 * Enum des sens reprennant le code chiffré suivant : <br/>
 * <br/>
 * HG GAUCHE /\HD HAUT  <br/>
 * BG BAS \/BD DROITE <br/>
 * avec : <br/>
 * L_ : Ligne droite<br/>
 * T_ : Tournant<br/>
 * I_ : Intersection<br/>
 * C_ : Croisement<br/>
 * @author antho
 */
public enum EnumROUTES {
    ROUTE,
    ROUTE_HAUT,
    ROUTE_DROITE,
    ROUTE_BAS,
    ROUTE_GAUCHE,
    ROUTE_HAUT_BAS,
    ROUTE_DROITE_GAUCHE,
    ROUTE_HAUT_DROITE,
    ROUTE_BAS_GAUCHE,
    ROUTE_DROITE_BAS,
    ROUTE_HAUT_GAUCHE,
    ROUTE_DROITE_BAS_GAUCHE,
    ROUTE_HAUT_DROITE_BAS,
    ROUTE_HAUT_DROITE_GAUCHE,
    ROUTE_HAUT_BAS_GAUCHE,
    ROUTE_HAUT_DROITE_BAS_GAUCHE;
}
