package modele;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Collection;

/**
 * Informations communes � tous les objets (joueurs, murs, boules)
 * permet de m�moriser la position de l'objet et de g�rer les  collisions
 *
 */
public abstract class Objet {

	/**
	 * position X de l'objet
	 */
	protected Integer posX ;
	/**
	 * position Y de l'objet
	 */
	protected Integer posY ;
	/**
	 * JLabel de l'objet
	 */
	protected JLabel jLabel;
	/**
	 * getter sur posX
	 * @return
	 */
	public int getPosX() {
		return this.posX;
	}
	/**
	 * getter sur posY
	 * @return
	 */
	public int getPosY() {
		return this.posY;
	}
	/**
	 * contr�le si l'objet actuel touche l'objet pass� en param�tre
	 * @param objet contient l'objet � contr�ler
	 * @return true si les 2 objets se touchent
	 */
	public Boolean toucheObjet (Objet objet) {
		if (objet.jLabel==null || objet.jLabel==null) {
			return false ;
		}else{
			return(this.posX + this.jLabel.getWidth() > objet.posX &&
				this.posX < objet.posX + objet.jLabel.getWidth() && 
				this.posY + this.jLabel.getHeight() > objet.posY &&
				this.posY < objet.posY + objet.jLabel.getHeight()) ;
		}
	}
	public Objet toucheCollectionObjets(Collection<Objet> lesObjets) {
		for (Objet unObjet : lesObjets) {
			if (!this.equals(unObjet)) {
				if (toucheObjet(unObjet)) {
					return unObjet;
				}
			}
		}
		return null;
	}
	/**
	 * setter sur posX et posY pour le test unitaire
	 * @param posX
	 */
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
}
