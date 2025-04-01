package modele;

import java.util.ArrayList;
import java.util.Hashtable;
import controleur.Controle;
import controleur.Global;
import outils.connexion.*;
import javax.swing.JLabel;

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
		super.controle = controle;
	}

	@Override
	public void connexion(Connection connection) {
		lesJoueurs.put(connection, new Joueur(this));
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] infoArray = ((String) info).split(SEPARATEUR);
		switch (infoArray[0]) {
		case (SIGNATUREPSEUDO):
			controle.evenementJeuServeur(AJOUTPANELMURS, connection);
			String pseudo = infoArray[1];
			int numPerso = Integer.parseInt(infoArray[2]);
			this.lesJoueurs.get(connection).initPerso(pseudo, numPerso, lesMurs, lesJoueurs.values());
			String messageConnexion = "***" + pseudo + " vient de se connecter***";
			controle.evenementJeuServeur(AJOUTPHRASE, messageConnexion);
			break;
		case (SIGNATURECHAT):
			String pseudoChat = lesJoueurs.get(connection).getPseudo();
			String aEnvoyer = pseudoChat + SEPARATEURCHAT + infoArray[1];
			controle.evenementJeuServeur(AJOUTPHRASE, aEnvoyer);
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
	public void envoi(Object info) {
		for (Connection uneConnection : lesJoueurs.keySet()) {
			super.envoi(uneConnection, info);
		}
	}

	/**
	 * Génération des murs
	 */
	public void constructionMurs() {
		for (int i = 0; i<20; i++) {
			lesMurs.add(new Mur());
			controle.evenementJeuServeur(AJOUTMUR, lesMurs.get(i).getjLabel());
		}
	}
	
	/**
	 * ajout d'un JLabel dans l'Arene
	 * @param jLabel
	 */
	public void ajoutJLabelJeuArene(JLabel jLabel) {
		controle.evenementJeuServeur(AJOUTLBLJEU, jLabel);
	}
	public void envoiJeuATous() {
		for (Connection uneConnection : lesJoueurs.keySet()) {
			controle.evenementJeuServeur(AJOUTPANELJEU, uneConnection);
		}
	}
}
