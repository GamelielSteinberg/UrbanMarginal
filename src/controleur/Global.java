package controleur;

public interface Global {
	/**
	 * vie de départ pour tous les joueurs
	 */
	public static final int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	public static final int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	public static final int PERTE = 2 ;
	/**
	 * nombre de personnages différents
	 */
	public static final int NOMBREPERSOS = 3;
	/**
	 * chemin vers le fond de ChoixJoueur
	 */
	public static final String FONDCHOIX = "/fonds/fondchoix.jpg";
	/**
	 * Chemin vers le fond de l'arène
	 */
	public static final String FONDARENE = "/fonds/fondarene.jpg";
	/**
	 * chemin vers les personnages
	 */
	public static final String CHEMINPERSOS = "/personnages/perso";
	/**
	 * séparateur
	 */
	public static final String SEPARATEUR = "~";
	/**
	 * signature pseudo
	 */
	public static final String SIGNATUREPSEUDO = "pseudo";
	/**
	 * message pour l'ordre de connexion
	 */
	public static final String ORDRECONNEXION = "connexion";
	/**
	 * message pour l'ordre de réception
	 */
	public static final String ORDRERECEPTION = "réception";
	/**
	 * message pour l'ordre de déconnexion
	 */
	public static final String ORDREDECONNEXION = "déconnexion";
	/**
	 * numéro du port
	 */
	public static final int PORT = 6666;
}
