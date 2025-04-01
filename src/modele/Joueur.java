package modele;

import controleur.Global;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

/**
 * Gestion des joueurs
 *
 */
public class Joueur extends Objet implements Global {

	/**
	 * pseudo saisi
	 */
	private String pseudo;
	/**
	 * n° correspondant au personnage (avatar) pour le fichier correspondant
	 */
	private int numPerso;
	/**
	 * instance de JeuServeur pour communiquer avec lui
	 */
	private JeuServeur jeuServeur;
	/**
	 * numéro d'�tape dans l'animation (de la marche, touché ou mort)
	 */
	private int etape;
	/**
	 * la boule du joueur
	 */
	private Boule boule;
	/**
	 * vie restante du joueur
	 */
	private int vie;
	/**
	 * tourné vers la gauche (0) ou vers la droite (1)
	 */
	private int orientation;
	/**
	 * label pour le texte sous le joueur
	 */
	private JLabel message;
	/**
	 * getter sur pseudo
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * Constructeur
	 */
	public Joueur(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		this.vie = MAXVIE;
		this.etape = 1;
		this.orientation = 1;
	}

	/**
	 * Initialisation d'un joueur (pseudo et numéro, calcul de la 1ère position,
	 * affichage, création de la boule)
	 */
	public void initPerso(String pseudo, int num_perso, ArrayList<Mur> lesMurs, Collection<Joueur> lesJoueurs) {
		this.pseudo = pseudo;
		this.numPerso = num_perso;
		System.out.println("joueur " + this.pseudo + " - num perso " + numPerso + " créé");
		this.jLabel = new JLabel();
		this.message = new JLabel();
		message.setFont(new Font("Dialog", Font.BOLD, 8));
		message.setForeground(Color.BLACK);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		premierePosition(lesMurs, lesJoueurs);
		jeuServeur.ajoutJLabelJeuArene(jLabel);
		jeuServeur.ajoutJLabelJeuArene(message);
		affiche("marche", etape);

	}

	/**
	 * Calcul de la première position aléatoire du joueur (sans chevaucher un autre
	 * joueur ou un mur)
	 */
	private void premierePosition(ArrayList<Mur> lesMurs, Collection<Joueur> lesJoueurs) {
		jLabel.setBounds(0, 0, LARGEURPERSO, HAUTEURPERSO);
		do {
			posX = (int) Math.round(Math.random() * (LARGEURARENE - LARGEURPERSO));
			posY = (int) Math.round(Math.random() * (HAUTEURARENE - HAUTEURPERSO - HAUTEURMESSAGE));
		} while (this.toucheJoueur(lesJoueurs) || this.toucheMur(lesMurs));
	}

	/**
	 * Affiche le personnage et son message
	 */
	public void affiche(String etat, int etape) {
		ImageIcon imagePerso = new ImageIcon(getClass().getResource(CHEMINPERSOS + numPerso + "marche" + etape + "d" + orientation + ".gif"));
		int largeur = imagePerso.getIconWidth();
		int hauteur = imagePerso.getIconHeight();
		jLabel.setBounds(posX, posY, largeur, hauteur);//posX + largeur, posY + hauteur);
		jLabel.setIcon(imagePerso);
		message.setBounds(posX - 10, posY + hauteur + 1, largeur + 20, 8);
		message.setText(pseudo + ": " + vie);
		jeuServeur.envoiJeuATous();
	}

	/**
	 * Gère une action reçue et qu'il faut afficher (déplacement, tire de boule...)
	 */
	public void action() {
	}

	/**
	 * Gère le déplacement du personnage
	 */
	private void deplace() {
	}

	/**
	 * Contrôle si le joueur touche un des autres joueurs
	 * 
	 * @return true si deux joueurs se touchent
	 */
	private Boolean toucheJoueur(Collection<Joueur> lesJoueurs) {
		for (Joueur unJoueur : lesJoueurs) {
			if (!this.equals(unJoueur)) {
				if (super.toucheObjet(unJoueur)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Gain de points de vie après avoir touché un joueur
	 */
	public void gainVie() {
	}

	/**
	 * Perte de points de vie après avoir été touché
	 */
	public void perteVie() {
	}

	/**
	 * Contrôle si le joueur touche un des murs
	 * 
	 * @return true si un joueur touche un mur
	 */
	private Boolean toucheMur(ArrayList<Mur> lesMurs) {
		for (Mur unMur : lesMurs) {
			if (super.toucheObjet(unMur)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * vrai si la vie est à 0
	 * 
	 * @return true si vie = 0
	 */
	public Boolean estMort() {
		return null;
	}

	/**
	 * Le joueur se déconnecte et disparait
	 */
	public void departJoueur() {
	}

}
