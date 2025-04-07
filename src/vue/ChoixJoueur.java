package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controleur.Controle;
import controleur.Global;
import outils.son.Son;

public class ChoixJoueur extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldPseudo;
	JLabel lblPersonnage;
	private Controle controle;
	private int num_perso;
	private Son welcome, precedent, suivant, go;

	/**
	 * méthode pour le label gauche
	 */
	private void lblChoixGauche_Click() {
		num_perso -= 1;
		if (num_perso == 0) {
			num_perso = NOMBREPERSOS;
		}
		affichePerso();
		precedent.play();
		System.out.println("Précédent");
	}

	/**
	 * méthode pour le label droit
	 */
	private void lblChoixDroite_Click() {
		num_perso += 1;
		if (num_perso > NOMBREPERSOS) {
			num_perso = 1;
		}
		affichePerso();
		suivant.play();
		System.out.println("Suivant");
	}

	/**
	 * méthode pour le label GO
	 */
	private void lblGo_Click() {
		if (txtfldPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
			txtfldPseudo.requestFocus();
		}
		else {
			go.play();
			controle.evenementChoixJoueur(num_perso, txtfldPseudo.getText());
		}
	}

	/**
	 * méthode pour afficher le personnage
	 */
	private void affichePerso() {
		ImageIcon imagePerso = new ImageIcon(getClass().getResource(CHEMINPERSOS + num_perso + "marche1d1.gif"));
		lblPersonnage.setIcon(imagePerso);
	}
	
	/**
	 * méthode pour modifier le curseur au survol d'une zone cliquable
	 */
	private void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * méthode pour que le cursor reprenne son apparence d'origine en sortant d'une zone cliquable
	 */
	private void sourisNormale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle) {
		setTitle("Choice");
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPersonnage = new JLabel();
		lblPersonnage.setBounds(140, 116, 122, 118);
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPersonnage);

		// Creation du textField pour le pseudo
		txtfldPseudo = new JTextField();
		txtfldPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		txtfldPseudo.setBounds(140, 245, 122, 20);
		contentPane.add(txtfldPseudo);
		txtfldPseudo.setColumns(10);

		// Creation du label pour la fleche de gauche
		JLabel lblChoixGauche = new JLabel("");
		lblChoixGauche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChoixGauche_Click();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblChoixGauche.setBounds(63, 146, 35, 47);
		contentPane.add(lblChoixGauche);

		// Creation du label pour la fleche de droite
		JLabel lblChoixDroite = new JLabel("");
		lblChoixDroite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChoixDroite_Click();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblChoixDroite.setBounds(300, 146, 35, 47);
		contentPane.add(lblChoixDroite);

		// Creation du label pour le bouton GO
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_Click();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblGo.setBounds(310, 200, 71, 65);
		contentPane.add(lblGo);

		// Affichage de l'image de fond
		ImageIcon imageFond = new ImageIcon(getClass().getResource(FONDCHOIX));
		JLabel lblFond = new JLabel();
		lblFond.setIcon(imageFond);
		lblFond.setBounds(0, 0, 400, 275);
		contentPane.add(lblFond);

		this.controle = controle;
		this.num_perso = 1;
		affichePerso();
		welcome = new Son(getClass().getResource(SONWELCOME));
		precedent = new Son(getClass().getResource(SONPRECEDENT));
		suivant = new Son(getClass().getResource(SONSUIVANT));
		go = new Son(getClass().getResource(SONGO));
		welcome.play();
	}
}
