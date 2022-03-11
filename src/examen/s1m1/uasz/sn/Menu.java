package examen.s1m1.uasz.sn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.DebugGraphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JEditorPane;



public class Menu extends JFrame implements ActionListener {

	protected static final WindowListener AcceuilGestionnaire = null;
	private JPanel contentPane;
	private JTextField prenom;
	private JTextField nom;
	private JTextField telephone;
	private JTextField email;
	private JTextField adresse;
	private JTextField profession;
	private JTable tableMbres;
	private JTextField titre;
	private JTextField auteur;
	private JTextField datep;
	private JTextField nombrePage;
	private JTextField nombreExemplaire;
	private JTextField etat;
	private JTextField emplacement;
	private JTable tableLivres;
	private JPanel Membres;
	
	//Variable base de données
	private static String url="jdbc:mysql://localhost:3306/bu_uasz?serverTimezone=UTC";
	private static String user0 ="root";
	private static String mdp0="";
	private static Connection conn=null;
	private JTextField textField;
	private JTextField hoixLivre;
	protected ModificationMbre ModificationMbre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1610, 867);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel PaneHaut = new JPanel();
		PaneHaut.setBounds(0, 0, 276, 268);
		PaneHaut.setBackground(Color.WHITE);
		PaneHaut.setLayout(null);
		contentPane.add(PaneHaut);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setIcon(new ImageIcon("D:\\LOGOUASZ.jpg"));
		lblNewLabel.setBounds(0, 0, 274, 265);
		PaneHaut.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(275, -22, 1351, 839);
		contentPane.add(tabbedPane);
		
		JPanel Acceuil = new JPanel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("images/uasz4.jpg"));
		Acceuil.setVisible(false);
		Acceuil.setRequestFocusEnabled(false);
		Acceuil.setOpaque(false);
		tabbedPane.addTab("New tab", null, Acceuil, null);
		tabbedPane.setEnabledAt(0, true);
		Acceuil.setLayout(new BoxLayout(Acceuil, BoxLayout.X_AXIS));
		
		JPanel panelAcceuil = new JPanel();
		Acceuil.add(panelAcceuil);
		panelAcceuil.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Mamadou SOW\\Desktop\\TP Java\\Projet PA\\images\\uasz4.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1317, 811);
		panelAcceuil.add(lblNewLabel_3);
		
		
		JPanel Documents = new JPanel();
		Documents.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Documents.setVisible(false);
		Documents.setOpaque(false);
		tabbedPane.addTab("New tab", null, Documents, null);
		tabbedPane.setEnabledAt(1, true);
		Documents.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ajouter livre");
		lblNewLabel_2_1.setBounds(10, 11, 231, 23);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Documents.add(lblNewLabel_2_1);
		
		titre = new JTextField();
		titre.setBounds(183, 60, 174, 20);
		titre.setColumns(10);
		Documents.add(titre);
		
		JLabel lblNewLabel_1_7 = new JLabel("Titre");
		lblNewLabel_1_7.setBounds(10, 63, 173, 14);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_7);
		
		auteur = new JTextField();
		auteur.setBounds(183, 99, 174, 20);
		auteur.setColumns(10);
		Documents.add(auteur);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Auteur");
		lblNewLabel_1_1_1.setBounds(10, 102, 173, 14);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_1_1);
		
		datep = new JTextField();
		datep.setBounds(183, 128, 174, 20);
		datep.setColumns(10);
		Documents.add(datep);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("date de publication");
		lblNewLabel_1_2_1.setBounds(10, 127, 173, 21);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Nombre de page");
		lblNewLabel_1_3_1.setBounds(10, 165, 173, 24);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Nombre d'exemplaire");
		lblNewLabel_1_4_1.setBounds(10, 200, 190, 17);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_4_1);
		
		nombrePage = new JTextField();
		nombrePage.setBounds(183, 162, 174, 20);
		nombrePage.setColumns(10);
		Documents.add(nombrePage);
		
		nombreExemplaire = new JTextField();
		nombreExemplaire.setBounds(183, 197, 174, 20);
		nombreExemplaire.setColumns(10);
		Documents.add(nombreExemplaire);
		
		etat = new JTextField();
		etat.setBounds(183, 234, 174, 20);
		etat.setColumns(10);
		Documents.add(etat);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Emplacement");
		lblNewLabel_1_6_1.setBounds(10, 273, 173, 14);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Etat");
		lblNewLabel_1_5_1.setBounds(10, 237, 173, 14);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Documents.add(lblNewLabel_1_5_1);
		
		emplacement = new JTextField();
		emplacement.setBounds(183, 270, 174, 20);
		emplacement.setColumns(10);
		Documents.add(emplacement);
		
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.setBounds(6, 335, 107, 29);
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
			}
		});
		btnAjouter_1.setBackground(new Color(0, 255, 0));
		btnAjouter_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Documents.add(btnAjouter_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(380, 60, 933, 751);
		Documents.add(scrollPane);
		
		tableLivres = new JTable();
		tableLivres.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tableLivres.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		tableLivres.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(tableLivres);
		
		tableLivres.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			 
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tableLivres.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Code", "Titre", "Auteur", "Date de publication", "Nombre de page", "Nombre dexemplaire", "Etat"
			}
		));
		tableLivres.setFillsViewportHeight(true);
		tableLivres.setColumnSelectionAllowed(true);
		tableLivres.setBackground(Color.WHITE);
		
		JLabel lblListeDesOeuvres = new JLabel("Liste des oeuvres et exemplaires");
		lblListeDesOeuvres.setBounds(648, 18, 382, 31);
		lblListeDesOeuvres.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Documents.add(lblListeDesOeuvres);
		
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSupprimer_1.setBackground(Color.RED);
		btnSupprimer_1.setBounds(248, 335, 118, 29);
		Documents.add(btnSupprimer_1);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificationMbre modLivre = new ModificationMbre();
       			modLivre.modifie_mbre.setVisible(true);

			}
		});
		btnModifier_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnModifier_1.setBackground(new Color(65, 105, 225));
		btnModifier_1.setBounds(123, 335, 118, 29);
		Documents.add(btnModifier_1);
		
		JButton btnChercherLivre = new JButton("Chercher ");
		btnChercherLivre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnChercherLivre.setBackground(Color.CYAN);
		btnChercherLivre.setBounds(6, 398, 115, 29);
		Documents.add(btnChercherLivre);
		
		hoixLivre = new JTextField();
		hoixLivre.setColumns(10);
		hoixLivre.setBounds(126, 401, 86, 27);
		Documents.add(hoixLivre);
		
		JLabel lblNewLabel_4_1 = new JLabel("par");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(222, 400, 46, 27);
		Documents.add(lblNewLabel_4_1);
		
		JComboBox choixMembre_1 = new JComboBox();
		choixMembre_1.setModel(new DefaultComboBoxModel(new String[] {"Titre", "Auteur"}));
		choixMembre_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choixMembre_1.setBounds(251, 400, 103, 27);
		Documents.add(choixMembre_1);
		
		JPanel emprunts = new JPanel();
		emprunts.setOpaque(false);
		emprunts.setVisible(false);
		tabbedPane.addTab("New tab", null, emprunts, null);
		emprunts.setLayout(null);
		
		JLabel panel02 = new JLabel("Gestion des R\u00E9servations et Emprunts");
		panel02.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel02.setBackground(new Color(240, 240, 240));
		panel02.setBounds(304, 11, 571, 41);
		emprunts.add(panel02);
		
		Membres = new JPanel();
		Membres.setBorder(null);
		Membres.setBounds(205, 195, 856, 575);
		Membres.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		Membres.setVisible(false);
		tabbedPane.addTab("New tab", null, Membres, null);
		Membres.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setBounds(51, 96, 107, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setBounds(51, 135, 107, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_1_2.setBounds(51, 160, 107, 27);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setBounds(51, 198, 107, 14);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresse");
		lblNewLabel_1_4.setBounds(51, 233, 107, 14);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Profession");
		lblNewLabel_1_5.setBounds(51, 270, 107, 14);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setBounds(51, 306, 107, 14);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		Membres.add(lblNewLabel_1_6);
		
		//Bouton ajout membre
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Prenom=prenom.getText();
				String Nom=nom.getText();
				String Telephone=telephone.getText();
				String Email=email.getText();
				String Adresse=adresse.getText();
				String Profession=profession.getSelectedText(); 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn=DriverManager.getConnection(url,user0,mdp0);
					 Statement st=conn.createStatement();
				     st.executeUpdate(" INSERT INTO `users` (`Code`,`Prenom`, `Nom`, `Telephone`, `Email`, `Adresse`, `Profession`) VALUES (NULL, '"+Prenom+"', '"+Nom+"', '"+Telephone+"', '"+Email+"', '"+Adresse+"', '"+Profession+"');");
				     
				     JOptionPane.showMessageDialog(null,"Membre ajouté avec succés");
				    // afficherMembres();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAjouter.setBounds(10, 365, 103, 29);
		btnAjouter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Membres.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificationMbre modMbre = new ModificationMbre();
				modMbre.modifie_mbre.setVisible(true);
				
			}
		});
		btnModifier.setBounds(123, 365, 103, 29);
		btnModifier.setBackground(new Color(65, 105, 225));
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Membres.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(236, 365, 115, 29);
		btnSupprimer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Membres.add(btnSupprimer);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.BOLD, 12));
		prenom.setBounds(180, 90, 171, 20);
		Membres.add(prenom);
		prenom.setColumns(10);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom.setBounds(180, 129, 171, 20);
		nom.setColumns(10);
		Membres.add(nom);
		
		telephone = new JTextField();
		telephone.setFont(new Font("Tahoma", Font.BOLD, 12));
		telephone.setBounds(180, 158, 171, 20);
		telephone.setColumns(10);
		Membres.add(telephone);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(180, 192, 171, 20);
		email.setColumns(10);
		Membres.add(email);
		
		adresse = new JTextField();
		adresse.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresse.setBounds(180, 227, 171, 20);
		adresse.setColumns(10);
		Membres.add(adresse);
		
		profession = new JTextField();
		profession.setFont(new Font("Tahoma", Font.BOLD, 12));
		profession.setBounds(180, 300, 171, 20);
		profession.setColumns(10);
		Membres.add(profession);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter un membre");
		lblNewLabel_2.setBounds(99, 43, 224, 23);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Membres.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(380, 31, 933, 780);
		Membres.add(scrollPane_1);
		
		tableMbres = new JTable();
		tableMbres.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
		tableMbres.setEnabled(true);
		tableMbres.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
		tableMbres.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		scrollPane_1.setViewportView(tableMbres);
		tableMbres.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tableMbres.setToolTipText("");
		tableMbres.setSurrendersFocusOnKeystroke(true);
		tableMbres.setColumnSelectionAllowed(true);
		tableMbres.setFillsViewportHeight(true);
		tableMbres.setBackground(Color.LIGHT_GRAY);
		tableMbres.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Code", "Pr\u00E9nom", "Nom", "T\u00E9l\u00E9phone", "Email", "Profession"
			}
		));
		tableMbres.getColumnModel().getColumn(0).setMinWidth(10);
		tableMbres.getColumnModel().getColumn(1).setMinWidth(18);
		tableMbres.getColumnModel().getColumn(2).setMinWidth(13);
		tableMbres.getColumnModel().getColumn(4).setMinWidth(19);
		tableMbres.getColumnModel().getColumn(5).setMinWidth(16);
		
		JLabel lblListeDesMembres = new JLabel("Liste des membres de la biblioth\u00E9que de l'UASZ");
		lblListeDesMembres.setBounds(714, 11, 382, 23);
		lblListeDesMembres.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Membres.add(lblListeDesMembres);
		
		JComboBox profession_1 = new JComboBox();
		profession_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		profession_1.setModel(new DefaultComboBoxModel(new String[] {"Etudiant UASZ", "Ensiegnant UASZ", "Eleve", "Prefessionnel", "Personne externe"}));
		profession_1.setBounds(180, 265, 171, 22);
		Membres.add(profession_1);
		
		JComboBox choixMembre = new JComboBox();
		choixMembre.setModel(new DefaultComboBoxModel(new String[] {"Prenom", "Profession", "Telephone", "Email"}));
		choixMembre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choixMembre.setBounds(255, 458, 103, 27);
		Membres.add(choixMembre);
		
		JButton btnAfficherMembre = new JButton("Chercher ");
		btnAfficherMembre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAfficherMembre.setBackground(Color.CYAN);
		btnAfficherMembre.setBounds(10, 456, 115, 29);
		Membres.add(btnAfficherMembre);
		
		textField = new JTextField();
		textField.setBounds(130, 459, 86, 27);
		Membres.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("par");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(226, 458, 46, 27);
		Membres.add(lblNewLabel_4);
		DefaultTableModel model= new DefaultTableModel();
		
		JButton btnGestionUsages = new JButton("Gestion des usages");
		btnGestionUsages.setBounds(61, 279, 177, 38);
		contentPane.add(btnGestionUsages);
		btnGestionUsages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil.setVisible(false);
				panelAcceuil.setVisible(false);
				Membres.setVisible(true);
				Documents.setVisible(false);
				emprunts.setVisible(false);
			
			
			}
		});
		btnGestionUsages.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnGestionOeuvreEtExplaires = new JButton("Oeuvres et exemplaires");
		btnGestionOeuvreEtExplaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil.setVisible(false);
				Membres.setVisible(false);
				Documents.setVisible(true);
				emprunts.setVisible(false);
			}
		});
		btnGestionOeuvreEtExplaires.setBounds(26, 341, 231, 38);
		contentPane.add(btnGestionOeuvreEtExplaires);
		btnGestionOeuvreEtExplaires.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnReservationEtEmprunts = new JButton("Reservations et emprunts");
		btnReservationEtEmprunts.setBounds(26, 405, 231, 36);
		contentPane.add(btnReservationEtEmprunts);
		btnReservationEtEmprunts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil.setVisible(false);
				Membres.setVisible(false);
				Documents.setVisible(false);
				emprunts.setVisible(true);
				
			}
		});
		btnReservationEtEmprunts.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Authentification auth = new Authentification();
				auth.frame.setVisible(true);
				
			}
		});
		btnDeconnection.setBounds(69, 465, 135, 35);
		contentPane.add(btnDeconnection);
		btnDeconnection.setFont(new Font("Times New Roman", Font.BOLD, 18));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JTable getTableLivres() {
		return tableLivres;
	}
	}
