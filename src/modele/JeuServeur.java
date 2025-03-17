package modele;

import java.util.ArrayList;
import java.util.Hashtable;
import controleur.Controle;
import controleur.Global;
import outils.connexion.*;

/**
 * Gestion du jeu côté serveur
 *
 */
public class JeuServeur extends Jeu implements Global {

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>();
	/**
	 * Dictionnaire de joueurs et leur connexion
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>();

	/**
	 * Constructeur
	 */
	public JeuServeur(Controle controle) {
		this.controle = controle;
	}

	@Override
	public void connexion(Connection connection) {
		lesJoueurs.put(connection, new Joueur());
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] infoArray = ((String) info).split(SEPARATEUR);
		switch (infoArray[0]) {
		case (SIGNATUREPSEUDO):
			lesJoueurs.get(connection).initPerso(infoArray[1], Integer.parseInt(infoArray[2]));
			break;
		}
	}

	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers tous les clients fais appel plusieurs fois à
	 * l'envoi de la classe Jeu
	 */
	public void envoi() {
	}

	/**
	 * Génération des murs
	 */
	public void constructionMurs() {
	}

}
