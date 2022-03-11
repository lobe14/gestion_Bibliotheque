package examen.s1m1.uasz.sn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificationLivre {

	private JFrame modifie_livre;
	private JTextField titreL;
	private JTextField auteurL;
	private JTextField nombrepL;
	private JTextField nombreeL;
	private JTextField etatL;
	private JTextField codeL;
	private JTextField emplacementL;
	private JTextField datepL;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificationMbre modLivre = new ModificationMbre();
//					modLivre.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ModificationLivre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modifie_livre = new JFrame();
		modifie_livre.setBackground(Color.GREEN);
		modifie_livre.setBounds(300, 100, 402, 460);
		modifie_livre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifie_livre.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mofication d'un document");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(89, 11, 248, 28);
		modifie_livre.getContentPane().add(lblNewLabel);
		
		titreL = new JTextField();
		titreL.setFont(new Font("Tahoma", Font.BOLD, 12));
		titreL.setColumns(10);
		titreL.setBounds(192, 106, 163, 20);
		modifie_livre.getContentPane().add(titreL);
		
		auteurL = new JTextField();
		auteurL.setFont(new Font("Tahoma", Font.BOLD, 12));
		auteurL.setColumns(10);
		auteurL.setBounds(192, 146, 163, 20);
		modifie_livre.getContentPane().add(auteurL);
		
		nombrepL = new JTextField();
		nombrepL.setFont(new Font("Tahoma", Font.BOLD, 12));
		nombrepL.setColumns(10);
		nombrepL.setBounds(192, 188, 163, 23);
		modifie_livre.getContentPane().add(nombrepL);
		
		nombreeL = new JTextField();
		nombreeL.setFont(new Font("Tahoma", Font.BOLD, 12));
		nombreeL.setColumns(10);
		nombreeL.setBounds(192, 261, 163, 20);
		modifie_livre.getContentPane().add(nombreeL);
		
		etatL = new JTextField();
		etatL.setFont(new Font("Tahoma", Font.BOLD, 12));
		etatL.setColumns(10);
		etatL.setBounds(192, 305, 163, 20);
		modifie_livre.getContentPane().add(etatL);
		
		codeL = new JTextField();
		codeL.setFont(new Font("Tahoma", Font.BOLD, 12));
		codeL.setColumns(10);
		codeL.setBounds(192, 57, 163, 20);
		modifie_livre.getContentPane().add(codeL);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(32, 109, 127, 14);
		modifie_livre.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Auteur");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(32, 146, 127, 20);
		modifie_livre.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_6 = new JLabel("Code");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(32, 60, 127, 14);
		modifie_livre.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Date de publication");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(32, 225, 141, 21);
		modifie_livre.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Nombre de page");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(30, 188, 185, 24);
		modifie_livre.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Nombre d'exemplaire");
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBounds(31, 263, 151, 17);
		modifie_livre.getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Etat");
		lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_5_1.setBounds(32, 308, 141, 14);
		modifie_livre.getContentPane().add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Emplacement");
		lblNewLabel_1_6_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_6_1.setBounds(30, 338, 173, 14);
		modifie_livre.getContentPane().add(lblNewLabel_1_6_1);
		
		emplacementL = new JTextField();
		emplacementL.setColumns(10);
		emplacementL.setBounds(192, 336, 163, 20);
		modifie_livre.getContentPane().add(emplacementL);
		
		datepL = new JTextField();
		datepL.setFont(new Font("Tahoma", Font.BOLD, 12));
		datepL.setColumns(10);
		datepL.setBounds(192, 230, 163, 20);
		modifie_livre.getContentPane().add(datepL);
		
		JButton btnValiderL = new JButton("Valider");
		btnValiderL.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnValiderL.setBounds(182, 382, 99, 28);
		modifie_livre.getContentPane().add(btnValiderL);
	}
}
