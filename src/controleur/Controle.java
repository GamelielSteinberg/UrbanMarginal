package controleur;

import vue.*;
import outils.connexion.*;

public class Controle implements AsyncResponse {

	private EntreeJeu frmEntreeJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private String typeJeu;
	private static int PORT = 6666;
	
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
			typeJeu = "serveur";
			ServeurSocket serveurSocket = new ServeurSocket(this, PORT);
			frmEntreeJeu.dispose();
			Arene frmArene = new Arene();
			frmArene.setVisible(true);
		} else {
			typeJeu = "client";
			ClientSocket clientSocket = new ClientSocket(this, info, PORT);
		}
	}
	
	public void evenementChoixJoueur(int num_perso, String pseudo) {
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
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
		case ("connexion"):
			if (typeJeu.equals("client")) {
				frmEntreeJeu.dispose();
				frmChoixJoueur = new ChoixJoueur(this);
				frmArene = new Arene();
				frmChoixJoueur.setVisible(true);
			}
			break;
		case ("reception"):
			
			break;
		case ("déconnexion"):
			
			break;
		}
	}

}
