package metier.PackageIngredient;

/**
 * Represente un ingredient
 */
public class Ingredients {
       
	private int nombre;
	private EnumINGREDIENTS nom;
       
	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public EnumINGREDIENTS getNom() {
		return this.nom;
	}

	/**
	 * Construit l'ingredient
	 * @param nom
	 * @param nombre
	 */
	public Ingredients(EnumINGREDIENTS nom, int nombre) {
            this.nom = nom;
            this.nombre = nombre;
	}
        
        @Override
        public boolean equals(Object o) {
            Ingredients ingredients = (Ingredients) o;
            return (this.nombre == ingredients.nombre && this.nom == ingredients.nom);
        }

}