package vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import controleur.Global;
import modele.Mur;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import controleur.Controle;

public class Arene extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldChatEntree;
	private JTextArea txtareaChatHistory;
	private JPanel jpnMurs;
	private JPanel jpnJeu;
	private Controle controle;
	private boolean isClient;

	/**
	 * méthode permettant l'affichage des murs
	 * @param mur
	 */
	public void ajoutMurs(Object mur) {
		jpnMurs.add((JLabel) mur);
		jpnMurs.setVisible(true);
		jpnMurs.repaint();
	}

	/**
	 * getter jpnMurs
	 * @return
	 */
	public JPanel getjpnMurs() {
		return jpnMurs;
	}

	/**
	 * setter jpnMurs
	 * 
	 * @param jpnMurs
	 */
	public void setjpnMurs(JPanel jpnMurs) {
		this.jpnMurs.add(jpnMurs);
		this.jpnMurs.repaint();
	}

	/**
	 * méthode permettant d'afficher un JLabel dans l'arène (pour les joueurs et
	 * leur message)
	 * 
	 * @param jLabel
	 */
	public void ajoutJLabelJeu(JLabel jLabel) {
		jpnJeu.add(jLabel);
		jpnJeu.setVisible(true);
		jpnJeu.repaint();
	}

	/**
	 * getter jpnJeu
	 * 
	 * @return jpnJeu
	 */
	public JPanel getjpnJeu() {
		return jpnJeu;
	}

	/**
	 * setter jpnJeu
	 * 
	 * @param jpnJeu
	 */
	public void setjpnJeu(JPanel jpnJeu) {
		this.jpnJeu.removeAll();
		this.jpnJeu.add(jpnJeu);
		this.jpnJeu.repaint();
	}

	/**
	 * getter du texte du Chat
	 * 
	 * @return
	 */
	public String gettxtChat() {
		return this.txtareaChatHistory.getText();
	}

	/**
	 * setter du texte du Chat
	 * 
	 * @param txt
	 */
	public void settxtChat(String txt) {
		this.txtareaChatHistory.setText(txt);
		this.txtareaChatHistory.setCaretPosition(this.txtareaChatHistory.getDocument().getLength());
	}
	/**
	 * méthode permettant de remplacer l'historique du chat
	 * @param txt
	 */
	public void ajoutChat(String txt) {
		this.txtareaChatHistory.append(txt + "\r\n");
		this.txtareaChatHistory.setCaretPosition(this.txtareaChatHistory.getDocument().getLength());
	}
	/**
	 * méthode activée lors de la validation de la saisie d'un texte non vide
	 */
	private void validationSaisie() {
		controle.evenementArene(VALIDATIONSAISIE, txtfldChatEntree.getText());
		txtfldChatEntree.setText("");
	}

	/**
	 * Create the frame
	 * @param controle
	 * @param isClient
	 */
	public Arene(Controle controle, boolean isClient) {
		this.controle = controle;
		this.isClient = isClient;
		setTitle("Arena");
		this.getContentPane().setPreferredSize(new Dimension(800, 781));
		this.pack();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 820);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, 800, 600);
		jpnJeu.setOpaque(false);
		contentPane.add(jpnJeu);
		jpnJeu.setLayout(null);
		jpnJeu.setVisible(true);

		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, 800, 600);
		jpnMurs.setOpaque(false);
		contentPane.add(jpnMurs);
		jpnMurs.setLayout(null);
		jpnMurs.setVisible(true);

		ImageIcon imageFond = new ImageIcon(getClass().getResource(FONDARENE));
		JLabel lblFond = new JLabel();
		lblFond.setIcon(imageFond);
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 601, 793, 180);
		contentPane.add(scrollPane);

		txtareaChatHistory = new JTextArea();
		txtareaChatHistory.setColumns(10);
		txtareaChatHistory.setEditable(false);
		scrollPane.setViewportView(txtareaChatHistory);

		if (isClient) {
			txtfldChatEntree = new JTextField();
			txtfldChatEntree.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (txtfldChatEntree.getText() != "" && txtfldChatEntree.getText().split(" ") != null) {
							validationSaisie();
						}
					}
				}
			});
			scrollPane.setColumnHeaderView(txtfldChatEntree);
			txtfldChatEntree.setColumns(10);
		}

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
