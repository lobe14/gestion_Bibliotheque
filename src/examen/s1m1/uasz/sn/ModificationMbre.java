package examen.s1m1.uasz.sn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ModificationMbre {

	JFrame modifie_mbre;
	private JTextField prenomM;
	private JTextField nomM;
	private JTextField telephoneM;
	private JTextField emailM;
	private JTextField adresseM;
	private JTextField codeM;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificationMbre modMbre = new ModificationMbre();
//					modMbre.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ModificationMbre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modifie_mbre = new JFrame();
		modifie_mbre.setBounds(300, 100, 344, 427);
		modifie_mbre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifie_mbre.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mofication d'un membre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(73, 11, 226, 28);
		modifie_mbre.getContentPane().add(lblNewLabel);
		
		prenomM = new JTextField();
		prenomM.setFont(new Font("Tahoma", Font.BOLD, 12));
		prenomM.setColumns(10);
		prenomM.setBounds(153, 123, 163, 20);
		modifie_mbre.getContentPane().add(prenomM);
		
		nomM = new JTextField();
		nomM.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomM.setColumns(10);
		nomM.setBounds(153, 162, 163, 20);
		modifie_mbre.getContentPane().add(nomM);
		
		telephoneM = new JTextField();
		telephoneM.setFont(new Font("Tahoma", Font.BOLD, 12));
		telephoneM.setColumns(10);
		telephoneM.setBounds(153, 191, 163, 20);
		modifie_mbre.getContentPane().add(telephoneM);
		
		emailM = new JTextField();
		emailM.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailM.setColumns(10);
		emailM.setBounds(153, 225, 163, 20);
		modifie_mbre.getContentPane().add(emailM);
		
		adresseM = new JTextField();
		adresseM.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresseM.setColumns(10);
		adresseM.setBounds(153, 260, 163, 20);
		modifie_mbre.getContentPane().add(adresseM);
		
		JComboBox professionM = new JComboBox();
		professionM.setModel(new DefaultComboBoxModel(new String[] {"Etudiant UASZ", "Ensiegnant UASZ", "Eleve", "Prefessionnel", "Personne externe"}));
		professionM.setFont(new Font("Tahoma", Font.BOLD, 12));
		professionM.setBounds(153, 298, 163, 22);
		modifie_mbre.getContentPane().add(professionM);
		
		codeM = new JTextField();
		codeM.setFont(new Font("Tahoma", Font.BOLD, 12));
		codeM.setColumns(10);
		codeM.setBounds(153, 74, 163, 20);
		modifie_mbre.getContentPane().add(codeM);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(32, 123, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(32, 162, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(32, 191, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(32, 225, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresse");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(32, 260, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Profession");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(32, 299, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Code");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(32, 74, 127, 14);
		modifie_mbre.getContentPane().add(lblNewLabel_1_6);
		
		JButton btnValiderM = new JButton("Valider");
		btnValiderM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifie_mbre.dispose();
//				ModificationMbre modMbre = new ModificationMbre();
//      			modMbre.frame.setVisible(false);
//				dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnValiderM.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnValiderM.setBounds(129, 349, 99, 28);
		modifie_mbre.getContentPane().add(btnValiderM);
	}
}
