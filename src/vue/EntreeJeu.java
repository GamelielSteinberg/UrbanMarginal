package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntreeJeu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldIP;

	/**
	 * méthode pour le bouton btnStart
	 */
	private void btnStart_Click() {
		this.dispose();
		Arene frmArene = new Arene();
		frmArene.setVisible(true);
	}
	
	/**
	 * méthode pour le bouton btnConnect
	 */
	private void btnConnect_Click() {
		this.dispose();
		ChoixJoueur frmChoixJoueur = new ChoixJoueur();
		frmChoixJoueur.setVisible(true);
	}
	
	/**
	 * méthode pour le bouton btnExit
	 */
	private void btnExit_Click() {
		System.exit(0);
	}
	
	/**
	 * Create the frame.
	 */
	public EntreeJeu() {
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Création des trois labels
		JLabel lblNewLabel = new JLabel("Start a server:");
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 36, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connect to an existing server:");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 75, 175, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP server:");
		lblNewLabel_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 100, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		
		//Creation du bouton Start
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart_Click();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStart.setBounds(200, 32, 89, 23);
		contentPane.add(btnStart);
		
		//Creation du bouton Connect 
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConnect_Click();
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConnect.setBounds(200, 96, 89, 23);
		contentPane.add(btnConnect);
		
		//Creation du bouton Exit
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit_Click();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(200, 133, 89, 23);
		contentPane.add(btnExit);
	
		txtfldIP = new JTextField();
		txtfldIP.setText("127.0.0.1");
		txtfldIP.setBounds(70, 97, 115, 20);
		contentPane.add(txtfldIP);
		txtfldIP.setColumns(10);
	}
}
