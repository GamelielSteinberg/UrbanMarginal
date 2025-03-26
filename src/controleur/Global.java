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
	public static final String CONNEXION = "connexion";
	/**
	 * message pour l'ordre de réception
	 */
	public static final String RECEPTION = "reception";
	/**
	 * message pour l'ordre de déconnexion
	 */
	public static final String DECONNEXION = "déconnexion";
	/**
	 * message pour l'ordre d'ajout d'un mur
	 */
	public static final String AJOUTMUR = "ajout mur";
	/**
	 * message pour l'ordre d'ajout du panel des murs
	 */
	public static final String AJOUTPANELMURS = "ajout panel murs";
	/**
	 * message pour l'ordre d'ajout d'un JLabel dans l'Arene
	 */
	public static final String AJOUTLBLJEU = "ajout jlabel jeu";
	/**
	 * message pour l'ordre d'ajout du panel des joueurs
	 */
	String AJOUTPANELJEU = "ajout panel jeu";
	/**
	 * numéro du port
	 */
	public static final int PORT = 6666;
	
	public static final int XMINMUR = 0;
	public static final int XMAXMUR = 766;
	public static final int YMINMUR = 0;
	public static final int YMAXMUR = 565;
	public static final String IMAGEMUR = "/murs/mur.gif";

	public static final int LARGEURMUR = 34;
	public static final int HAUTEURMUR = 35;
	
	public static final int XMINJOUEUR = 0;
	public static final int XMAXJOUEUR = 761;
	public static final int YMINJOUEUR = 0;
	public static final int YMAXJOUEUR = 554;
		/**
	 * hauteur du personnage
	 */
	int HAUTEURPERSO = 44;
	/**
	 * largeur du personnage
	 */
	int LARGEURPERSO = 39;
	/**
	 * hauteur du message
	 */
	int HAUTEURMESSAGE = 8;
	int LARGEURARENE = 800;
	int HAUTEURARENE = 600;
}
