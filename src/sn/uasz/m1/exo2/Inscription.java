package sn.uasz.m1.exo2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Inscription extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Container cont2=getContentPane();
	JLabel msg=new JLabel("Formuaire d'inscription des membres du club");
	String[] prof= {"Comptabe","Etudiant","Developpeur","Infirmier","Ensiégnant"};
	JLabel id=new JLabel("Identifient");
	JTextField textId=new JTextField();
	JLabel prenom=new JLabel("Prénom");
	JTextField textPrenom=new JTextField();
	JLabel nom=new JLabel("Nom");
	JTextField textNom=new JTextField("");
	JLabel sexe=new JLabel("Sexe");
	JRadioButton textSexeH=new JRadioButton("Homme",true);
	JRadioButton textSexeF=new JRadioButton("Femme");
	JLabel profil=new JLabel();
	JComboBox<String> textProfil=new JComboBox<String>(prof); 
	JLabel Date=new JLabel("Date d'adhesion");
	JTextField textDate=new JTextField();
	JLabel mail=new JLabel("Email");
	JFormattedTextField textMail=new JFormattedTextField();
	ButtonGroup bg=new ButtonGroup();
	JButton ajout=new JButton("Ajouter");
	
	private static String url="jdbc:mysql://localhost:3306/club?serverTimezone=UTC";
	private static String user ="root";
	private static String mdp="";
	private static Connection connexion=null;
	
	
public Inscription() {
	super("Inscription");
	this.setVisible(true);
	this.setBounds(5,5,500,480);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocationRelativeTo(null);
	addComponentsToContainer();
	setLocationAndSize();
	setLayoutManager();
	
	
	try{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
	connexion=DriverManager.getConnection(url,user,mdp);
	}catch(Exception e ){
		e.printStackTrace();
	}
}

private void setLayoutManager() {
	cont2.setLayout(null);
	
}

private void setLocationAndSize() {
	msg.setBounds(85,50,300,30);
	prenom.setBounds(75,100,100,30);
	textPrenom.setBounds(170, 100,150,25);
	nom.setBounds(75,140,120,30);
	textNom.setBounds(170, 140,150,25);
	sexe.setBounds(75,190,100,30);
	textSexeH.setBounds(170, 190,100,25);
	textSexeF.setBounds(270,190,100,25);
	
	profil.setBounds(75,260,100,30);
	textProfil.setBounds(170, 260,150,20);
	
	Date.setBounds(75,300,100,30);
	textDate.setBounds(170, 300,150,25);
	
	mail.setBounds(75,340,100,30);
	textMail.setBounds(170, 340,150,25);
	
	ajout.setBounds(200,400,100,30);
		
}

private void addComponentsToContainer() {
	cont2.add(msg);
	cont2.add(id);
	cont2.add(textId);
	cont2.add(prenom);
	cont2.add(textPrenom);
	cont2.add(nom);
	cont2.add(textNom);
	cont2.add(sexe);
	cont2.add(textSexeH);
	cont2.add(textSexeF);
	cont2.add(profil);
	cont2.add(textProfil);
	cont2.add(Date);
	cont2.add(textDate);
	cont2.add(mail);
	cont2.add(textMail);
	cont2.add(ajout);
	bg.add(textSexeH);
	bg.add(textSexeF);
	
ajout.addActionListener( new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		String nom=textNom.getText();
		String sexe;
		if(textSexeH.isSelected()) {
			sexe="Homme";
		}else
			sexe="Femme";
		String profil=(String) textProfil.getSelectedItem();
		String dateA=textDate.getText();
		String email=textMail.getText();
		try {
			String prenom=textPrenom.getText();
			if( prenom.equals("")||nom.equals(" ")||dateA.equals("")||email.equals("") ) {
				JOptionPane.showMessageDialog(null, "champ(s) incomplet(s)");
				
			}
		 Statement st=connexion.createStatement();
	     st.executeUpdate("INSERT INTO `membre` (`Prenom`, `Nom`, `Sexe`, `Profession`, `DateAdhesion`, `Email`) VALUES ('"+prenom+"', '"+nom+"', '"+sexe+"', '"+profil+"', '"+dateA+"', '"+email+"') ");
	     JOptionPane.showMessageDialog(null,"Membre ajouté avec succés");
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null,"Attention ! doublon(s) détecte(s)");
			e1.printStackTrace();
		}
			
}

});
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}