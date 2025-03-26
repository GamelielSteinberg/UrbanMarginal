package modele;

import controleur.Controle;
import outils.connexion.*;
import javax.swing.JPanel;
import controleur.Global;

/**
 * Gestion du jeu côté client
 *
 */
public class JeuClient extends Jeu implements Global {

	private Connection connection;
	private boolean mursOk;

	/**
	 * Constructeur
	 */
	public JeuClient(Controle controle) {
		super.controle = controle;
		this.mursOk = false;
	}

	@Override
	public void connexion(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void reception(Connection connection, Object info) {
		if (info instanceof JPanel) {
			if (!mursOk) {
				controle.evenementJeuClient(AJOUTPANELMURS, info);
				this.mursOk = true;
			}
			else {
				controle.evenementJeuClient(AJOUTPANELJEU, info);
			}
		}
	}

	/**
	 * Envoi d'une information vers le serveur fais appel une fois à l'envoi dans la
	 * classe Jeu
	 */
	public void envoi(String info) {
		super.envoi(this.connection, info);
	}

	@Override
	public void deconnexion() {

	}
}
