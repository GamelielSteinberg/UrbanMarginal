package controleur;

import vue.*;
import outils.connexion.*;
import modele.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
			new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene(this, false);
			((JeuServeur) leJeu).constructionMurs();
			frmArene.setVisible(true);
		} else {
			new ClientSocket(this, info, PORT);
		}
	}
	
	public void evenementChoixJoueur(int num_perso, String pseudo) {
		((JeuClient)this.leJeu).envoi(SIGNATUREPSEUDO + SEPARATEUR + pseudo + SEPARATEUR + num_perso);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
	}
	
	public void evenementJeuServeur(String ordre, Object info) {
		switch (ordre) {
		case (AJOUTMUR):
			frmArene.ajoutMurs(info);
			break;
		case (AJOUTPANELMURS):
			leJeu.envoi((Connection)info, frmArene.getjpnMurs());
			break;
		case (AJOUTLBLJEU):
			frmArene.ajoutJLabelJeu((JLabel)info);
			break;
		case (AJOUTPANELJEU):
			leJeu.envoi((Connection)info, frmArene.getjpnJeu());
			break;
		case (AJOUTPHRASE):
			frmArene.ajoutChat((String)info);
			((JeuServeur)leJeu).envoi(frmArene.gettxtChat());
			break;
		}
	}
	
	public void evenementJeuClient(String ordre, Object info) {
		switch (ordre) {
		case (AJOUTPANELMURS):
			frmArene.setjpnMurs((JPanel)info);
			break;
		case (AJOUTPANELJEU):
			frmArene.setjpnJeu((JPanel)info);
			break;
		case (MODIFCHAT):
			frmArene.settxtChat((String)info);
			break;
		}
	}
	
	public void evenementArene(String ordre, Object info) {
		switch (ordre) {
		case (VALIDATIONSAISIE):
			((JeuClient)leJeu).envoi(SIGNATURECHAT + SEPARATEUR + info);
			break;
		}
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
		case (CONNEXION):
			if (!(leJeu instanceof JeuServeur)) {
				leJeu = new JeuClient(this);
				leJeu.connexion(connection);
				frmEntreeJeu.dispose();
				frmChoixJoueur = new ChoixJoueur(this);
				frmArene = new Arene(this, true);
				frmChoixJoueur.setVisible(true);
			}
			else {
				leJeu.connexion(connection);
			}
			break;
		case (RECEPTION):
			leJeu.reception(connection, info);			
			break;
		case (DECONNEXION):
			
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
