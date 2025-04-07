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
	 * nombre de pixels parcourus par déplacement
	 */
	public static final int PAS = 10;
	/**
	 * nombre de personnages différents
	 */
	public static final int NOMBREPERSOS = 3;
	public static final int NOMBREETAPESMARCHE = 4;
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
	 * chemin vers l'image de la boule
	 */
	public static final String CHEMINBOULE = "/boules/boule.gif";
	/**
	 * séparateur
	 */
	public static final String SEPARATEUR = "~";
	/**
	 * séparateur tchat
	 */
	String SEPARATEURCHAT = " > ";
	/**
	 * signature pseudo
	 */
	public static final String SIGNATUREPSEUDO = "pseudo";
	/**
	 * signature ordre envoi message tchat
	 */
	String SIGNATURECHAT = "tchat";
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
	 * message pour l'envoi d'un texte dans  le chat
	 */
	String VALIDATIONSAISIE = "validation saisie entree chat";
	/**
	 * message pour l'ordre d'ajout d'une phrase dans le tchat
	 */
	String AJOUTPHRASE = "ajout phrase";
	/**
	 * message pour l'ordre de modifier le chat d'un jeu en particulier
	 */
	String MODIFCHAT = "modif tchat";
	/**
	 * message pour l'ordre d'appliquer une action à un joueur
	 */
	String ACTION = "action";
	/**
	 * message pour l'ordre de jouer un son
	 */
	String SON = "son";
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
	int LARGEURBOULE = 17;
	int HAUTEURBOULE = 17;
	/**
	 * hauteur du message
	 */
	int HAUTEURMESSAGE = 8;
	int LARGEURARENE = 800;
	int HAUTEURARENE = 600;
	/**
	 * états possibles d'un joueur
	 */
	String MARCHE = "marche";
	String TOUCHE = "touche";
	String MORT = "mort";
	/**
	 * chemins vers les sons de ChoixJoueur
	 */
	String SONWELCOME = "/sons/welcome.wav";
	String SONPRECEDENT = "/sons/precedent.wav";
	String SONSUIVANT = "/sons/suivant.wav";
	String SONGO = "/sons/go.wav";
	/**
	 * chemins vers les sons de l'Arene
	 */
	String[] TABLEAUSONSARENE = {"/sons/fight.wav", "/sons/hurt.wav", "/sons/death.wav"};
	Integer NUMFIGHT = 0;
	Integer NUMHURT = 1;
	Integer NUMDEATH = 2;
}
