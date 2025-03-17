package modele;

import controleur.Controle;
import outils.connexion.*;

/**
 * Gestion du jeu côté client
 *
 */
public class JeuClient extends Jeu {
	
	private Connection connection;
	
	/**
	 * Constructeur
	 */
	public JeuClient(Controle controle) {
		this.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void reception(Connection connection, Object info) {
	}
	
	/**
	 * Envoi d'une information vers le serveur
	 * fais appel une fois à l'envoi dans la classe Jeu
	 */
	public void envoi(String info) {
		super.envoi(this.connection, info);
	}
	
	@Override
	public void deconnexion() {
		
	}
}
