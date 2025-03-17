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

public class Arene extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldChatEntree;


	/**
	 * Create the frame.
	 */
	public Arene() {
		setTitle("Arena");
		this.getContentPane().setPreferredSize(new Dimension(800,781));
		this.pack();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 820);
		contentPane = new JPanel();		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		ImageIcon imageFond = new ImageIcon(getClass().getResource(FONDARENE));
		JLabel lblFond = new JLabel();
		lblFond.setIcon(imageFond);
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 601, 793, 180);
		contentPane.add(scrollPane);
		
		JTextArea txtareaChatHistory = new JTextArea();
		txtareaChatHistory.setColumns(10);
		scrollPane.setViewportView(txtareaChatHistory);
		
		txtfldChatEntree = new JTextField();
		scrollPane.setColumnHeaderView(txtfldChatEntree);
		txtfldChatEntree.setColumns(10);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
