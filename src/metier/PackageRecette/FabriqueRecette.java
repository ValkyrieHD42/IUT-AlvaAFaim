package metier.PackageRecette;

import metier.PackageIngredient.EnumINGREDIENTS;
import metier.PackageIngredient.Inventaire;

/**
 * Represente une fabrique de recette
 */
public class FabriqueRecette {

	/**
	 * Creer une recette
	 * @param nom
	 */
	public static Recette CreerRecette(EnumRECETTES nom) {
		Recette r = null;
                Inventaire i = new Inventaire();
                
        switch (nom) {
                case PIZZA:
                    i.ajouterIngredient(EnumINGREDIENTS.PATE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.TOMATE, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.MOZZARELLA, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.JAMBON, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.CHAMPIGNON, 6);
                    i.ajouterIngredient(EnumINGREDIENTS.PARMESAN, 4);
                    break;
                case BOEUF_BOURGUIGNON:
                    i.ajouterIngredient(EnumINGREDIENTS.VIANDE, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.VIN, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.LARDON, 10);
                    i.ajouterIngredient(EnumINGREDIENTS.CAROTTE, 5);
                    i.ajouterIngredient(EnumINGREDIENTS.CHAMPIGNON, 6);
                    i.ajouterIngredient(EnumINGREDIENTS.PATATE, 4);
                    break;
                case TARTIFLETTE:
                    i.ajouterIngredient(EnumINGREDIENTS.PATATE, 4);
                    i.ajouterIngredient(EnumINGREDIENTS.REBLOCHON, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.LARDON, 6);
                    i.ajouterIngredient(EnumINGREDIENTS.OIGNON, 3);
                    break;
                case SANDWICH:
                    i.ajouterIngredient(EnumINGREDIENTS.JAMBON, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.PAIN, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.TOMATE, 3);
                    break;
                case OMELETTE_COMPLETE:
                    i.ajouterIngredient(EnumINGREDIENTS.OEUF, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.LARDON, 4);
                    i.ajouterIngredient(EnumINGREDIENTS.CHAMPIGNON, 4);
                    i.ajouterIngredient(EnumINGREDIENTS.EMMENTAL, 1);
                    break;
                case CAKE_SALE_AU_JAMBON:
                    i.ajouterIngredient(EnumINGREDIENTS.JAMBON, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.OEUF, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.FARINE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.EMMENTAL, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.OLIVE, 5);
                    break;
                case VERRINE_SAUMON:
                    i.ajouterIngredient(EnumINGREDIENTS.SAUMON, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.CREME, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.CITRON, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.MOZZARELLA, 1);
                    break;
                case COOKIE:
                    i.ajouterIngredient(EnumINGREDIENTS.PATE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.SUCRE, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.CHOCOLAT, 2);
                    break;
                case FONDANTS_AU_CHOCOLAT:
                    i.ajouterIngredient(EnumINGREDIENTS.CHOCOLAT, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.FARINE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.OEUF, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.SUCRE, 1);
                    break;
                case CRUMBLE_AUX_POMMES:
                    i.ajouterIngredient(EnumINGREDIENTS.POMME, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.FARINE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.SUCRE, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.CITRON, 1);
                    break;
                case TARTE_AUX_CITRONS:
                    i.ajouterIngredient(EnumINGREDIENTS.FARINE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.OEUF, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.CITRON, 2);
                    i.ajouterIngredient(EnumINGREDIENTS.SUCRE, 2);
                    break;
                case BOEUF_WELLINGTON:
                    i.ajouterIngredient(EnumINGREDIENTS.VIANDE, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.CHAMPIGNON, 5);
                    i.ajouterIngredient(EnumINGREDIENTS.OEUF, 3);
                    i.ajouterIngredient(EnumINGREDIENTS.PATE, 1);
                    i.ajouterIngredient(EnumINGREDIENTS.BEURRE, 1);
                    break;
                default:
                    throw new AssertionError(nom.name());
            
        }
            r = new Recette(nom,i);
            return r;
	}

}