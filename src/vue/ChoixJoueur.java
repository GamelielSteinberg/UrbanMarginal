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

public class ChoixJoueur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldPseudo;
	
	/**
	 * méthode pour le label gauche
	 */
	private void lblChoixGauche_Click() {
		System.out.println("Précédent");
	}
	
	/**
	 * méthode pour le label droit 
	 */
	private void lblChoixDroite_Click() {
		System.out.println("Suivant");
	}
	
	/**
	 * méthode pour le label GO
	 */
	private void lblGo_Click() {
		this.dispose();
		Arene frmArene = new Arene();
		frmArene.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setTitle("Choice");
		this.getContentPane().setPreferredSize(new Dimension(400,275));
		this.pack();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagePerso = new ImageIcon(getClass().getResource("/personnages/perso1marche1d1.gif"));
		JLabel lblPerso = new JLabel();
		lblPerso.setIcon(imagePerso);
		lblPerso.setBounds(178, 146, 48, 59);
		contentPane.add(lblPerso);
		
		//Creation du textField pour le pseudo
		txtfldPseudo = new JTextField();
		txtfldPseudo.setBounds(140, 245, 122, 20);
		contentPane.add(txtfldPseudo);
		txtfldPseudo.setColumns(10);
		
		//Creation du label pour la fleche de gauche
		JLabel lblChoixGauche = new JLabel("");
		lblChoixGauche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChoixGauche_Click();
			}
		});
		lblChoixGauche.setBounds(63, 146, 35, 47);
		contentPane.add(lblChoixGauche);
		
		//Creation du label pour la fleche de droite
		JLabel lblChoixDroite = new JLabel("");
		lblChoixDroite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblChoixDroite_Click();
			}
		});
		lblChoixDroite.setBounds(300, 146, 35, 47);
		contentPane.add(lblChoixDroite);
		
		//Creation du label pour le bouton GO
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_Click();
			}
		});
		lblGo.setBounds(310, 200, 71, 65);
		contentPane.add(lblGo);
		
		//Affichage de l'image de fond
		ImageIcon imageFond = new ImageIcon(getClass().getResource("/fonds/fondchoix.jpg"));
		JLabel lblFond = new JLabel();
		lblFond.setIcon(imageFond);
		lblFond.setBounds(0, 0, 400, 275);
		contentPane.add(lblFond);
	
	}
}

