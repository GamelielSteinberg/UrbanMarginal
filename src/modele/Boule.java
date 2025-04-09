package modele;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import controleur.Global;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Gestion de la boule
 *
 */
public class Boule extends Objet implements Global, Runnable {

	/**
	 * instance de JeuServeur pour la communication
	 */
	private JeuServeur jeuServeur;
	private ArrayList<Objet> objetLesMurs;
	private Joueur joueurAttaquant;
	private int orientation;

	/**
	 * Constructeur
	 */
	public Boule(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		super.jLabel = new JLabel();
		super.jLabel.setVisible(false);
		ImageIcon imageBoule = new ImageIcon(getClass().getResource(CHEMINBOULE));
		super.jLabel.setIcon(imageBoule);
		super.posX = 0;
		super.posY = 0;
		super.jLabel.setBounds(this.posX, this.posY, LARGEURBOULE, HAUTEURBOULE);
	}

	/**
	 * Tire d'une boule
	 */
	public void tireBoule(Joueur joueurAttaquant, ArrayList<Mur> lesMurs) {
		this.joueurAttaquant = joueurAttaquant;
		this.objetLesMurs = new ArrayList<Objet>();
		this.objetLesMurs.addAll(lesMurs);
		if (joueurAttaquant.getOrientation() == 0) {
			this.orientation = -1;
			super.posX = joueurAttaquant.getPosX() - LARGEURBOULE - 1;
		} else {
			this.orientation = 1;
			super.posX = joueurAttaquant.getPosX() + joueurAttaquant.jLabel.getWidth() + 1;
		}
		super.posY = joueurAttaquant.getPosY() + (joueurAttaquant.jLabel.getHeight() / 2);
		new Thread(this).start();
	}

	public void run() {
		jeuServeur.envoi(NUMFIGHT);
		;
		this.joueurAttaquant.affiche(MARCHE, 1);
		super.jLabel.setVisible(true);
		Joueur victime = null;
		int lePas = orientation * PAS;
		do {
			super.posX += lePas;
			super.jLabel.setBounds(super.posX, super.posY, LARGEURBOULE, HAUTEURBOULE);
			jeuServeur.envoiJeuATous();
			Collection<Objet> lesJoueurs = new ArrayList<Objet>();
			lesJoueurs.addAll(jeuServeur.getCollectionJoueur());
			victime = (Joueur) toucheCollectionObjets(lesJoueurs);
		} while (super.posX >= 0 && super.posX <= LARGEURARENE && victime == null
				&& toucheCollectionObjets(objetLesMurs) == null);
		if (victime != null) {
			if (!victime.estMort()) {
				victime.perteVie();
				joueurAttaquant.gainVie();
				for (int i = 1; i < 3; i++) {
					victime.affiche(TOUCHE, i);
					pause(80, 0);
				}
				victime.affiche(MARCHE, 1);

				if (victime.estMort()) {
					for (int i = 1; i < 3; i++) {
						victime.affiche(MORT, i);
						pause(80, 0);
						jeuServeur.envoi(NUMDEATH);
					}
				} else {
					jeuServeur.envoi(NUMHURT);
				}
			}
		}
		super.jLabel.setVisible(false);
		jeuServeur.envoiJeuATous();
	}

	private void pause(long ms, int ns) {
		try {
			Thread.sleep(ms, ns);
		} catch (Exception e) {
		}
	}
}
