package modele;

import controleur.Global;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Gestion des murs
 *
 */
public class Mur extends Objet implements Global {
	//private JLabel jLabel;

	/**
	 * Constructeur
	 */
	public Mur() {
		this.posX = (int) (Math.random() * (XMAXMUR - XMINMUR + 1) + XMINMUR);
		this.posY = (int) (Math.random() * (YMAXMUR - YMINMUR + 1) + YMINMUR);
		ImageIcon imageFond = new ImageIcon(getClass().getResource(IMAGEMUR));
		jLabel = new JLabel();
		jLabel.setIcon(imageFond);
		jLabel.setBounds(posX, posY, LARGEURMUR, HAUTEURMUR);
	}
	
	public JLabel getjLabel() {
		return jLabel;
	}
}
