package modele;

import controleur.Global;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

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
	 * getter sur orientation
	 * 
	 * @return
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * getter sur pseudo
	 * 
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
		this.boule = new Boule(this.jeuServeur);
		message.setFont(new Font("Dialog", Font.BOLD, 8));
		message.setForeground(Color.BLACK);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		premierePosition(lesMurs, lesJoueurs);
		jeuServeur.ajoutJLabelJeuArene(jLabel);
		jeuServeur.ajoutJLabelJeuArene(message);
		jeuServeur.ajoutJLabelJeuArene(boule.jLabel);
		affiche("marche", etape);

	}

	/**
	 * Calcul de la première position aléatoire du joueur (sans chevaucher un autre
	 * joueur ou un mur)
	 * 
	 * @param lesMurs
	 * @param lesJoueurs
	 */
	private void premierePosition(ArrayList<Mur> lesMurs, Collection<Joueur> lesJoueurs) {
		jLabel.setBounds(0, 0, LARGEURPERSO, HAUTEURPERSO);
		Collection<Objet> objetLesJoueurs = new ArrayList<Objet>();
		objetLesJoueurs.addAll(lesJoueurs);
		Collection<Objet> objetLesMurs = new ArrayList<Objet>();
		objetLesMurs.addAll(lesMurs);
		do {
			super.posX = (int) Math.round(Math.random() * (LARGEURARENE - LARGEURPERSO));
			super.posY = (int) Math.round(Math.random() * (HAUTEURARENE - HAUTEURPERSO - HAUTEURMESSAGE));
		} while (super.toucheCollectionObjets(objetLesJoueurs) != null
				|| super.toucheCollectionObjets(objetLesMurs) != null);
	}

	/**
	 * Affiche le personnage et son message
	 * 
	 * @param etat
	 * @param etape
	 */
	public void affiche(String etat, int etape) {
		ImageIcon imagePerso = new ImageIcon(
				getClass().getResource(CHEMINPERSOS + numPerso + etat + etape + "d" + orientation + ".gif"));
		int largeur = imagePerso.getIconWidth();
		int hauteur = imagePerso.getIconHeight();
		jLabel.setBounds(posX, posY, largeur, hauteur);
		jLabel.setIcon(imagePerso);
		message.setBounds(posX - 10, posY + hauteur + 1, largeur + 20, 8);
		message.setText(pseudo + ": " + vie);
		jeuServeur.envoiJeuATous();
	}

	/**
	 * Gère une action reçue et qu'il faut afficher (déplacement, tire de boule...)
	 * 
	 * @param action
	 * @param lesJoueurs
	 * @param lesMurs
	 */
	public void action(int action, Collection<Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		if (!estMort()) {
			if (action != KeyEvent.VK_SPACE) {
				switch (action) {
				case (KeyEvent.VK_LEFT):
					this.posX -= PAS;
					if (isInvalid(lesJoueurs, lesMurs)) {
						this.posX += PAS;
					}
					break;
				case (KeyEvent.VK_RIGHT):
					this.posX += PAS;
					if (isInvalid(lesJoueurs, lesMurs)) {
						this.posX -= PAS;
					}
					break;
				case (KeyEvent.VK_UP):
					this.posY -= PAS;
					if (isInvalid(lesJoueurs, lesMurs)) {
						this.posY += PAS;
					}
					break;
				case (KeyEvent.VK_DOWN):
					this.posY += PAS;
					if (isInvalid(lesJoueurs, lesMurs)) {
						this.posY -= PAS;
					}
					break;
				}
				deplace(action);
				affiche(MARCHE, etape);
			} else {
				if (!this.boule.jLabel.isVisible()) {
					this.boule.tireBoule(this, lesMurs);
				}
			}
		}
	}

	/**
	 * Gère le déplacement du personnage
	 */
	private void deplace(int mouvement) {
		etape += 1;
		if (etape > NOMBREETAPESMARCHE) {
			etape = 1;
		}
		if ((orientation == 0 && mouvement == KeyEvent.VK_RIGHT)
				|| (orientation == 1 && mouvement == KeyEvent.VK_LEFT)) {
			orientation = Math.abs(orientation - 1);
		}
	}

	private boolean isInvalid(Collection<Joueur> lesJoueurs, ArrayList<Mur> lesMurs) {
		Collection<Objet> objetLesJoueurs = new ArrayList<Objet>();
		Collection<Objet> objetLesMurs = new ArrayList<Objet>();
		objetLesJoueurs.addAll(lesJoueurs);
		objetLesMurs.addAll(lesMurs);
		if (super.toucheCollectionObjets(objetLesJoueurs) != null || super.toucheCollectionObjets(objetLesMurs) != null
				|| this.posX < 0 || this.posY < 0 || (this.posX + this.jLabel.getWidth()) > LARGEURARENE
				|| (this.posY + this.jLabel.getHeight() > HAUTEURARENE)) {
			return true;
		}
		return false;
	}

	/**
	 * Gain de points de vie après avoir touché un joueur
	 */
	public void gainVie() {
		vie += GAIN;
		affiche(MARCHE, etape);
	}

	/**
	 * Perte de points de vie après avoir été touché
	 */
	public void perteVie() {
		vie -= PERTE;
		if (vie < 0) {
			vie = 0;
			affiche(MARCHE, etape);
		}
	}

	/**
	 * vrai si la vie est à 0
	 * 
	 * @return true si vie = 0
	 */
	public Boolean estMort() {
		if (vie > 0) {
			return false;
		}
		return true;
	}

	/**
	 * Le joueur se déconnecte et disparait
	 */
	public void departJoueur() {
		if (super.jLabel != null) {
			super.jLabel.setVisible(false);
			this.message.setVisible(false);
			this.boule.jLabel.setVisible(false);
			jeuServeur.envoiJeuATous();
		}
	}

}
