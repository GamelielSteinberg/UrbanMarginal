package controleur;

import vue.*;
import outils.connexion.*;
import modele.*;
import controleur.Global;

public class Controle implements AsyncResponse, Global {

	private EntreeJeu frmEntreeJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private Jeu leJeu;
	
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}

	/**
	 * Méthode de communication entre EntreeJeu et Controle
	 * 
	 * @param info
	 */
	public void evenementEntreeJeu(String info) {
		if (info.equals("serveur")) {
			ServeurSocket serveurSocket = new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			Arene frmArene = new Arene();
			frmArene.setVisible(true);
		} else {
			ClientSocket clientSocket = new ClientSocket(this, info, PORT);
		}
	}
	
	public void evenementChoixJoueur(int num_perso, String pseudo) {
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
		((JeuClient)leJeu).envoi(SIGNATUREPSEUDO + SEPARATEUR + pseudo + SEPARATEUR + num_perso);
	}

	/**
	 * Méthode de démarrage
	 * 
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch (ordre) {
		case (ORDRECONNEXION):
			if (!(leJeu instanceof JeuServeur)) {
				leJeu = new JeuClient(this);
				leJeu.connexion(connection);
				frmEntreeJeu.dispose();
				frmChoixJoueur = new ChoixJoueur(this);
				frmArene = new Arene();
				frmChoixJoueur.setVisible(true);
			}
			else {
				leJeu.connexion(connection);
			}
			break;
		case (ORDRERECEPTION):
			leJeu.reception(connection, info);			
			break;
		case (ORDREDECONNEXION):
			
			break;
		}
	}
	
	/**
	 * méthode pour communiquer une information à un Jeu
	 * @param connection
	 * @param info
	 */
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}

}
