package ihm.packageFenetre.FenetreJeu;

import ihm.packageFenetre.Fenetre;
import javafx.scene.image.ImageView;

/**
 *
 * @author antho
 */
public abstract class ElementMap {
    protected ImageView caseImg;
    protected FJeu fenetreMap;

    public Fenetre getFenetreMap() {
        return fenetreMap;
    }
    
    public ElementMap(FJeu fJeu) {
        this.fenetreMap = fJeu;
        this.caseImg = new ImageView();
    }
    
    protected abstract void displayImage();

    public ImageView getCaseImg() {
        return caseImg;
    }

    public void setCaseImg(ImageView caseImg) {
        this.caseImg = caseImg;
    }
}
